/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.mapstruct;

import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * Das Mapper Interface für MapStruct.
 *
 * @author Frank W. Rahn
 */
@Mapper(uses = ObjectFactory.class, componentModel = "spring")
public interface TestBeansMapper {

  List<XmlRow> domainRowsToXmlRows(List<DomainRow> domainRows);

  XmlRow domainRowToXmlRow(DomainRow domainRow);

  XmlTable domainTableToXmlTable(DomainTable domainTable);

  List<DomainRow> xmlRowsToDomainRows(List<XmlRow> xmlRows);

  DomainRow xmlRowToDomainRow(XmlRow xmlRow);

  DomainTable xmlTableToDomainTable(XmlTable xmlTable);
}
