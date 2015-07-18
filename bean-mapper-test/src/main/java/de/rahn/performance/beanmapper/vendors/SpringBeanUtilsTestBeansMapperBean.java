/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Der Mapper für {@link BeanUtils}.
 * @author Frank W. Rahn
 */
@Component("Spring-BeanUtils")
@Order(2)
public class SpringBeanUtilsTestBeansMapperBean extends AbstractTestBeansMapperBean {

	/**
	 * {@inheritDoc}
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		XmlTable target = createXmlTable();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	/**
	 * {@inheritDoc}
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		DomainTable target = new DomainTable();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}