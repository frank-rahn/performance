/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link BeanUtils}.
 *
 * @author Frank W. Rahn
 */
@Component("Spring-BeanUtils")
@Order(2)
public class SpringBeanUtilsTestBeansMapperBean extends AbstractTestBeansMapperBean {

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    XmlTable target = createXmlTable();
    BeanUtils.copyProperties(source, target);
    return target;
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    DomainTable target = new DomainTable();
    BeanUtils.copyProperties(source, target);
    return target;
  }
}
