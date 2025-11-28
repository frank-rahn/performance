/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.jupiter.api.Assertions.fail;

import com.github.dozermapper.core.MappingException;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für Dozer.
 *
 * @author Frank W. Rahn
 */
public class DozerTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  public void setUp() {
    mapperBean = new DozerTestBeansMapperBean(new ObjectFactory());
    ((DozerTestBeansMapperBean) mapperBean).initialize();
  }

  @Override
  @Test
  public void testMapEmptyDomainTableWithNullRows() throws Exception {
    try {
      super.testMapEmptyDomainTableWithNullRows();
      fail("Hier hatte eine Exception geworfen werden sollen");
    } catch (MappingException exception) {
      // Hier wird XmlTable.setRows(null) aufgerufen.
      // Die JAXB Generierung lässt das direkte setzen von Listen nicht zu.
      // Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
    }
  }
}
