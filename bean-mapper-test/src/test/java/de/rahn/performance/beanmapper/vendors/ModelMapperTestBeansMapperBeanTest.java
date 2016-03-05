/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.modelmapper.MappingException;

/**
 * Test des Mappers für ModelMapper.
 *
 * @author Frank W. Rahn
 */
public class ModelMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapperBean = new ModelMapperTestBeansMapperBean();
		((ModelMapperTestBeansMapperBean) mapperBean).initialize();
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
		} catch (MappingException exception) {
			// Hier wird XmlTable.setRows(null) aufgerufen.
			// Die JAXB Generierung läst das direkte setzen von Listen nicht zu.
			// Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
		}
	}

}