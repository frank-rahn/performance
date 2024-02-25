/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.factory.JAXBBeanFactory;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.TypeDefinition;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import jakarta.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link Mapper}.
 *
 * @author Frank W. Rahn
 */
@Component("Dozer")
@Order(3)
public class DozerTestBeansMapperBean extends AbstractTestBeansMapperBean {

  private Mapper dozer;

  public DozerTestBeansMapperBean(ObjectFactory factory) {
    super(factory);
  }

  /**
   * Initialisiere diese Spring-Bean.
   */
  @PostConstruct
  public void initialize() {
    dozer = DozerBeanMapperBuilder.create()
        // Bekannt geben, dass die Xml*-Klassen JAXB Objekte sind
        .withMappingBuilder(new BeanMappingBuilder() {
          @Override
          protected void configure() {
            mapping(new TypeDefinition(DomainTable.class),
                new TypeDefinition(XmlTable.class).beanFactory(JAXBBeanFactory.class));
          }
        })
        .withMappingBuilder(new BeanMappingBuilder() {
          @Override
          protected void configure() {
            mapping(new TypeDefinition(DomainRow.class),
                new TypeDefinition(XmlRow.class).beanFactory(JAXBBeanFactory.class));
          }
        })
        .build();
  }

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return dozer.map(source, XmlTable.class);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return dozer.map(source, DomainTable.class);
  }
}
