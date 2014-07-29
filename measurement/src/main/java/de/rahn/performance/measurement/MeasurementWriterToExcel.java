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
	 *
	 */
	public MeasurementWriterToExcel(File file) {
		super();

		this.file = file;
	}

	public void processWarmUp(Map<String, Statistics> measurements) {
		Sheet sheet = workbook.createSheet("Warmlaufen");

		writeSummary(sheet, measurements);

		sheet.createFreezePane(1, 1);
	}

	public void processMeasurement(Map<String, Statistics> measurements) {
		Sheet sheet = workbook.createSheet("Messung");

		int row = writeSummary(sheet, measurements);

		// schreibe die Messreihe
		sheet.setColumnWidth(0, 18 * 256); // Spaltenbreite 18

		sheet.createFreezePane(1, 0);
	}

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
	 * @param measurements die Messung
	 * @param sheet das aktuelle Sheet
	 */
	private int writeSummary(Sheet sheet, Map<String, Statistics> measurements) {
		Font headerFont = workbook.createFont();
		headerFont.setBoldweight(BOLDWEIGHT_BOLD);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(ALIGN_CENTER);
		headerStyle.setFont(headerFont);

		// Überschrift
		Row headerRow = sheet.createRow(0);
		for (int column = 0; column < TITLES.length; column++) {
			Cell cell = headerRow.createCell(column);
			cell.setCellValue(TITLES[column]);
			cell.setCellStyle(headerStyle);
		}

		// Auswertung
		int row = 1;
		for (Statistics statistics : measurements.values()) {
			Row contentRow = sheet.createRow(row);

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

			row++;
		}

		return row;
	}

}