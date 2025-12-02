/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für Commons-BeanUtils.
 *
 * @author Frank W. Rahn
 */
class CommonsBeanUtilsTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  void setUp() {
    mapperBean = new CommonsBeanUtilsTestBeansMapperBean(new ObjectFactory());
  }

  @Override
  @Test
  void mapEmptyDomainTableWithNullRows() {
    assertThatThrownBy(super::mapEmptyDomainTableWithNullRows).isInstanceOf(InvocationTargetException.class);
  }

  @Test
  @Disabled("Dieser Test kann nicht funktioniert")
  @Override
  void mapTable() throws Exception {
    // Diese Methode wird überschrieben, um die Annotationen platzieren zu können
    super.mapTable();
  }
}
