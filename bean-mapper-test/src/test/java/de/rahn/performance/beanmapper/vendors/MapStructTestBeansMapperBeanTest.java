/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.junit.jupiter.api.Assertions.fail;

import de.rahn.performance.beanmapper.config.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test des Mappers für MapStruct.
 *
 * @author Frank W. Rahn
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class MapStructTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @Autowired
  public void setMapStructTestBeansMapperBean(MapStructTestBeansMapperBean mapperBean) {
    this.mapperBean = mapperBean;
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
