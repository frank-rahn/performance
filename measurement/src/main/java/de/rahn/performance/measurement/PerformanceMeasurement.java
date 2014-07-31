/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse erfasst und berechnet die Performanzdaten pro Messpunkt.
 * @author Frank W. Rahn
 */
public class PerformanceMeasurement {

	private final Map<String, Statistics> measurements;
	private final List<String> meteringPointNames;

	private MeasurementWriterToExcel writerToExcel;

	/**
	 * @param name der name der Messung
	 */
	public PerformanceMeasurement(String name) {
		super();

		measurements = new HashMap<>();
		meteringPointNames = new ArrayList<>();

		writerToExcel = new MeasurementWriterToExcel(name);
	}

	/**
	 * Nehme einen Messwert zum Messpunkt in der Statistik auf.
	 * @param meteringPointName der Name des Messpunktes
	 * @param value der Messwert
	 */
	public void addValue(String meteringPointName, long value) {
		Statistics statistics = measurements.get(meteringPointName);

		if (statistics == null) {
			meteringPointNames.add(meteringPointName);
			statistics = new Statistics(meteringPointName);
			measurements.put(meteringPointName, statistics);
		}

		statistics.addValue(value);
	}

	/**
	 * Das Warmlaufen ist abgeschloßen.
	 */
	public void endWarmUp() {
		writerToExcel.processWarmUp(meteringPointNames, measurements);
		meteringPointNames.clear();
		measurements.clear();
	}

	/**
	 * Schliese die Messung ab.
	 * @param name der Name für den Test
	 * @throws IOException falls die Datei nicht geschrieben werden kann
	 */
	public void endMeasurement() throws IOException {
		// Zusammenfassung schreiben
		writerToExcel.processMeasurement(meteringPointNames, measurements);
		meteringPointNames.clear();
		measurements.clear();
		writerToExcel.save();
	}

}