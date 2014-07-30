/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.beanmapper.mapstruct.TestBeansMapper;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Der Mapper für MapStruct.
 * @author Frank W. Rahn
 */
@Component("MapStruct")
@Order(5)
public class MapStructTestBeansMapperBean extends AbstractTestBeansMapperBean {

	@Autowired
	private TestBeansMapper testBeansMapper;

	/**
	 * {@inheritDoc}
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		return testBeansMapper.domainTableToXmlTable(source);
	}

	/**
	 * {@inheritDoc}
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		return testBeansMapper.xmlTableToDomainTable(source);
	}

}