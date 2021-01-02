/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

/**
 * Ein Performanz Test der Mapper mit vollständig gefüllten Test-Objekten.
 *
 * @author Frank W. Rahn
 */
public class PerformanceTestWithCompleteFixtures extends AbstractPerformanceTest {

	/**
	 * {@inheritDoc}
	 *
	 * @see AbstractPerformanceTest#setUpBefore()
	 */
	@Override
	protected void setUpBefore() {
		numberOfRows = 100;
		numberOfColumns = 100;
		excludedMapper = new String[] { "Commons-BeanUtils", "Spring-BeanUtils" };
	}

}