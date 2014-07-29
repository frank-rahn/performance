/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

import static de.rahn.performance.testbeans.TestBeansUtils.createXmlTable;
import static java.lang.System.currentTimeMillis;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.utils.MapperManager;
import de.rahn.performance.beanmapper.vendors.ByHandTestBeansMapperBean;
import de.rahn.performance.measurement.PerformanceMeasurement;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Ein Performanz Test der Mapper. Dabei wird ein {@link XmlTable} auf ein
 * {@link DomainTable} gemappt.
 * @author Frank W. Rahn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public abstract class AbstractPerformanceTest {

	protected static final Logger LOGGER =
		getLogger(AbstractPerformanceTest.class);

	private static PerformanceMeasurement measurement =
		new PerformanceMeasurement();

	@Autowired
	private MapperManager manager;

	protected XmlTable xmlTable;

	protected DomainTable domainTable;

	protected int numberOdRows;

	protected int numberOfColumns;

	protected int runDurationInMinutes = 10;

	protected String[] excludedMapper = new String[0];

	/**
	 * Die Messung vorbereiten.
	 * @throws Exception wenn die Testdaten nicht erzeugt werden können
	 */
	@Before
	public void setUp() throws Exception {
		setUpBefore();

		xmlTable = createXmlTable(numberOdRows, numberOfColumns);

		domainTable = new ByHandTestBeansMapperBean().map(xmlTable);

		setUpAfter();
	}

	/**
	 * Initialisiere die Einstellgrößen für diesen Test.
	 */
	protected abstract void setUpBefore();

	/**
	 * Ermöglicht das Verändern der Parametern für diesen Test.
	 */
	protected void setUpAfter() {
		// Kann überschrieben werden
	}

	/**
	 * Die Messung durchführen.
	 */
	@Test
	public void testPerformance() {
		// Warmlaufen
		for (int i = 0; i < 10; i++) {
			runTestOverAllMappers(i);
		}

		// Statistiken zurücksetzen
		measurement.endWarmUp();

		// Den Test eine bestimmte Zeit durchfürhen
		LOGGER.info("Messung wird für {} Minuten gestartet...",
			runDurationInMinutes);
		int run = 1;
		final long timer =
			MINUTES.toMillis(runDurationInMinutes) + currentTimeMillis();
		while (true) {
			runTestOverAllMappers(run++);

			if (currentTimeMillis() > timer) {
				break;
			}
		}
		LOGGER.info("...Messung beendet.");

		// Statistiken zurücksetzen
		measurement.endMeasurement(getClass().getSimpleName());
	}

	/**
	 * Rufe mal alle Mapper auf.
	 * @param run der aktuelle Durchlauf
	 */
	private void runTestOverAllMappers(int run) {
		for (TestBeansMapperBean mapper : manager
			.getMappersExcluded(excludedMapper)) {
			runTestWithMapper(mapper, run);
		}
	}

	/**
	 * @param mapper der aktuelle Mapper
	 * @param run der aktuelle Durchlauf
	 */
	private void runTestWithMapper(TestBeansMapperBean mapper, int run) {
		final String msg =
			"FEHLER im " + mapper.getMapperName() + " beim " + run
				+ "ten Durchlauf";

		try {
			// Messung
			long start = currentTimeMillis();
			DomainTable table = mapper.map(xmlTable);
			long value = currentTimeMillis() - start;

			// Überprüfung
			assertThat(msg, table, notNullValue());
			assertThat(msg, table, is(domainTable));

			// Messwert registrieren
			measurement.addValue(mapper.getMapperName(), value);
		} catch (Exception exception) {
			LOGGER.error(msg, exception);

			throw new AssertionError(msg);
		}
	}

}