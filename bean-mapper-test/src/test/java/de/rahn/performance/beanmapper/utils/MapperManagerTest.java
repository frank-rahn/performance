/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import de.rahn.performance.beanmapper.config.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Ein Test für die Klasse {@link MapperManager}.
 *
 * @author Frank W. Rahn
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
class MapperManagerTest {

  private static final Logger LOGGER = getLogger(MapperManagerTest.class);

  @Autowired(required = false)
  private MapperManager manager;

  /**
   * Test method for {@link MapperManager#getMappers()}.
   */
  @Test
  void getMappers() {
    assertThat(manager).as("MapperManager wurde nicht angelegt").isNotNull();
    assertThat(manager.getMappers()).as("keine Mapper vorhanden").isNotNull();
    assertThat(manager.getMappers().length > 0).as("keine Mapper vorhanden").isTrue();

    LOGGER.info("Mappers {}", (Object) manager.getNames());
  }
}
