/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;

/**
 * Der Mapper für {@link BeanUtils}.
 * 
 * @author Frank W. Rahn
 */
@Component("Commons-BeanUtils")
@Order(1)
public class CommonsBeanUtilsTestBeansMapperBean extends AbstractTestBeansMapperBean {

	/**
	 * {@inheritDoc}
	 * 
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		XmlTable target = createXmlTable();
		BeanUtils.copyProperties(target, source);
		return target;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		DomainTable target = new DomainTable();
		BeanUtils.copyProperties(target, source);
		return target;
	}

}