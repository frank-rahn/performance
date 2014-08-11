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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatterBuilder;

/**
 * Schreibe die aktuelle Messung in ein Excel-Sheet.
 * @author Frank W. Rahn
 */
public class MeasurementWriterToExcel {

	/** Spaltenbreite 23mm */
	private static final int COLUMN_WIDTH = 23;

	/** Der {@link CellStyle} für die Überschriften. */
	private final CellStyle CELLSTYLE_HEADER;

	/** Der {@link CellStyle} für die Fließkommazahlen. */
	private final CellStyle CELLSTYLE_DOUBLE;

	/** Das Arbeitsblatt. */
	private final Workbook workbook;

	/** Die Datei für das Sheet. */
	private final File file;

	private final String timeStamp;

	/**
	 * @param fileName Der Name der Ausgabedatei
	 */
	public MeasurementWriterToExcel(String fileName) {
		super();

		file = new File(fileName + ".xlsx");

		workbook = new XSSFWorkbook();

		Font headerFont = workbook.createFont();
		headerFont.setBoldweight(BOLDWEIGHT_BOLD);

		CELLSTYLE_HEADER = workbook.createCellStyle();
		CELLSTYLE_HEADER.setAlignment(ALIGN_CENTER);
		CELLSTYLE_HEADER.setFont(headerFont);

		CELLSTYLE_DOUBLE = workbook.createCellStyle();
		CELLSTYLE_DOUBLE.setDataFormat(workbook.createDataFormat().getFormat(
				"#,##0.00000"));

		timeStamp =
				new DateTimeFormatterBuilder().appendDayOfWeek(2)
				.appendLiteral('.').appendMonthOfYear(2).appendLiteral('.')
				.appendYear(4, 4).appendLiteral(" um ").appendHourOfDay(2)
				.appendLiteral(':').appendMinuteOfHour(2).appendLiteral(" Uhr")
				.toFormatter().print(new DateTime());
	}

	/**
	 * Schreibe die Messung.
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 */
	public void processMeasurement(List<String> meteringPointNames,
		Map<String, Statistics> measurements) {
		// Die Messwerte mit der Zusammenfassung
		Sheet sheet = createSheet("Performanz Messung");

		int row = writeSummary(sheet, meteringPointNames, measurements);

		row = writeAverages(sheet, row, meteringPointNames, measurements);

		sheet.createFreezePane(1, 0);

		// Die Rohdaten
		sheet = createSheet("Rohdaten");

		writeRawData(sheet, meteringPointNames, measurements);
	}

