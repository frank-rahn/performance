/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test des Mappers für ByHand.
 *
 * @author Frank W. Rahn
 */
public class ByHandTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  @BeforeEach
  public void mapperBean() {
    mapperBean = new ByHandTestBeansMapperBean(new ObjectFactory());
  }
}
