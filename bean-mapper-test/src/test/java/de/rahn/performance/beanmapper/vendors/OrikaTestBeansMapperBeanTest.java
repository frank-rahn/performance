/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import org.junit.Before;

/**
 * Test des Mappers für Orika.
 *
 * @author Frank W. Rahn
 */
public class OrikaTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @Before
  public void setUp() {
    mapperBean = new OrikaTestBeansMapperBean();
    ((OrikaTestBeansMapperBean) mapperBean).initialize();
  }

  @Override
  public void testMapEmptyDomainTableWithNullRows() throws Exception {
    try {
      super.testMapEmptyDomainTableWithNullRows();
      fail("Hier hatte eine Exception geworfen werden sollen");
    } catch (NullPointerException exception) {
      // Hier wird XmlTable.setRows(null) aufgerufen.
      // Die JAXB Generierung lässt das direkte setzen von Listen nicht zu.
      // Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
    }
  }
}
