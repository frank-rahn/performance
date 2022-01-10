/*
 * Copyright © 2017 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.selma.TestBeansMapper;
import de.rahn.performance.testbeans.DomainTable;
import fr.xebia.extras.selma.Selma;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link Selma}.
 *
 * @author Frank W. Rahn
 */
@Component("Selma")
@Order(8)
public class SelmaTestBeansMapperBean extends AbstractTestBeansMapperBean {

  @Autowired
  private TestBeansMapper mapper;

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return mapper.asXmlTable(source);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return mapper.asDomainTable(source);
  }
}
