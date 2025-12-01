/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Ein Test für die Klasse {@link Statistics}.
 *
 * @author Frank W. Rahn
 */
class StatisticsTest {

  private static final String METERING_POINT_NAME = "MeteringPointName";

  private static final long COUNTER = 5L;

  private static final long MAXIMUM = COUNTER;

  private static final long MINIMUM = 1L;

  private static final long LAST = MINIMUM;

  private static final long VALUES = 1 + 2 + 3 + 4 + 5;

  private static final long AVERAGE = VALUES / COUNTER;

  private static final BigDecimal STDDEV = new BigDecimal("1.58114");

  private Statistics classUnderTests;

  /**
   * Initialisiere den Test.
   */
  @BeforeEach
  void setUp() {
    classUnderTests = new Statistics(METERING_POINT_NAME);

    for (long i = COUNTER; i > 0; --i) {
      classUnderTests.addValue(i);
    }
  }

  /**
   * Test method for {@link Statistics#getMeteringPointName()} .
   */
  @Test
  void getMeteringPointName() {
    assertThat(classUnderTests.getMeteringPointName(), is(METERING_POINT_NAME));
  }

  /**
   * Test method for {@link Statistics#getCounter()}.
   */
  @Test
  void getCounter() {
    assertThat(classUnderTests.getCounter(), is(COUNTER));
  }

  /**
   * Test method for {@link Statistics#getMinimum()}.
   */
  @Test
  void getMinimum() {
    assertThat(classUnderTests.getMinimum(), is(MINIMUM));
  }

  /**
   * Test method for {@link Statistics#getMaximum()}.
   */
  @Test
  void getMaximum() {
    assertThat(classUnderTests.getMaximum(), is(MAXIMUM));
  }

  /**
   * Test method for {@link Statistics#getLast()}.
   */
  @Test
  void getLast() {
    assertThat(classUnderTests.getLast(), is(LAST));
  }

  /**
   * Test method for {@link Statistics#average()}.
   */
  @Test
  void average() {
    assertThat(classUnderTests.average(), is(new BigDecimal(AVERAGE)));
  }

  /**
   * Test method for {@link Statistics#standardDeviation()}.
   */
  @Test
  void standardDeviation() {
    assertThat(classUnderTests.standardDeviation(), is(STDDEV));
  }

  /**
   * Test method for {@link Statistics#getValues()}.
   */
  @Test
  void getValues() {
    assertThat(classUnderTests.getValues(), is(VALUES));
  }
}
