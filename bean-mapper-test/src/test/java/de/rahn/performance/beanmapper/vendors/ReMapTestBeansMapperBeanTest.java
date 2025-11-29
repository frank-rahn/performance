/*
 * Copyright © 2017 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import com.remondis.remap.AssertMapping;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test des Mappers für reMap.
 *
 * @author Tom Hombergs
 */
public class ReMapTestBeansMapperBeanTest extends AbstractTestBeansMapperBeanTest {

  private static final String ACCESSIBLE = "accessible: module java.base does not \"opens java.lang\"";

  @BeforeEach
  public void setUp() {
    try {
      mapperBean = new ReMapTestBeansMapperBean().initialize();
    } catch (UnsupportedOperationException exception) {
      var err = exception.getLocalizedMessage();
      if (err.contains(ACCESSIBLE)) {
        Assertions.fail(ACCESSIBLE);
      } else {
        Assertions.fail("UnsupportedOperationException: " + err);
      }
    }
  }

  /**
   * Teste den Mapper.
   */
  @Test
  public void testDomainToXmlTableMapper() {
    ReMapTestBeansMapperBean reMapTestBeansMapperBean = (ReMapTestBeansMapperBean) mapperBean;

    // @formatter:off
		AssertMapping.of(reMapTestBeansMapperBean.domainToXmlTableMapper)
			.expectReplace(DomainTable::getDate, XmlTable::getDate)
				.andTest(reMapTestBeansMapperBean.dateToCalendar())
			.ensure();
		// @formatter:on
  }

  /**
   * Teste den Mapper.
   */
  @Test
  public void testXmlToDomainTableMapper() {
    ReMapTestBeansMapperBean reMapTestBeansMapperBean = (ReMapTestBeansMapperBean) mapperBean;

    // @formatter:off
		AssertMapping.of(reMapTestBeansMapperBean.xmlToDomainTableMapper)
			.expectReplace(XmlTable::getDate, DomainTable::getDate)
				.andTest(reMapTestBeansMapperBean.calendarToDate())
			.ensure();
		// @formatter:on
  }
}
