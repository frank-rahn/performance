/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.testbeans;

import static java.util.Calendar.getInstance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;

/**
 * Diese Klasse erzeugt zufällig gefüllte TestBeans.
 * @author Frank W. Rahn
 */
public final class TestBeansUtils {

	/** Zufallszahlgenerator */
	private static final Random RANDOM = new Random();

	/** Die {@link ObjectFactory} für die JAXB-Objekte. */
	private static final ObjectFactory FACTORY = new ObjectFactory();

	/**
	 * Erzeuge ein zufällig gefüllte [{@link DomainRow}.
	 * @param numberOfColumns die Anzahl der zufällig gefüllten Zeichenkette im
	 *        Array {@link DomainRow#Columns}, ist der Wert <code>-1</code>,
	 *        dann wird der Wert zufällig ermittelt
	 * @return ein zufällig gefüllte [{@link DomainRow}
	 */
	public static DomainRow createDomainRow(int numberOfColumns) {
		DomainRow row = new DomainRow();

		// String
		row.setColumn00("COLUMNS_00_" + RANDOM.nextInt());
		row.setColumn01("COLUMNS_01_" + RANDOM.nextInt());
		row.setColumn02("COLUMNS_02_" + RANDOM.nextInt());
		row.setColumn03("COLUMNS_03_" + RANDOM.nextInt());
		row.setColumn04("COLUMNS_04_" + RANDOM.nextInt());
		row.setColumn05("COLUMNS_05_" + RANDOM.nextInt());
		row.setColumn06("COLUMNS_06_" + RANDOM.nextInt());
		row.setColumn07("COLUMNS_07_" + RANDOM.nextInt());
		row.setColumn08("COLUMNS_08_" + RANDOM.nextInt());
		row.setColumn09("COLUMNS_09_" + RANDOM.nextInt());

		// int
		row.setColumn10(RANDOM.nextInt());
		row.setColumn11(RANDOM.nextInt());
		row.setColumn12(RANDOM.nextInt());
		row.setColumn13(RANDOM.nextInt());
		row.setColumn14(RANDOM.nextInt());
		row.setColumn15(RANDOM.nextInt());
		row.setColumn16(RANDOM.nextInt());
		row.setColumn17(RANDOM.nextInt());
		row.setColumn18(RANDOM.nextInt());
		row.setColumn19(RANDOM.nextInt());

		// boolean
		row.setColumn20(RANDOM.nextBoolean());
		row.setColumn21(RANDOM.nextBoolean());
		row.setColumn22(RANDOM.nextBoolean());
		row.setColumn23(RANDOM.nextBoolean());
		row.setColumn24(RANDOM.nextBoolean());
		row.setColumn25(RANDOM.nextBoolean());
		row.setColumn26(RANDOM.nextBoolean());
		row.setColumn27(RANDOM.nextBoolean());
		row.setColumn28(RANDOM.nextBoolean());
		row.setColumn29(RANDOM.nextBoolean());

		// long
		row.setColumn30(RANDOM.nextLong());
		row.setColumn31(RANDOM.nextLong());
		row.setColumn32(RANDOM.nextLong());
		row.setColumn33(RANDOM.nextLong());
		row.setColumn34(RANDOM.nextLong());
		row.setColumn35(RANDOM.nextLong());
		row.setColumn36(RANDOM.nextLong());
		row.setColumn37(RANDOM.nextLong());
		row.setColumn38(RANDOM.nextLong());
		row.setColumn39(RANDOM.nextLong());

		// BigDecimal
		row.setColumn40(new BigDecimal(RANDOM.nextInt()));
		row.setColumn41(new BigDecimal(RANDOM.nextInt()));
		row.setColumn42(new BigDecimal(RANDOM.nextInt()));
		row.setColumn43(new BigDecimal(RANDOM.nextInt()));
		row.setColumn44(new BigDecimal(RANDOM.nextInt()));
		row.setColumn45(new BigDecimal(RANDOM.nextInt()));
		row.setColumn46(new BigDecimal(RANDOM.nextInt()));
		row.setColumn47(new BigDecimal(RANDOM.nextInt()));
		row.setColumn48(new BigDecimal(RANDOM.nextInt()));
		row.setColumn49(new BigDecimal(RANDOM.nextInt()));

		// Calendar
		Calendar c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn50(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn51(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn54(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn55(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn56(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn57(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn58(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn59(c);

		// String
		row.setColumn60("COLUMNS_60_" + RANDOM.nextInt());
		row.setColumn61("COLUMNS_61_" + RANDOM.nextInt());
		row.setColumn62("COLUMNS_62_" + RANDOM.nextInt());
		row.setColumn63("COLUMNS_63_" + RANDOM.nextInt());
		row.setColumn64("COLUMNS_64_" + RANDOM.nextInt());
		row.setColumn65("COLUMNS_65_" + RANDOM.nextInt());
		row.setColumn66("COLUMNS_66_" + RANDOM.nextInt());
		row.setColumn67("COLUMNS_67_" + RANDOM.nextInt());
		row.setColumn68("COLUMNS_68_" + RANDOM.nextInt());
		row.setColumn69("COLUMNS_69_" + RANDOM.nextInt());

		// int
		row.setColumn70(RANDOM.nextInt());
		row.setColumn71(RANDOM.nextInt());
		row.setColumn72(RANDOM.nextInt());
		row.setColumn73(RANDOM.nextInt());
		row.setColumn74(RANDOM.nextInt());
		row.setColumn75(RANDOM.nextInt());
		row.setColumn76(RANDOM.nextInt());
		row.setColumn77(RANDOM.nextInt());
		row.setColumn78(RANDOM.nextInt());
		row.setColumn79(RANDOM.nextInt());

		if (numberOfColumns == -1) {
			numberOfColumns = RANDOM.nextInt();
		}

		if (numberOfColumns > 0) {
			row.setColumns(new ArrayList<String>(numberOfColumns));
		}

		while (numberOfColumns > 0) {
			row.getColumns().add("COLUMNS_" + RANDOM.nextInt());
			numberOfColumns--;
		}

		return row;
	}

	/**
	 * Erzeuge ein zufällig gefüllte [{@link DomainTable}.
	 * @param numberOfRows die Anzahl der zufällig gefüllten {@link DomainRow},
	 *        ist der Wert <code>-1</code>, dann wird der Wert zufällig
	 *        ermittelt
	 * @param numberOfColumns die Anzahl der zufällig gefüllten Zeichenkette im
	 *        Array {@link DomainRow#Columns}, ist der Wert <code>-1</code>,
	 *        dann wird der Wert zufällig ermittelt
	 * @return ein zufällig gefüllte [{@link DomainTable}
	 */
	public static DomainTable createDomainTable(int numberOfRows,
		int numberOfColumns) {
		DomainTable table = new DomainTable();

		table.setName("DOMAIN_TABLE_" + RANDOM.nextInt());
		table.setDate(new Date());

		if (numberOfRows == -1) {
			numberOfRows = RANDOM.nextInt();
		}

		if (numberOfRows > 0) {
			table.setRows(new ArrayList<DomainRow>(numberOfRows));
		}

		while (numberOfRows > 0) {
			table.getRows().add(createDomainRow(numberOfColumns));
			numberOfRows--;
		}

		return table;
	}

	/**
	 * Erzeuge ein zufällig gefüllte [{@link XmlRow}.
	 * @param numberOfColumns die Anzahl der zufällig gefüllten Zeichenkette im
	 *        Array {@link XmlRow#Columns}, ist der Wert <code>-1</code>, dann
	 *        wird der Wert zufällig ermittelt
	 * @return ein zufällig gefüllte [{@link XmlRow}
	 */
	public static XmlRow createXmlRow(int numberOfColumns) {
		XmlRow row = FACTORY.createXmlRow();

		// String
		row.setColumn00("COLUMNS_00_" + RANDOM.nextInt());
		row.setColumn01("COLUMNS_01_" + RANDOM.nextInt());
		row.setColumn02("COLUMNS_02_" + RANDOM.nextInt());
		row.setColumn03("COLUMNS_03_" + RANDOM.nextInt());
		row.setColumn04("COLUMNS_04_" + RANDOM.nextInt());
		row.setColumn05("COLUMNS_05_" + RANDOM.nextInt());
		row.setColumn06("COLUMNS_06_" + RANDOM.nextInt());
		row.setColumn07("COLUMNS_07_" + RANDOM.nextInt());
		row.setColumn08("COLUMNS_08_" + RANDOM.nextInt());
		row.setColumn09("COLUMNS_09_" + RANDOM.nextInt());

		// int
		row.setColumn10(RANDOM.nextInt());
		row.setColumn11(RANDOM.nextInt());
		row.setColumn12(RANDOM.nextInt());
		row.setColumn13(RANDOM.nextInt());
		row.setColumn14(RANDOM.nextInt());
		row.setColumn15(RANDOM.nextInt());
		row.setColumn16(RANDOM.nextInt());
		row.setColumn17(RANDOM.nextInt());
		row.setColumn18(RANDOM.nextInt());
		row.setColumn19(RANDOM.nextInt());

		// boolean
		row.setColumn20(RANDOM.nextBoolean());
		row.setColumn21(RANDOM.nextBoolean());
		row.setColumn22(RANDOM.nextBoolean());
		row.setColumn23(RANDOM.nextBoolean());
		row.setColumn24(RANDOM.nextBoolean());
		row.setColumn25(RANDOM.nextBoolean());
		row.setColumn26(RANDOM.nextBoolean());
		row.setColumn27(RANDOM.nextBoolean());
		row.setColumn28(RANDOM.nextBoolean());
		row.setColumn29(RANDOM.nextBoolean());

		// long
		row.setColumn30(RANDOM.nextLong());
		row.setColumn31(RANDOM.nextLong());
		row.setColumn32(RANDOM.nextLong());
		row.setColumn33(RANDOM.nextLong());
		row.setColumn34(RANDOM.nextLong());
		row.setColumn35(RANDOM.nextLong());
		row.setColumn36(RANDOM.nextLong());
		row.setColumn37(RANDOM.nextLong());
		row.setColumn38(RANDOM.nextLong());
		row.setColumn39(RANDOM.nextLong());

		// BigDecimal
		row.setColumn40(new BigDecimal(RANDOM.nextInt()));
		row.setColumn41(new BigDecimal(RANDOM.nextInt()));
		row.setColumn42(new BigDecimal(RANDOM.nextInt()));
		row.setColumn43(new BigDecimal(RANDOM.nextInt()));
		row.setColumn44(new BigDecimal(RANDOM.nextInt()));
		row.setColumn45(new BigDecimal(RANDOM.nextInt()));
		row.setColumn46(new BigDecimal(RANDOM.nextInt()));
		row.setColumn47(new BigDecimal(RANDOM.nextInt()));
		row.setColumn48(new BigDecimal(RANDOM.nextInt()));
		row.setColumn49(new BigDecimal(RANDOM.nextInt()));

		// Calendar
		Calendar c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn50(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn51(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn54(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn55(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn56(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn57(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn58(c);
		c = getInstance();
		c.setTimeInMillis(RANDOM.nextLong());
		row.setColumn59(c);

		// String
		row.setColumn60("COLUMNS_60_" + RANDOM.nextInt());
		row.setColumn61("COLUMNS_61_" + RANDOM.nextInt());
		row.setColumn62("COLUMNS_62_" + RANDOM.nextInt());
		row.setColumn63("COLUMNS_63_" + RANDOM.nextInt());
		row.setColumn64("COLUMNS_64_" + RANDOM.nextInt());
		row.setColumn65("COLUMNS_65_" + RANDOM.nextInt());
		row.setColumn66("COLUMNS_66_" + RANDOM.nextInt());
		row.setColumn67("COLUMNS_67_" + RANDOM.nextInt());
		row.setColumn68("COLUMNS_68_" + RANDOM.nextInt());
		row.setColumn69("COLUMNS_69_" + RANDOM.nextInt());

		// int
		row.setColumn70(RANDOM.nextInt());
		row.setColumn71(RANDOM.nextInt());
		row.setColumn72(RANDOM.nextInt());
		row.setColumn73(RANDOM.nextInt());
		row.setColumn74(RANDOM.nextInt());
		row.setColumn75(RANDOM.nextInt());
		row.setColumn76(RANDOM.nextInt());
		row.setColumn77(RANDOM.nextInt());
		row.setColumn78(RANDOM.nextInt());
		row.setColumn79(RANDOM.nextInt());

		if (numberOfColumns == -1) {
			numberOfColumns = RANDOM.nextInt();
		}

		while (numberOfColumns > 0) {
			row.getColumns().add("COLUMNS_" + RANDOM.nextInt());
			numberOfColumns--;
		}

		return row;
	}

	/**
	 * Erzeuge ein zufällig gefüllte [{@link XmlTable}.
	 * @param numberOfRows die Anzahl der zufällig gefüllten {@link XmlRow}, ist
	 *        der Wert <code>-1</code>, dann wird der Wert zufällig ermittelt
	 * @param numberOfColumns die Anzahl der zufällig gefüllten Zeichenkette im
	 *        Array {@link XmlRow#Columns}, ist der Wert <code>-1</code>, dann
	 *        wird der Wert zufällig ermittelt
	 * @return ein zufällig gefüllte [{@link XmlTable}
	 */
	public static XmlTable
		createXmlTable(int numberOfRows, int numberOfColumns) {
		XmlTable table = FACTORY.createXmlTable();

		table.setName("XML_TABLE_" + RANDOM.nextInt());
		table.setDate(getInstance());

		if (numberOfRows < 0) {
			numberOfRows = RANDOM.nextInt();
		}

		while (numberOfRows > 0) {
			table.getRows().add(createXmlRow(numberOfColumns));
			numberOfRows--;
		}

		return table;
	}

	/**
	 * Konstruktor.
	 */
	private TestBeansUtils() {
		super();
	}

}