/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;

import de.rahn.performance.beanmapper.vendors.SpringBeanUtilsTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Ein Performanz-Test der Mapper mit unvollständig gefüllten Test-Objekten.
 *
 * @author Frank W. Rahn
 */
@SuppressWarnings("NewClassNamingConvention")
public class PerformanceTestWithIncompleteFixtures extends AbstractPerformanceTest {

	@Override
	protected void setUpAfter() {
		// Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
		xmlTable.setDate(null);

		// Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
		domainTable.setDate(null);
		domainTable.getRows().clear();
	}

	@Override
	protected void setUpBefore() {
		numberOfRows = 0;
		numberOfColumns = 0;
	}

	@Override
	protected void runTestWithMapper(TestBeansMapperBean mapper, int run) {
		if (mapper instanceof SpringBeanUtilsTestBeansMapperBean) {
			final String msg = "FEHLER im " + mapper.getMapperName() + " beim " + run + "ten Durchlauf";

			try {
				// Messung
				long start = currentTimeMillis();
				DomainTable table = mapper.map(xmlTable);
				long value = currentTimeMillis() - start;

				// Überprüfung
				assertThat(msg, table, notNullValue());
				table.setRows(new ArrayList<>()); // Wegen des Unterschieds zu org.apache.commons.beanutils.BeanUtils
				assertThat(msg, table, equalTo(domainTable));

				// Messwert registrieren
				measurement.addValue(mapper.getMapperName(), value);
			} catch (Exception exception) {
				LOGGER.error(msg, exception);

				throw new AssertionError(msg);
			}
		} else {
			super.runTestWithMapper(mapper, run);
		}
	}
}
