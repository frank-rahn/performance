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
import java.util.ArrayList;
import java.util.List;

/**
 * Die statisticschen Daten zu einem Messpunkt.
 * @author Frank Rahn
 */
public class Statistics {

	/** Die Überschriften und Reihenfolge der einzelnen Messwerte. */
	public static final String[] TITLES = { "Name des Messpunkt",
		"Anzahl der Messungen", "Summe aller Messwerte", "Minimaler Messwert",
		"Maximaler Messwert", "Mittelwert", "Letzter Messwert" };

	/**
	 * Datenklasse, um Zwischenwerte des Mittelwerte speichern zu können.
	 * @author Frank W. Rahn
	 */
	public final class Average {

		private long numberOfValues;

		private BigDecimal average;

		/**
		 * Konstruktor.
		 */
		public Average() {
			numberOfValues = counter;
			average = average();
		}

		/**
		 * @return die Anzahl von Messwerten die zum Mittelwert führten
		 */
		public final long getNumberOfValues() {
			return numberOfValues;
		}

		/**
		 * @return der Mittelwert
		 */
		public final BigDecimal getAverage() {
			return average;
		}
	}

	private List<Average> averages = new ArrayList<Average>();

	private String meteringPointName;

	private long counter = 0;

	private long values = 0;

	private long minimum = MAX_VALUE;

	private long maximum = 0;

	private long last = 0;

	/**
	 * @param meteringPointName der Name des Messpunktes
	 */
	public Statistics(String meteringPointName) {
		this.meteringPointName = meteringPointName;
	}

	/**
	 * @param actual Nehme diesen Messwert in dieser Statistik auf
	 */
	public void addValue(long actual) {
		counter++;
		values += actual;
		last = actual;

		minimum = min(minimum, actual);
		maximum = max(maximum, actual);

		// Mittelwert speichern?
		saveAverageIfNecessary();
	}

	/**
	 * Speichere den aktuelle Mittelwert, wenn notwendig.
	 */
	private void saveAverageIfNecessary() {
		if (counter % 10000 == 0 || counter == 10 || counter == 100
				|| counter == 1000) {
			averages.add(new Average());
		}
	}

	/**
	 * @return der aktuelle Mittelwert
	 */
	public BigDecimal average() {
		return new BigDecimal(values).divide(new BigDecimal(counter),
			new MathContext(5, HALF_UP));
	}

	/**
	 * @return Liefert den Namen dieses Messpunktes
	 */
	public String getMeteringPointName() {
		return meteringPointName;
	}

	/**
	 * @return die Anzahl der Messwerte
	 */
	public long getCounter() {
		return counter;
	}

	/**
	 * @return die Summe aller Messwerte
	 */
	public long getValues() {
		return values;
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

	/**
	 * @return die Liste der Mittelwerte mit der Anzahl der zugrundeliegenden
	 *         Messwerten
	 */
	public List<Average> getAverages() {
		return averages;
	}

}