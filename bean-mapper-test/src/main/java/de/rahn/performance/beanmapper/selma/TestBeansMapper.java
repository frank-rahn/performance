/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.selma;

import static fr.xebia.extras.selma.CollectionMappingStrategy.ALLOW_GETTER;
import static fr.xebia.extras.selma.IoC.SPRING;

import de.rahn.performance.testbeans.DomainTable;
import fr.xebia.extras.selma.Mapper;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;

/**
 * Das Mapper Interface für Selma.
 *
 * @author Frank W. Rahn
 */
@Mapper(withIoC = SPRING, withCollectionStrategy = ALLOW_GETTER, withCustom = { DateCustomMapper.class, CustomCalendar.class },
	withFactories = { ObjectFactory.class })
public interface TestBeansMapper {

	XmlTable asXmlTable(DomainTable domainTable);

	DomainTable asDomainTable(XmlTable xmlTable);

}