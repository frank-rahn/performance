/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static de.rahn.performance.measurement.Statistics.TITLES;
import static org.apache.poi.ss.usermodel.CellStyle.ALIGN_CENTER;
import static org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Schreibe die aktuelle Messung in ein Excel-Sheet.
 * @author Frank W. Rahn
 */
public class MeasurementWriterToExcel {

	private Workbook workbook = new XSSFWorkbook();

	private File file;

	/**
	 * @param fileName Der Name der Ausgabedatei
	 */
	public MeasurementWriterToExcel(String fileName) {
		super();

		file = new File(fileName + ".xlsx");
	}

	/**
	 * Schreibe die Aufwärmphase.
	 * @param die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 */
	public void processWarmUp(List<String> meteringPointNames,
		Map<String, Statistics> measurements) {
		Sheet sheet = workbook.createSheet("Warmlaufen");

		writeSummary(sheet, meteringPointNames, measurements);

		sheet.createFreezePane(1, 1);
	}

	/**
	 * Schreibe die Messung.
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 */
	public void processMeasurement(List<String> meteringPointNames,
		Map<String, Statistics> measurements) {
		Sheet sheet = workbook.createSheet("Messung");

		int row = writeSummary(sheet, meteringPointNames, measurements);

		// Anzahl der Zeilen
		final int size = meteringPointNames.size();

		// Tabelle:
		// __|_10|_100|1000|...
		// M1|_W1|____|__W2|...
		// M2|_W3|__W4|__W5|...
		Map<Long, BigDecimal[]> table = new HashMap<Long, BigDecimal[]>();
		List<Long> numberOfValues = new ArrayList<Long>();

		// Ermittle die Mittelwerte. Einzelne Messwert können fehlen...
		for (Statistics statistics : measurements.values()) {
			// Welche Zeile ist dran?
			int index =
				meteringPointNames.indexOf(statistics.getMeteringPointName());

			if (index < 0) {
				// Unbekannter Messpunkt ==> Ignorieren
				continue;
			}

			for (Statistics.Average avg : statistics.getAverages()) {
				BigDecimal[] column = table.get(avg.getNumberOfValues());

				if (column == null) {
					column = new BigDecimal[size];
					table.put(avg.getNumberOfValues(), column);
					numberOfValues.add(avg.getNumberOfValues());
				}

				column[index] = avg.getAverage();
			}
		}

		// Y-Zeile sortieren
		Collections.sort(numberOfValues);

		// Y-Überschrift
		Font headerFont = workbook.createFont();
		headerFont.setBoldweight(BOLDWEIGHT_BOLD);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(ALIGN_CENTER);
		headerStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(++row);
		for (int column = 0; column < numberOfValues.size(); column++) {
			Cell cell = headerRow.createCell(column + 1);
			cell.setCellValue(numberOfValues.get(column));
			cell.setCellStyle(headerStyle);

			// Spaltenbreite 18
			sheet.setColumnWidth(cell.getColumnIndex(), 18 * 256);
		}

		// Schreibe die Messreihe
		for (int i = 0; i < size; i++) {
			Row contentRow = sheet.createRow(++row);
			Cell xcell = contentRow.createCell(0);
			xcell.setCellValue(meteringPointNames.get(i));

			for (int column = 0; column < numberOfValues.size(); column++) {
				BigDecimal d = table.get(numberOfValues.get(column))[i];

				if (d != null) {
					Cell cell = contentRow.createCell(column + 1);
					cell.setCellValue(d.doubleValue());
				}
			}
		}

		sheet.createFreezePane(1, 0);
	}

	/**
	 * Speichere die Datei.
	 * @throws IOException falls ein IO-Problem aufgetreten ist
	 */
	public void save() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file);

		try {
			workbook.write(fileOutputStream);
		} finally {
			workbook = null;
			fileOutputStream.close();
		}
	}

	/**
	 * Schreibe die Zusammanfassung dieser Messung.
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 * @param sheet das aktuelle Sheet
	 * @return die nächste Zeilennummer
	 */
	private int writeSummary(Sheet sheet, List<String> meteringPointNames,
		Map<String, Statistics> measurements) {
		Font headerFont = workbook.createFont();
		headerFont.setBoldweight(BOLDWEIGHT_BOLD);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(ALIGN_CENTER);
		headerStyle.setFont(headerFont);

		// Laufende Zeilennummer
		int row = 0;

		// Überschrift
		Row headerRow = sheet.createRow(row++);
		for (int column = 0; column < TITLES.length; column++) {
			Cell cell = headerRow.createCell(column);
			cell.setCellValue(TITLES[column]);
			cell.setCellStyle(headerStyle);
		}

		// Auswertung
		for (String name : meteringPointNames) {
			Statistics statistics = measurements.get(name);
			Row contentRow = sheet.createRow(row++);

			Cell cell = contentRow.createCell(0);
			cell.setCellValue(statistics.getMeteringPointName());

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.getCounter());

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.getValues());

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.getMinimum());

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.getMaximum());

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.average().doubleValue());

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.getLast());
		}

		return ++row;
	}

}