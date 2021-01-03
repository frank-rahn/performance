/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;

/**
 * Der Mapper für {@link ModelMapper}.
 *
 * @author Frank W. Rahn
 */
@Component("ModelMapper")
@Order(6)
public class ModelMapperTestBeansMapperBean extends AbstractTestBeansMapperBean {

	private ModelMapper modelMapper;

	/**
	 * Initialisiere diese Spring-Bean.
	 */
	@PostConstruct
	public void initialize() {
		modelMapper = new ModelMapper();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		return modelMapper.map(source, XmlTable.class);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		return modelMapper.map(source, DomainTable.class);
	}

}