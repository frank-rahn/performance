/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

import com.googlecode.jmapper.exceptions.JMapperException;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für JMapper.
 *
 * @author Frank W. Rahn
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class JMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  private static final String ACCESSIBLE = "accessible: module java.base does not \"opens java.util\"";

  @BeforeEach
  void setUp() {
    try {
      mapperBean = new JMapperTestBeansMapperBean(new ObjectFactory());
      ((JMapperTestBeansMapperBean) mapperBean).initialize();
    } catch (JMapperException error) {
      var exception = error.getCause(); // java.lang.ExceptionInInitializerError
      exception = exception.getCause(); // java.lang.reflect.InaccessibleObjectException
      var err = exception.getLocalizedMessage();
      if (err.contains(ACCESSIBLE)) {
        fail(ACCESSIBLE);
      } else {
        fail("InaccessibleObjectException: " + err);
      }

      fail(exception.getMessage());
    }
  }

  @Override
  @Test
  void mapEmptyDomainTableWithNullRows() {
    assertThatThrownBy(super::mapEmptyDomainTableWithNullRows).isInstanceOf(JMapperException.class);
  }
}
