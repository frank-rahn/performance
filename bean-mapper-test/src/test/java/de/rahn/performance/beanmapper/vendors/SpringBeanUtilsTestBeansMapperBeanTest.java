/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test des Mappers für Spring-BeanUtils.
 *
 * @author Frank W. Rahn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringBeanUtilsTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

	@Autowired
	public void setSpringBeanUtilsTestBeansMapperBean(SpringBeanUtilsTestBeansMapperBean mapperBean) {
		this.mapperBean = mapperBean;
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
		} catch (FatalBeanException exception) {
			// Hier wird XmlTable.setRows(null) aufgerufen.
			// Die JAXB Generierung lässt das direkte setzen von Listen nicht zu.
			// Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see AbstractTestBeansMapperBeanTest#testMapTable()
	 */
	@Test
	@Ignore("Dieser Test kann nicht funktioniert")
	@Override
	public void testMapTable() throws Exception {
		super.testMapTable();
	}

}