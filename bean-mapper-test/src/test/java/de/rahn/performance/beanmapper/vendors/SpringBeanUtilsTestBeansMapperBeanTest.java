/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für Spring-BeanUtils.
 *
 * @author Frank W. Rahn
 */
class SpringBeanUtilsTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  void mapperBean() {
    mapperBean = new SpringBeanUtilsTestBeansMapperBean(new ObjectFactory());
  }

  @SuppressWarnings("EmptyMethod")
  @Test
  @Disabled("Dieser Test kann nicht funktioniert")
  @Override
  void mapTable() throws Exception {
    // Diese Methode wird überschrieben, um die Annotationen platzieren zu können
    super.mapTable();
  }
}
