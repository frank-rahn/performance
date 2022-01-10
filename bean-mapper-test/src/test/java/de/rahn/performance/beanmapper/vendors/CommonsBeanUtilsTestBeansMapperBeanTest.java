/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test des Mappers für Commons-BeanUtils.
 *
 * @author Frank W. Rahn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CommonsBeanUtilsTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @Autowired
  public void setCommonsBeanUtilsTestBeansMapperBean(CommonsBeanUtilsTestBeansMapperBean mapperBean) {
    this.mapperBean = mapperBean;
  }

  @Override
  public void testMapEmptyDomainTableWithNullRows() throws Exception {
    try {
      super.testMapEmptyDomainTableWithNullRows();
      fail("Hier hatte eine Exception geworfen werden sollen");
    } catch (InvocationTargetException exception) {
      // Hier wird XmlTable.setRows(null) aufgerufen.
      // Die JAXB Generierung lässt das direkte setzen von Listen nicht zu.
      // Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
    }
  }

  @Test
  @Ignore("Dieser Test kann nicht funktioniert")
  @Override
  public void testMapTable() throws Exception {
    super.testMapTable();
  }
}