	/**
	 * Schreibe die Aufwärmphase.
	 * @param die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 */
	public void processWarmUp(List<String> meteringPointNames,
		Map<String, Statistics> measurements) {
		Sheet sheet = createSheet("Warmlaufen");

		writeSummary(sheet, meteringPointNames, measurements);

		sheet.createFreezePane(1, 2);
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
			fileOutputStream.close();
		}
	}

	/**
	 * Erzeuge ein Sheet und konfiguriere es.
	 * @param name der Name des Sheets
	 * @return das Sheet
	 */
	private Sheet createSheet(String name) {
		int i = 0;
		String temp = name;
		Sheet sheet;
		while (true) {
			sheet = workbook.getSheet(temp);

			if (sheet == null) {
				break;
			}

			temp = name + "_" + i++;
		}

		sheet = workbook.createSheet(temp);
		sheet.setDefaultColumnWidth(COLUMN_WIDTH);
		return sheet;
	}

	/**
	 * Schreibe die Zusammanfassung dieser Messung.
	 * @param sheet das aktuelle Sheet
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 * @return die nächste Zeilennummer
	 */
	private int writeSummary(Sheet sheet, List<String> meteringPointNames,
		Map<String, Statistics> measurements) {
		// Laufende Zeilennummer
		int row = 0;

		// Datum schreiben
		Row headerRow = sheet.createRow(row++);
		Cell hcell = headerRow.createCell(0);
		hcell.setCellValue(timeStamp);
		hcell.setCellStyle(CELLSTYLE_HEADER);

		// Überschrift
		headerRow = sheet.createRow(row++);
		for (int column = 0; column < TITLES.length; column++) {
			Cell cell = headerRow.createCell(column);
			cell.setCellValue(TITLES[column]);
			cell.setCellStyle(CELLSTYLE_HEADER);
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
			cell.setCellStyle(CELLSTYLE_DOUBLE);

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.standardDeviation().doubleValue());
			cell.setCellStyle(CELLSTYLE_DOUBLE);

			cell = contentRow.createCell(cell.getColumnIndex() + 1);
			cell.setCellValue(statistics.getLast());
		}

		return ++row;
	}

	/**
	 * Schreibe die Messreihen der arth. Mittelwerte.
	 * @param sheet das aktuelle Sheet
	 * @param row die nächste Zeilennummer
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 * @return die nächste Zeilennummer
	 */
	private int writeAverages(Sheet sheet, int row,
		List<String> meteringPointNames, Map<String, Statistics> measurements) {
		// Tabelle:
		// __|_10|_100|1000|...
		// M1|_W1|____|__W2|...
		// M2|_W3|__W4|__W5|...
		Map<Long, BigDecimal[]> table = new HashMap<>();
		List<Long> numberOfValues = new ArrayList<>();
		final int SIZE =
				createDataTable(meteringPointNames, measurements, table,
					numberOfValues);

		// X-Zeile sortieren
		Collections.sort(numberOfValues);

		// Schreibe die X-Zeile
		Row headerRow = sheet.createRow(++row);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Messreihen");
		headerCell.setCellStyle(CELLSTYLE_HEADER);
		for (int column = 0; column < numberOfValues.size(); column++) {
			Cell cell = headerRow.createCell(column + 1);
			cell.setCellValue(numberOfValues.get(column));
			cell.setCellStyle(CELLSTYLE_HEADER);
		}

		// Schreibe die Messreihen
		for (int i = 0; i < SIZE; i++) {
			Row contentRow = sheet.createRow(++row);
			Cell xcell = contentRow.createCell(0);
			xcell.setCellValue(meteringPointNames.get(i));

			for (int column = 0; column < numberOfValues.size(); column++) {
				BigDecimal d = table.get(numberOfValues.get(column))[i];

				// Einzelne Messwerte können leer sein
				if (d != null) {
					Cell cell = contentRow.createCell(column + 1);
					cell.setCellValue(d.doubleValue());
					cell.setCellStyle(CELLSTYLE_DOUBLE);
				}
			}
		}

		return ++row;
	}

	/**
	 * Ermittle die Mittelwerte und stelle die Tabelle zusammen. Einzelne
	 * Messwert können fehlen...
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 * @param table die Tabelle mit den Messwerten
	 * @param numberOfValues die Zeile mit den Anzahl der Messwerten, aus denen
	 *        die Mittelwerte gebildet wurden
	 * @return die Anzahl der Zeilen
	 */
	private int createDataTable(List<String> meteringPointNames,
		Map<String, Statistics> measurements, Map<Long, BigDecimal[]> table,
		List<Long> numberOfValues) {
		final int size = meteringPointNames.size();

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

		return size;
	}

	/**
	 * Schreibe die Rowdaten.
	 * @param sheet das aktuelle Sheet
	 * @param meteringPointNames die Liste der Namen der Messpunkte
	 * @param measurements die Messung
	 * @return die nächste Zeilennummer
	 */
	private int writeRawData(Sheet sheet, List<String> meteringPointNames,
		Map<String, Statistics> measurements) {

		// Erstelle eine Liste der X-Achse
		Set<Long> temp = new LinkedHashSet<>();
		for (String meteringPointName : meteringPointNames) {
			Statistics statistics = measurements.get(meteringPointName);
			temp.addAll(statistics.getSeries().keySet());
		}
		List<Long> x = new ArrayList<>(temp);
		Collections.sort(x);

		int row = 0;
		Row headerRow = sheet.createRow(row++);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Counter");
		headerCell.setCellStyle(CELLSTYLE_HEADER);
		for (int column = 0; column < meteringPointNames.size(); column++) {
			Cell cell = headerRow.createCell(column + 1);
			cell.setCellValue(meteringPointNames.get(column));
			cell.setCellStyle(CELLSTYLE_HEADER);
		}

		for (long counter : x) {
			Row contentRow = sheet.createRow(row++);
			Cell cell = contentRow.createCell(0);
			cell.setCellValue(counter);
			for (int column = 0; column < meteringPointNames.size(); column++) {
				Statistics statistics =
					measurements.get(meteringPointNames.get(column));

				// Einzele Messwerte können null sein
				Long value = statistics.getSeries().get(counter);
				if (value != null) {
					cell = contentRow.createCell(column + 1);
					cell.setCellValue(value.longValue());
				}
			}
		}

		return ++row;
	}

}