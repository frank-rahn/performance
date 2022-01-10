/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import de.rahn.performance.testbeans.TestBeansUtils;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Test für {@link TestBeansMapperBean}.
 *
 * @author Frank W. Rahn
 */
public abstract class AbstractTestBeansMapperBeanTest {

  protected TestBeansMapperBean mapperBean;

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(DomainTable)}.
   */
  @Test
  public void testMapEmptyDomainTableWithEmptyRows() throws Exception {
    DomainTable source = new DomainTable();
    source.setRows(new ArrayList<>());

    XmlTable target = mapperBean.map(source);
    assertThat("Kein Ergebnis geliefert", target, notNullValue());
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(DomainTable)}.
   */
  @Test
  public void testMapEmptyDomainTableWithNullRows() throws Exception {
    XmlTable target = mapperBean.map(new DomainTable());
    assertThat("Kein Ergebnis geliefert", target, notNullValue());
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(XmlTable)}.
   */
  @Test
  public void testMapEmptyXmlTableWithEmptyRows() throws Exception {
    XmlTable source = new XmlTable();
    source.setRows(new ArrayList<>());

    DomainTable target = mapperBean.map(source);
    assertThat("Kein Ergebnis geliefert", target, notNullValue());
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(XmlTable)}.
   */
  @Test
  public void testMapEmptyXmlTableWithNullRows() throws Exception {
    DomainTable target = mapperBean.map(new XmlTable());
    assertThat("Kein Ergebnis geliefert", target, notNullValue());
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(XmlTable)}.
   */
  @Test
  public void testMapTable() throws Exception {
    DomainTable source = TestBeansUtils.createDomainTable(1, 1);

    XmlTable temp = mapperBean.map(source);
    assertThat("Kein Zwischenergebnis geliefert", temp, notNullValue());
    assertThat("Zwischenergebnis hat keine Zeilen", temp.getRows(), notNullValue());
    assertThat("Zwischenergebnis hat keine Zeilen", temp.getRows().size(), greaterThan(0));
    assertThat("Die Zeilen des Zwischenergebnis habe einen falschen Typ", temp.getRows().get(0),
        instanceOf(XmlRow.class));

    DomainTable target = mapperBean.map(temp);
    assertThat("Kein Ergebnis geliefert", target, notNullValue());
    assertThat("source und target nicht gleich", target, is(source));
  }
}
