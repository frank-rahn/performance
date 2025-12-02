/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.MappingException;

/**
 * Test des Mappers für ModelMapper.
 *
 * @author Frank W. Rahn
 */
class ModelMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  void setUp() {
    mapperBean = new ModelMapperTestBeansMapperBean(new ObjectFactory());
    ((ModelMapperTestBeansMapperBean) mapperBean).initialize();
  }

  @Override
  @Test
  void mapEmptyDomainTableWithNullRows() {
    assertThatThrownBy(super::mapEmptyDomainTableWithNullRows).isInstanceOf(MappingException.class);
  }
}
