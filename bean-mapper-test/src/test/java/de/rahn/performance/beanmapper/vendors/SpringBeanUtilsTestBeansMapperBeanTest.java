/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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

  @Test
  @Ignore("Dieser Test kann nicht funktioniert")
  @Override
  public void testMapTable() throws Exception {
    super.testMapTable();
  }
}
