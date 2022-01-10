/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Allgemeine Basisklasse für den {@link TestBeansMapperBean}.
 *
 * @author Frank W. Rahn
 */
public abstract class AbstractTestBeansMapperBean implements TestBeansMapperBean, BeanNameAware {

  @Autowired
  private ObjectFactory factory;

  private String beanName;

  @Override
  public String getMapperName() {
    return beanName;
  }

  @Override
  public void setBeanName(@SuppressWarnings("NullableProblems") String name) {
    beanName = name;
  }

  /**
   * @return das Zielobjekt
   */
  protected final XmlRow createXmlRow() {
    return factory.createXmlRow();
  }

  /**
   * @return das Zielobjekt
   */
  @SuppressWarnings("unused")
  protected final List<XmlRow> createXmlRows() {
    return new ArrayList<>();
  }

  /**
   * @return das Zielobjekt
   */
  protected final XmlTable createXmlTable() {
    return factory.createXmlTable();
  }
}
