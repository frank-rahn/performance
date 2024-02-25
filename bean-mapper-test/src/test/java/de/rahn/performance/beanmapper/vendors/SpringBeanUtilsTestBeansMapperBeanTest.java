/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test des Mappers für Spring-BeanUtils.
 *
 * @author Frank W. Rahn
 */
public class SpringBeanUtilsTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @Before
  public void mapperBean() {
    mapperBean = new SpringBeanUtilsTestBeansMapperBean(new ObjectFactory());
  }

  @SuppressWarnings("EmptyMethod")
  @Test
  @Ignore("Dieser Test kann nicht funktioniert")
  @Override
  public void testMapTable() throws Exception {
    // Diese Methode wird überschrieben, um die Annotationen platzieren zu können
    super.testMapTable();
  }
}
