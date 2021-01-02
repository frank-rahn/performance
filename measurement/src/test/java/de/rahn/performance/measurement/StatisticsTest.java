/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.measurement;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * Ein Test für die Klasse {@link Statistics}.
 * @author Frank W. Rahn
 */
public class StatisticsTest {

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
	@Before
	public void setUp() {
		classUnderTests = new Statistics(METERING_POINT_NAME);

		for (long i = COUNTER; i > 0; --i) {
			classUnderTests.addValue(i);
		}
	}

	/**
	 * Test method for {@link Statistics#getMeteringPointName()} .
	 */
	@Test
	public void testGetMeteringPointName() {
		assertThat(classUnderTests.getMeteringPointName(),
			is(METERING_POINT_NAME));
	}

	/**
	 * Test method for {@link Statistics#getCounter()}.
	 */
	@Test
	public void testGetCounter() {
		assertThat(classUnderTests.getCounter(), is(COUNTER));
	}

	/**
	 * Test method for {@link Statistics#getMinimum()}.
	 */
	@Test
	public void testGetMinimum() {
		assertThat(classUnderTests.getMinimum(), is(MINIMUM));
	}

	/**
	 * Test method for {@link Statistics#getMaximum()}.
	 */
	@Test
	public void testGetMaximum() {
		assertThat(classUnderTests.getMaximum(), is(MAXIMUM));
	}

	/**
	 * Test method for {@link Statistics#getLast()}.
	 */
	@Test
	public void testGetLast() {
		assertThat(classUnderTests.getLast(), is(LAST));
	}

	/**
	 * Test method for {@link Statistics#average()}.
	 */
	@Test
	public void testAverage() {
		assertThat(classUnderTests.average(), is(new BigDecimal(AVERAGE)));
	}

	/**
	 * Test method for {@link Statistics#standardDeviation()}.
	 */
	@Test
	public void testStandardDeviation() {
		assertThat(classUnderTests.standardDeviation(), is(STDDEV));
	}

	/**
	 * Test method for {@link Statistics#getValues()}.
	 */
	@Test
	public void testGetValues() {
		assertThat(classUnderTests.getValues(), is(VALUES));
	}

}