/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test des Mappers für ByHand.
 * @author Frank W. Rahn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ByHandTestBeansMapperBeanTest extends
	AbstractTestBeansMapperBeanTest {

	@Autowired
	public void setByHandTestBeansMapperBean(
		ByHandTestBeansMapperBean mapperBean) {
		this.mapperBean = mapperBean;
	}

}