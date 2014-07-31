/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

/**
 * Ein Performanz Test der Mapper mit unvollständig gefüllten Test-Objekten.
 * @author Frank W. Rahn
 */
public class PerformanceTestWithIncompleteFixtures extends
	AbstractPerformanceTest {

	/**
	 * {@inheritDoc}
	 * @see AbstractPerformanceTest#setUpBefore()
	 */
	@Override
	protected void setUpBefore() {
		numberOfRows = 0;
		numberOfColumns = 0;
	}

	/**
	 * {@inheritDoc}
	 * @see AbstractPerformanceTest#setUpAfter()
	 */
	@Override
	protected void setUpAfter() {
		// Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
		// können
		xmlTable.setDate(null);

		// Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
		// können
		domainTable.setDate(null);
		domainTable.getRows().clear();
	}

}