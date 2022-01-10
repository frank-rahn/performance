package de.rahn.performance.measurement;

import org.junit.Test;

public class PerformanceMeasurementTest {

  private PerformanceMeasurement classUnderTest;

  /**
   * Erstelle eine einfache Datei.
   */
  @Test
  public void testMeasurement_1() throws Exception {
    classUnderTest = new PerformanceMeasurement("target/testMeasurement_1");

    for (int i = 0; i < 3; i++) {
      classUnderTest.addValue("a", 1);
    }

    for (int i = 0; i < 4; i++) {
      classUnderTest.addValue("b", 2);
    }

    classUnderTest.endWarmUp();

    for (int i = 0; i < 100; i++) {
      classUnderTest.addValue("a", 1);
    }

    classUnderTest.addValue("b", 4);
    for (int i = 0; i < 1000; i++) {
      classUnderTest.addValue("b", 2);
    }
    classUnderTest.addValue("b", 3);

    classUnderTest.endMeasurement();
  }

  /**
   * Erstelle eine einfache Datei.
   */
  @Test
  public void testMeasurement_2() throws Exception {
    classUnderTest = new PerformanceMeasurement("target/testMeasurement_2");
    classUnderTest.endWarmUp();
    classUnderTest.endMeasurement();
  }

  /**
   * Erstelle eine einfache Datei.
   */
  @Test
  public void testMeasurement_3() throws Exception {
    classUnderTest = new PerformanceMeasurement("target/testMeasurement_3");
    classUnderTest.endWarmUp();
    classUnderTest.endMeasurement();
    classUnderTest.endWarmUp();
    classUnderTest.endMeasurement();
  }
}
