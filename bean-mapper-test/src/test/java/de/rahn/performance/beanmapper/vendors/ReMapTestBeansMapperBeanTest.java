/*
 * Copyright © 2017 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.junit.Before;
import org.junit.Test;

import com.remondis.remap.AssertMapping;

import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Test des Mappers für reMap.
 *
 * @author Tom Hombergs
 */
public class ReMapTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapperBean = new ReMapTestBeansMapperBean().initialize();
	}

	/**
	 * Teste den Mapper.
	 */
	@Test
	public void testDomainToXmlTableMapper() throws Exception {
		ReMapTestBeansMapperBean reMapTestBeansMapperBean = (ReMapTestBeansMapperBean) mapperBean;

		// @formatter:off
		AssertMapping.of(reMapTestBeansMapperBean.domainToXmlTableMapper)
			.expectReplace(DomainTable::getDate, XmlTable::getDate)
				.andTest(reMapTestBeansMapperBean.dateToCalendar())
			.ensure();
		// @formatter:on
	}

	/**
	 * Teste den Mapper.
	 */
	@Test
	public void testXmlToDomainTableMapper() throws Exception {
		ReMapTestBeansMapperBean reMapTestBeansMapperBean = (ReMapTestBeansMapperBean) mapperBean;

		// @formatter:off
		AssertMapping.of(reMapTestBeansMapperBean.xmlToDomainTableMapper)
			.expectReplace(XmlTable::getDate, DomainTable::getDate)
				.andTest(reMapTestBeansMapperBean.calendarToDate())
			.ensure();
		// @formatter:on
	}

}