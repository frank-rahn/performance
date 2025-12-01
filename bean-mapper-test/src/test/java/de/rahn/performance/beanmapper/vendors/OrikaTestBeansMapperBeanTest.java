/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import java.lang.reflect.InaccessibleObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für Orika.
 *
 * @author Frank W. Rahn
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class OrikaTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  private static final String ACCESSIBLE = "accessible: module java.base does not \"opens java.lang\"";

  @BeforeEach
  void setUp() {
    try {
      mapperBean = new OrikaTestBeansMapperBean(new ObjectFactory());
      ((OrikaTestBeansMapperBean) mapperBean).initialize();
    } catch (InaccessibleObjectException exception) {
      var err = exception.getLocalizedMessage();
      if (err.contains(ACCESSIBLE)) {
        fail(ACCESSIBLE);
      } else {
        fail("InaccessibleObjectException: " + err);
      }
    }
  }

  @Override
  @Test
  public void mapEmptyDomainTableWithNullRows() {
    assertThatThrownBy(super::mapEmptyDomainTableWithNullRows).isInstanceOf(NullPointerException.class);
  }
}
