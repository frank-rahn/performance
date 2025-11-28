/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.jupiter.api.Assertions.fail;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import java.lang.reflect.InaccessibleObjectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für Orika.
 *
 * @author Frank W. Rahn
 */
@Disabled("Vorübergehen abgeschaltet, da wegen einer InaccessibleObjectException unter JDK-17 nicht lauffähig")
public class OrikaTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {
  private static final String ACCESSIBLE = "accessible: module java.base does not \"opens java.lang\"";

  @BeforeEach
  public void setUp() {
    try {
      mapperBean = new OrikaTestBeansMapperBean(new ObjectFactory());
      ((OrikaTestBeansMapperBean) mapperBean).initialize();
    } catch (InaccessibleObjectException exception) {
      var err = exception.getLocalizedMessage();
      if(err.contains(ACCESSIBLE)) {
        Assertions.fail(ACCESSIBLE);
      } else {
        Assertions.fail("InaccessibleObjectException: " + err);
      }
    }
  }

  @Override
  @Test
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
