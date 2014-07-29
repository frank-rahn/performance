/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static de.rahn.performance.measurement.Statistics.TITLES;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

/**
 * Diese Klasse erfasst und berechnet die Performanzdaten pro Messpunkt.
 * @author Frank W. Rahn
 */
public class PerformanceMeasurement {

	private static final Logger LOGGER =
		getLogger(PerformanceMeasurement.class);

	private final Map<String, Statistics> measurements =
		new HashMap<String, Statistics>();

	/**
	 * Nehme einen Messwert zum Messpunkt in der Statistik auf.
	 * @param meteringPointName der Name des Messpunktes
	 * @param value der Messwert
	 */
	public void addValue(String meteringPointName, long value) {
		Statistics statistics = measurements.get(meteringPointName);

		if (statistics == null) {
			statistics = new Statistics(meteringPointName);
			measurements.put(meteringPointName, statistics);
		}

		statistics.addValue(value);
	}

	/**
	 * Das Warmlaufen ist abgeschloßen.
	 */
	public void endWarmUp() {
		printTitles("Warmlaufen");

		for (Statistics statistics : measurements.values()) {
			statistics.print(LOGGER);
		}

		measurements.clear();
	}

	/**
	 * Schliese die Messung ab.
	 * @param name der Name für den Test
	 */
	public void endMeasurement(String name) {
		printTitles(name);

		// Zusammenfassung schreiben
		for (Statistics statistics : measurements.values()) {
			statistics.print(LOGGER);
		}

		// Messreihen schreiben
		for (Statistics statistics : measurements.values()) {
			statistics.printSeries(LOGGER);
		}

		measurements.clear();
	}

	/**
	 * @return die Messungen
	 */
	public final Map<String, Statistics> getMeasurements() {
		return measurements;
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