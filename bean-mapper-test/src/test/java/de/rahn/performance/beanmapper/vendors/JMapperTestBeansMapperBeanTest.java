/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.Assert.fail;

import com.googlecode.jmapper.exceptions.JMapperException;
import org.junit.Before;
import org.junit.Ignore;

/**
 * Test des Mappers für JMapper.
 *
 * @author Frank W. Rahn
 */
@Ignore("Abgeschaltet, wegen einer InaccessibleObjectException unter JDK-17 nicht lauffähig und nicht mehr gepflegt "
    + "(EOL)")
public class JMapperTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @Before
  public void setUp() {
    mapperBean = new JMapperTestBeansMapperBean();
    ((JMapperTestBeansMapperBean) mapperBean).initialize();
  }

  @Override
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
