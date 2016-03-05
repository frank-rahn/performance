/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.factory.JAXBBeanFactory;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeDefinition;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.frank_rahn.xmlns.types.testtypes._1.XmlRow;
import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Der Mapper für {@link DozerBeanMapper}.
 * 
 * @author Frank W. Rahn
 */
@Component("Dozer")
@Order(3)
public class DozerTestBeansMapperBean extends AbstractTestBeansMapperBean {

	private Mapper dozer;

	/**
	 * Initialisiere diese Spring-Bean.
	 */
	@PostConstruct
	public void initialize() {
		dozer = new DozerBeanMapper();
		// Bekannt geben, das die Xml*-Klassen JAXB Objekte sind
		((DozerBeanMapper) dozer).addMapping(new BeanMappingBuilder() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see BeanMappingBuilder#configure()
			 */
			@Override
			protected void configure() {
				mapping(new TypeDefinition(DomainTable.class),
					new TypeDefinition(XmlTable.class).beanFactory(JAXBBeanFactory.class));
			}
		});
		((DozerBeanMapper) dozer).addMapping(new BeanMappingBuilder() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see BeanMappingBuilder#configure()
			 */
			@Override
			protected void configure() {
				mapping(new TypeDefinition(DomainRow.class),
					new TypeDefinition(XmlRow.class).beanFactory(JAXBBeanFactory.class));
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		return dozer.map(source, XmlTable.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		return dozer.map(source, DomainTable.class);
	}

}