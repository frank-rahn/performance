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
		numberOdRows = 100;
		numberOfColumns = 100;
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
		xmlTable.getRows().clear();

		// Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
		// können
		domainTable.setDate(null);
		domainTable.getRows().clear();
	}

}