/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static java.lang.Long.MAX_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Diese Klasse erfasst und berechnet die Performanzdaten pro Messpunkt.
 * @author Frank W. Rahn
 */
public class PerformanceMeasurement {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PerformanceMeasurement.class);

	/** Die Überschriften und Reihenfolge der einzelnen Messwerte. */
	public static final String[] TITLES = { "Name des Messpunkt",
		"Anzahl der Messungen", "Mittelwert", "Minimaler Messwert",
		"Maximaler Messwert", "Summe aller Messwerte", "Letzter Messwert" };

	/**
	 * Die statisticschen Daten zu einem Messpunkt.
	 * @author Frank Rahn
	 */
	public class Statistics {

		private String meteringPointName;

		private long counter;

		private long value;

		private long maximum;

		private long minimum;

		private long last;

		/**
		 * @param meteringPointName der Name des Messpunktes
		 */
		public Statistics(String meteringPointName) {
			this.meteringPointName = meteringPointName;

			measurement.put(meteringPointName, this);

			reset();
		}

		/**
		 * Setze die Statistiken auf 0.
		 */
		public void reset() {
			// Die letzten Messwerte noch wegschreiben, falls nicht geschehen
			if (counter > 0 && !testPrint()) {
				print();
			}

			// reset
			counter = 0;
			value = 0;
			maximum = 0;
			last = 0;
			minimum = MAX_VALUE;
		}

		/**
		 * @return Liefert den Namen dieses Messpunktes
		 */
		public String getMeteringPointName() {
			return meteringPointName;
		}

		/**
		 * @param actual Nehme diesen Messwert in dieser Statistik auf
		 */
		private void addValue(long actual) {
			counter++;
			value += actual;
			last = actual;

			maximum = max(maximum, actual);
			minimum = min(minimum, actual);

			// Messwerte raus schreiben?
			if (testPrint()) {
				print();
			}
		}

		/**
		 * @return <code>true</code>, wenn die Messwerte raus geschrieben werden
		 *         sollen
		 */
		private boolean testPrint() {
			return counter % 10000 == 0 || counter == 10 || counter == 100
					|| counter == 1000;
		}

		/**
		 * @return den aktuelle Mittelwert
		 */
		public BigDecimal average() {
			return new BigDecimal(value).divide(new BigDecimal(counter),
				new MathContext(5, HALF_UP));
		}

		/**
		 * Schreibe die aktuellen Werte raus.
		 */
		private void print() {
			LOGGER.info("{}, {}, {}, {}, {}, {}, {}", meteringPointName,
				counter, average(), minimum, maximum, value, last);
		}

		/**
		 * @return die Anzahl der Messwerte
		 */
		public long getCounter() {
			return counter;
		}

		/**
		 * @return der größte Messwert
		 */
		public long getMaximum() {
			return maximum;
		}

		/**
		 * @return der kleinste Messwert
		 */
		public long getMinimum() {
			return minimum;
		}

		/**
		 * @return der letzte Messwert
		 */
		public long getLast() {
			return last;
		}
	}

	private final Map<String, Statistics> measurement =
			new HashMap<String, Statistics>();

	/**
	 * Nehme einen Messwert zum Messpunkt in der Statistik auf.
	 * @param meteringPointName der Name des Messpunktes
	 * @param value der Messwert
	 */
	public void addValue(String meteringPointName, long value) {
		Statistics statistics = measurement.get(meteringPointName);

		if (statistics == null) {
			statistics = new Statistics(meteringPointName);
		}

		statistics.addValue(value);
	}

	/**
	 * @return die Messungen
	 */
	public final Map<String, Statistics> getMeasurement() {
		return measurement;
	}

	/**
	 * Setze alle Statistiken auf 0.
	 * @param header die Überschrifft über den Test
	 */
	public void reset(String header) {
		for (Statistics statistics : measurement.values()) {
			statistics.reset();
		}
		measurement.clear();

		printTitles(header);
	}

	/**
	 * Ausgabe der Überschriften.
	 */
	private void printTitles(String header) {
		if (header != null) {
			LOGGER.info("############ {} ############", header);
		}

		StringBuilder buffer = new StringBuilder();

		for (String title : TITLES) {
			if (buffer.length() > 0) {
				buffer.append(", ");
			}
			buffer.append(title);
		}

		LOGGER.info(buffer.toString());
	}

}