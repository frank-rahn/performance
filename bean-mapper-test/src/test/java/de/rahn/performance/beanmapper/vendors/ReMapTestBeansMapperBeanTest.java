/*
 * Copyright © 2017 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.junit.Before;

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
		mapperBean = new ReMapTestBeansMapperBean();
	}

}