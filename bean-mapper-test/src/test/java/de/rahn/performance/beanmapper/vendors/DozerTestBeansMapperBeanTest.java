/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import org.dozer.MappingException;
import org.junit.Before;

/**
 * Test des Mappers für Dozer.
 * @author Frank W. Rahn
 */
public class DozerTestBeansMapperBeanTest extends
AbstractTestBeansMapperBeanTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapperBean = new DozerTestBeansMapperBean();
		((DozerTestBeansMapperBean) mapperBean).initialize();
	}

	/**
	 * {@inheritDoc}
	 * @see AbstractTestBeansMapperBeanTest#testMapEmptyDomainTableWithNullRows()
	 */
	@Override
	public void testMapEmptyDomainTableWithNullRows() throws Exception {
		try {
			super.testMapEmptyDomainTableWithNullRows();
			fail("Hier hatte eine Exception geworfen werden sollen");
		} catch (MappingException exception) {
			// Hier wird XmlTable.setRows(null) aufgerufen.
			// Die JAXB Generierung läst das direkte setzen von Listen nicht zu.
			// Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
		}
	}

}