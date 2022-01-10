/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Ein Test für die Klasse {@link MapperManager}.
 *
 * @author Frank W. Rahn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class MapperManagerTest {

  private static final Logger LOGGER = getLogger(MapperManagerTest.class);

  @Autowired(required = false)
  private MapperManager manager;

  /**
   * Test method for {@link MapperManager#getMappers()}.
   */
  @Test
  public void testGetMappers() {
    assertThat("MapperManager wurde nicht angelegt", manager, notNullValue());
    assertThat("keine Mapper vorhanden", manager.getMappers(), notNullValue());
    assertThat("keine Mapper vorhanden", manager.getMappers().length, greaterThan(0));

    LOGGER.info("Mappers {}", (Object) manager.getNames());
  }
}
