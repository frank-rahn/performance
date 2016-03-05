/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Die Schnittstelle aller Spring-Beans der Test-Mapper.
 * 
 * @author Frank W. Rahn
 */
public interface TestBeansMapperBean {

	/**
	 * @return Name des Mappers
	 */
	String getMapperName();

	/**
	 * @param source das Objekt, welches zu mappen ist
	 * @return das neue Objekt
	 */
	XmlTable map(DomainTable source) throws Exception;

	/**
	 * @param source das Objekt, welches zu mappen ist
	 * @return das neue Objekt
	 */
	DomainTable map(XmlTable source) throws Exception;

}