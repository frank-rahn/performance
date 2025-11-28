/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.jupiter.api.Assertions.fail;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.MappingException;

/**
 * Test des Mappers für ModelMapper.
 *
 * @author Frank W. Rahn
 */
public class ModelMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  public void setUp() {
    mapperBean = new ModelMapperTestBeansMapperBean(new ObjectFactory());
    ((ModelMapperTestBeansMapperBean) mapperBean).initialize();
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
