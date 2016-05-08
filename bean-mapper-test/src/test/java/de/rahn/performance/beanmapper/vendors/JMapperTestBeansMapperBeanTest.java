/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import org.junit.Before;

import com.googlecode.jmapper.exceptions.JMapperException;

/**
 * Test des Mappers für JMapper.
 *
 * @author Frank W. Rahn
 */
public class JMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapperBean = new JMapperTestBeansMapperBean();
		((JMapperTestBeansMapperBean) mapperBean).initialize();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see AbstractTestBeansMapperBeanTest#testMapEmptyDomainTableWithNullRows()
	 */
	@Override
	public void testMapEmptyDomainTableWithNullRows() throws Exception {
		try {
			super.testMapEmptyDomainTableWithNullRows();
			fail("Hier hatte eine Exception geworfen werden sollen");
		} catch (JMapperException exception) {
			// Hier wird XmlTable.setRows(null) aufgerufen.
			// Die JAXB Generierung läst das direkte setzen von Listen nicht zu.
			// Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
		}
	}

}