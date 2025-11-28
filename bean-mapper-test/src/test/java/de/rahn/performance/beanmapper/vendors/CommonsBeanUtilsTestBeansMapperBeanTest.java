/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.jupiter.api.Assertions.fail;

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
public class CommonsBeanUtilsTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  public void setUp() {
    mapperBean = new CommonsBeanUtilsTestBeansMapperBean(new ObjectFactory());
  }

  @Override
  @Test
  public void testMapEmptyDomainTableWithNullRows() throws Exception {
    try {
      super.testMapEmptyDomainTableWithNullRows();
      fail("Hier hatte eine Exception geworfen werden sollen");
    } catch (InvocationTargetException exception) {
      // Hier wird XmlTable.setRows(null) aufgerufen.
      // Die JAXB Generierung lässt das direkte setzen von Listen nicht zu.
      // Sondern ruft rows.addAll(null) auf, was zum Fehler führt.
    }
  }

  @Test
  @Disabled("Dieser Test kann nicht funktioniert")
  @Override
  public void testMapTable() throws Exception {
    // Diese Methode wird überschrieben, um die Annotationen platzieren zu können
    super.testMapTable();
  }
}
