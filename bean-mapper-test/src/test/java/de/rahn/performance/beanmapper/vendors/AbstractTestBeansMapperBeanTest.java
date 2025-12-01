/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import de.rahn.performance.testbeans.TestBeansUtils;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

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
  public void mapEmptyDomainTableWithEmptyRows() throws Exception {
    DomainTable source = new DomainTable();
    source.setRows(new ArrayList<>());

    XmlTable target = mapperBean.map(source);
    org.assertj.core.api.Assertions.assertThat(target).as("Kein Ergebnis geliefert").isNotNull();
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(DomainTable)}.
   */
  @Test
  public void mapEmptyDomainTableWithNullRows() throws Exception {
    XmlTable target = mapperBean.map(new DomainTable());
    org.assertj.core.api.Assertions.assertThat(target).as("Kein Ergebnis geliefert").isNotNull();
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(XmlTable)}.
   */
  @Test
  public void mapEmptyXmlTableWithEmptyRows() throws Exception {
    XmlTable source = new XmlTable();
    source.setRows(new ArrayList<>());

    DomainTable target = mapperBean.map(source);
    org.assertj.core.api.Assertions.assertThat(target).as("Kein Ergebnis geliefert").isNotNull();
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(XmlTable)}.
   */
  @Test
  public void mapEmptyXmlTableWithNullRows() throws Exception {
    DomainTable target = mapperBean.map(new XmlTable());
    org.assertj.core.api.Assertions.assertThat(target).as("Kein Ergebnis geliefert").isNotNull();
  }

  /**
   * Test method for {@link AbstractTestBeansMapperBean#map(XmlTable)}.
   */
  @Test
  public void mapTable() throws Exception {
    DomainTable source = TestBeansUtils.createDomainTable(1, 1);

    XmlTable temp = mapperBean.map(source);
    org.assertj.core.api.Assertions.assertThat(temp).as("Kein Zwischenergebnis geliefert").isNotNull();
    org.assertj.core.api.Assertions.assertThat(temp.getRows()).as("Zwischenergebnis hat keine Zeilen").isNotNull();
    org.assertj.core.api.Assertions.assertThat(temp.getRows().size() > 0).as("Zwischenergebnis hat keine Zeilen").isTrue();
    org.assertj.core.api.Assertions.assertThat(temp.getRows().getFirst()).as("Die Zeilen des Zwischenergebnis habe einen falschen Typ").isInstanceOf(XmlRow.class);

    DomainTable target = mapperBean.map(temp);
    org.assertj.core.api.Assertions.assertThat(target).as("Kein Ergebnis geliefert").isNotNull();
    assertThat("source und target nicht gleich", target, is(source));
  }
}
