/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.dozermapper.core.MappingException;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für Dozer.
 *
 * @author Frank W. Rahn
 */
class DozerTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  void setUp() {
    mapperBean = new DozerTestBeansMapperBean(new ObjectFactory());
    ((DozerTestBeansMapperBean) mapperBean).initialize();
  }

  @Override
  @Test
  public void mapEmptyDomainTableWithNullRows() {
    assertThatThrownBy(super::mapEmptyDomainTableWithNullRows).isInstanceOf(MappingException.class);
  }
}
