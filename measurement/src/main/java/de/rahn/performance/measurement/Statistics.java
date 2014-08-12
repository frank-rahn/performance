/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static com.jidesoft.utils.BigDecimalMathUtils.sqrt;
import static java.lang.Long.MAX_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.math.MathContext.DECIMAL128;
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

	/** Die Präzision. */
	private static final MathContext PRECISION = new MathContext(6, HALF_UP);

	/** Die Präzision. */
	private static final MathContext PRECISION_INTERNAL = new MathContext(
		DECIMAL128.getPrecision(), HALF_UP);

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
		 * @return der arithmetische Mittelwert
		 */
		public final BigDecimal getAverage() {
			return average;
		}

		/**
		 * @return die Anzahl von Messwerten die zum Mittelwert führten
		 */
		public final long getNumberOfValues() {
			return numberOfValues;
		}
	}

	/** Die Überschriften und Reihenfolge der einzelnen Messwerte. */
	public static final String[] TITLES = { "Name des Messpunkts",
		"Anzahl der Messungen", "Summe aller Messwerte", "Minimaler Messwert",
		"Maximaler Messwert", "Arth. Mittelwert", "Standardabweichung",
	"Letzter Messwert" };

	private List<Average> averages = new ArrayList<>();

	private String meteringPointName;

	private long counter = 0;

	private long values = 0;

	private long square = 0;

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
		square += actual * actual;
		last = actual;

		minimum = min(minimum, actual);
		maximum = max(maximum, actual);

		// Mittelwert speichern?
		saveAverageIfNecessary();
	}

	/**
	 * @return der aktuelle Mittelwert
	 */
	public BigDecimal average() {
		// = sum(x)/n
		return new BigDecimal(values)
		.divide(new BigDecimal(counter), PRECISION);
	}

	/**
	 * @return die aktuelle Standardabweichung
	 */
	public BigDecimal standardDeviation() {
		// z = sum(x)^2/n
		BigDecimal z =
				new BigDecimal(values).multiply(new BigDecimal(values)).divide(
					new BigDecimal(counter), PRECISION_INTERNAL);

		// variance = (sum(x^2)-z)/(n-1)
		BigDecimal variance =
			new BigDecimal(square).subtract(z).divide(
					new BigDecimal(counter - 1), PRECISION_INTERNAL);

		return sqrt(variance).round(PRECISION);
	}

	/**
	 * @return die Liste der Mittelwerte mit der Anzahl der zugrundeliegenden
	 *         Messwerten
	 */
	public List<Average> getAverages() {
		return averages;
	}

	/**
	 * @return die Anzahl der Messwerte
	 */
	public long getCounter() {
		return counter;
	}

	/**
	 * @return der letzte Messwert
	 */
	public long getLast() {
		return last;
	}

	/**
	 * @return der größte Messwert
	 */
	public long getMaximum() {
		return maximum;
	}

	/**
	 * @return Liefert den Namen dieses Messpunktes
	 */
	public String getMeteringPointName() {
		return meteringPointName;
	}

	/**
	 * @return der kleinste Messwert
	 */
	public long getMinimum() {
		return minimum;
	}

	/**
	 * @return die Summe aller Messwerte
	 */
	public long getValues() {
		return values;
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

}