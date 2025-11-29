/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.jupiter.api.Assertions.fail;

import com.googlecode.jmapper.exceptions.JMapperException;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für JMapper.
 *
 * @author Frank W. Rahn
 */
public class JMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  private static final String ACCESSIBLE = "accessible: module java.base does not \"opens java.util\"";

  @BeforeEach
  public void setUp() {
    try {
      mapperBean = new JMapperTestBeansMapperBean(new ObjectFactory());
      ((JMapperTestBeansMapperBean) mapperBean).initialize();
    } catch (JMapperException error) {
      var exception = error.getCause(); // java.lang.ExceptionInInitializerError
      exception = exception.getCause(); // java.lang.reflect.InaccessibleObjectException
      var err = exception.getLocalizedMessage();
      if (err.contains(ACCESSIBLE)) {
        Assertions.fail(ACCESSIBLE);
      } else {
        Assertions.fail("InaccessibleObjectException: " + err);
      }

      fail(exception.getMessage());
    }
  }

  @Override
  @Test
  public void testMapEmptyDomainTableWithNullRows() throws Exception {
    try {
      super.testMapEmptyDomainTableWithNullRows();
      fail("Hier hatte eine Exception geworfen werden sollen");
    } catch (JMapperException exception) {
      // Hier wird XmlTable.setRows(null) aufgerufen.
      // Die JAXB Generierung lässt das direkte setzen von Listen nicht zu.
      // Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
    }
  }
}
