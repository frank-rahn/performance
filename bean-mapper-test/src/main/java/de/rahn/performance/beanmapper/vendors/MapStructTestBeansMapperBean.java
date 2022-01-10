/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.mapstruct.TestBeansMapper;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für MapStruct.
 *
 * @author Frank W. Rahn
 */
@Component("MapStruct")
@Order(5)
public class MapStructTestBeansMapperBean extends AbstractTestBeansMapperBean {

  @Autowired
  private TestBeansMapper testBeansMapper;

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return testBeansMapper.domainTableToXmlTable(source);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return testBeansMapper.xmlTableToDomainTable(source);
  }
}
