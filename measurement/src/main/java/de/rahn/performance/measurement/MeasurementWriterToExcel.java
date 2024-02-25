/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static de.rahn.performance.measurement.Statistics.TITLES;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;

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
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatterBuilder;

/**
 * Schreibe die aktuelle Messung in ein Excel-Sheet.
 *
 * @author Frank W. Rahn
 */
public class MeasurementWriterToExcel {

  /**
   * Spaltenbreite 23 mm
   */
  private static final int COLUMN_WIDTH = 23;

  /**
   * Der {@link CellStyle} für die Überschriften.
   */
  private final CellStyle CELLSTYLE_HEADER;

  /**
   * Der {@link CellStyle} für die Fließkommazahlen.
   */
  private final CellStyle CELLSTYLE_DOUBLE;

  /**
   * Das Arbeitsblatt.
   */
  private final Workbook workbook;

  /**
   * Die Datei für das Sheet.
   */
  private final File file;

  private final String timeStamp;

  /**
   * @param fileName der Name der Ausgabedatei
   */
  public MeasurementWriterToExcel(String fileName) {
    super();

    file = new File(fileName + ".xlsx");

    workbook = new XSSFWorkbook();

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);

    CELLSTYLE_HEADER = workbook.createCellStyle();
    CELLSTYLE_HEADER.setAlignment(CENTER);
    CELLSTYLE_HEADER.setFont(headerFont);

    CELLSTYLE_DOUBLE = workbook.createCellStyle();
    CELLSTYLE_DOUBLE.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00000"));

    timeStamp = new DateTimeFormatterBuilder().appendDayOfWeek(2).appendLiteral('.').appendMonthOfYear(2)
        .appendLiteral('.')
        .appendYear(4, 4).appendLiteral(" um ").appendHourOfDay(2).appendLiteral(':').appendMinuteOfHour(2)
        .appendLiteral(" Uhr").toFormatter().print(new DateTime());
  }

  /**
   * Schreibe die Messung.
   *
   * @param meteringPointNames die Liste der Namen der Messpunkte
   * @param measurements       die Messung
   */
  public void processMeasurement(List<String> meteringPointNames, Map<String, Statistics> measurements) {
    // Die Messwerte mit der Zusammenfassung
    Sheet sheet = createSheet("Performanz Messung");

    int row = writeSummary(sheet, meteringPointNames, measurements);

    //noinspection UnusedAssignment
    row = writeAverages(sheet, row, meteringPointNames, measurements);

    sheet.createFreezePane(1, 0);
  }

  /**
   * Schreibe die Aufwärmphase.
   *
   * @param meteringPointNames die Liste der Namen der Messpunkte
   * @param measurements       die Messung
   */
  public void processWarmUp(List<String> meteringPointNames, Map<String, Statistics> measurements) {
    Sheet sheet = createSheet("Warmlaufen");

    writeSummary(sheet, meteringPointNames, measurements);

    sheet.createFreezePane(1, 2);
  }

  /**
   * Speichere die Datei.
   *
   * @throws IOException, falls ein IO-Problem aufgetreten ist
   */
  public void save() throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      workbook.write(fileOutputStream);
    }
  }

  /**
   * Erzeuge ein Sheet und konfiguriere es.
   *
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
   * Schreibe die Zusammenfassung dieser Messung.
   *
   * @param sheet              das aktuelle Sheet
   * @param meteringPointNames die Liste der Namen der Messpunkte
   * @param measurements       die Messung
   * @return die nächste Zeilennummer
   */
  private int writeSummary(Sheet sheet, List<String> meteringPointNames, Map<String, Statistics> measurements) {
    // Laufende Zeilennummer
    int row = 0;

    // Datum schreiben
    Row headerRow = sheet.createRow(row++);
    Cell headerCell = headerRow.createCell(0);
    headerCell.setCellValue(timeStamp);
    headerCell.setCellStyle(CELLSTYLE_HEADER);

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
   *
   * @param sheet              das aktuelle Sheet
   * @param row                die nächste Zeilennummer
   * @param meteringPointNames die Liste der Namen der Messpunkte
   * @param measurements       die Messung
   * @return die nächste Zeilennummer
   */
  private int writeAverages(Sheet sheet, int row, List<String> meteringPointNames,
      Map<String, Statistics> measurements) {
    // Tabelle:
    // __|_10|_100|1000|...
    // M1|_W1|____|__W2|...
    // M2|_W3|__W4|__W5|...
    Map<Long, BigDecimal[]> table = new HashMap<>();
    List<Long> numberOfValues = new ArrayList<>();
    final int SIZE = createDataTable(meteringPointNames, measurements, table, numberOfValues);

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
      Cell contentCell = contentRow.createCell(0);
      contentCell.setCellValue(meteringPointNames.get(i));

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
   * Ermittle die Mittelwerte und stelle die Tabelle zusammen. Einzelne Messwerte können fehlen ...
   *
   * @param meteringPointNames die Liste der Namen der Messpunkte
   * @param measurements       die Messung
   * @param table              die Tabelle mit den Messwerten
   * @param numberOfValues     die Zeile mit der Anzahl der Messwerte, aus denen die Mittelwerte gebildet wurden
   * @return die Anzahl der Zeilen
   */
  private int createDataTable(List<String> meteringPointNames, Map<String, Statistics> measurements,
      Map<Long, BigDecimal[]> table, List<Long> numberOfValues) {
    final int size = meteringPointNames.size();

    for (Statistics statistics : measurements.values()) {
      // Welche Zeile ist dran?
      int index = meteringPointNames.indexOf(statistics.getMeteringPointName());

      if (index < 0) {
        // Unbekannter Messpunkt → Ignorieren
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
}
