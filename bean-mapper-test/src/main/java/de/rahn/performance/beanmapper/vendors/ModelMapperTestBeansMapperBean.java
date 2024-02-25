/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link ModelMapper}.
 *
 * @author Frank W. Rahn
 */
@Component("ModelMapper")
@Order(6)
public class ModelMapperTestBeansMapperBean extends AbstractTestBeansMapperBean {

  private ModelMapper modelMapper;

  public ModelMapperTestBeansMapperBean(ObjectFactory factory) {
    super(factory);
  }

  /**
   * Initialisiere diese Spring-Bean.
   */
  @PostConstruct
  public void initialize() {
    modelMapper = new ModelMapper();
  }

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return modelMapper.map(source, XmlTable.class);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return modelMapper.map(source, DomainTable.class);
  }
}
