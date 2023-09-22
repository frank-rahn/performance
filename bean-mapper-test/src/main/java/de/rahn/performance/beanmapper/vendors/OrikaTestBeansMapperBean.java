/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import javax.annotation.PostConstruct;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link MapperFacade}.
 *
 * @author Frank W. Rahn
 */
//@Component("Orika")
@Order(4)
public class OrikaTestBeansMapperBean extends AbstractTestBeansMapperBean {

  private BoundMapperFacade<DomainTable, XmlTable> mapDomainTable;
  private BoundMapperFacade<XmlTable, DomainTable> mapXmlTable;

  /**
   * Initialisiere diese Spring-Bean.
   */
  @PostConstruct
  public void initialize() {
    MapperFactory factory = new DefaultMapperFactory.Builder().build();
    mapDomainTable = factory.getMapperFacade(DomainTable.class, XmlTable.class);
    mapXmlTable = factory.getMapperFacade(XmlTable.class, DomainTable.class);
  }

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return mapDomainTable.map(source);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return mapXmlTable.map(source);
  }
}
