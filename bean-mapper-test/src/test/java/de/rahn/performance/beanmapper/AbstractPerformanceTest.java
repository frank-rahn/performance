/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

import static de.rahn.performance.testbeans.TestBeansUtils.createXmlTable;
import static java.lang.System.currentTimeMillis;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.slf4j.LoggerFactory.getLogger;

import de.rahn.performance.beanmapper.utils.MapperManager;
import de.rahn.performance.beanmapper.vendors.ByHandTestBeansMapperBean;
import de.rahn.performance.measurement.PerformanceMeasurement;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Ein Performanz-Test der Mapper. Dabei wird ein {@link XmlTable} auf ein {@link DomainTable} gemappt.
 *
 * @author Frank W. Rahn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public abstract class AbstractPerformanceTest {

  protected static final Logger LOGGER = getLogger(AbstractPerformanceTest.class);

  protected PerformanceMeasurement measurement;

  @Autowired
  private MapperManager manager;

  @Autowired
  private ObjectFactory factory;

  protected XmlTable xmlTable;

  protected DomainTable domainTable;

  protected int numberOfRows;

  protected int numberOfColumns;

  @SuppressWarnings("CanBeFinal")
  protected int runDurationInMinutes = 10;

  protected String[] excludedMapper = new String[0];

  /**
   * Die Messung vorbereiten.
   *
   * @throws Exception, wenn die Testdaten nicht erzeugt werden können
   */
  @Before
  public void setUp() throws Exception {
    setUpBefore();

    xmlTable = createXmlTable(numberOfRows, numberOfColumns);

    domainTable = new ByHandTestBeansMapperBean(factory).map(xmlTable);

    setUpAfter();

    measurement = new PerformanceMeasurement(getClass().getSimpleName());
  }

  /**
   * Die Messung durchführen.
   */
  @Test
  public void testPerformance() throws IOException {
    // Warmlaufen
    for (int i = 0; i < 10; i++) {
      runTestOverAllMappers(i);
    }

    // Statistiken zurücksetzen
    measurement.endWarmUp();

    // Den Test eine bestimmte Zeit durchführen
    LOGGER.info("Messung wird für {} Minuten gestartet...", runDurationInMinutes);
    int run = 1;
    final long timer = MINUTES.toMillis(runDurationInMinutes) + currentTimeMillis();
    do {
      runTestOverAllMappers(run++);
    } while (currentTimeMillis() <= timer);
    LOGGER.info("...Messung beendet.");

    // Statistiken zurücksetzen
    measurement.endMeasurement();
  }

  /**
   * Rufe mal alle Mapper auf.
   *
   * @param run der aktuelle Durchlauf
   */
  private void runTestOverAllMappers(int run) {
    for (TestBeansMapperBean mapper : manager.getMappersExcluded(excludedMapper)) {
      runTestWithMapper(mapper, run);
    }
  }

  /**
   * @param mapper der aktuelle Mapper
   * @param run    der aktuelle Durchlauf
   */
  protected void runTestWithMapper(TestBeansMapperBean mapper, int run) {
    final String msg = "FEHLER im " + mapper.getMapperName() + " beim " + run + "ten Durchlauf";

    try {
      // Messung
      long start = currentTimeMillis();
      DomainTable table = mapper.map(xmlTable);
      long value = currentTimeMillis() - start;

      // Überprüfung
      assertThat(msg, table, notNullValue());
      assertThat(msg, table, equalTo(domainTable));

      // Messwert registrieren
      measurement.addValue(mapper.getMapperName(), value);
    } catch (Exception exception) {
      LOGGER.error(msg, exception);

      throw new AssertionError(msg);
    }
  }

  /**
   * Ermöglicht das Verändern der Parameter für diesen Test.
   */
  protected void setUpAfter() {
    // Kann überschrieben werden
  }

  /**
   * Initialisiere die Einstellgrößen für diesen Test.
   */
  protected abstract void setUpBefore();
}
