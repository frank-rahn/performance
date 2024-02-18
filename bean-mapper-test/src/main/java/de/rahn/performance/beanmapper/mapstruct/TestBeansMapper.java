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
import org.mapstruct.Mapping;

/**
 * Das Mapper Interface für MapStruct.
 *
 * @author Frank W. Rahn
 */
@Mapper(uses = ObjectFactory.class, componentModel = "spring")
public interface TestBeansMapper {

  List<XmlRow> domainRowsToXmlRows(List<DomainRow> domainRows);

  @Mapping(target = "withColumn00", ignore = true)
  @Mapping(target = "withColumn01", ignore = true)
  @Mapping(target = "withColumn02", ignore = true)
  @Mapping(target = "withColumn03", ignore = true)
  @Mapping(target = "withColumn04", ignore = true)
  @Mapping(target = "withColumn05", ignore = true)
  @Mapping(target = "withColumn06", ignore = true)
  @Mapping(target = "withColumn07", ignore = true)
  @Mapping(target = "withColumn08", ignore = true)
  @Mapping(target = "withColumn09", ignore = true)
  @Mapping(target = "withColumn10", ignore = true)
  @Mapping(target = "withColumn11", ignore = true)
  @Mapping(target = "withColumn12", ignore = true)
  @Mapping(target = "withColumn13", ignore = true)
  @Mapping(target = "withColumn14", ignore = true)
  @Mapping(target = "withColumn15", ignore = true)
  @Mapping(target = "withColumn16", ignore = true)
  @Mapping(target = "withColumn17", ignore = true)
  @Mapping(target = "withColumn18", ignore = true)
  @Mapping(target = "withColumn19", ignore = true)
  @Mapping(target = "withColumn20", ignore = true)
  @Mapping(target = "withColumn21", ignore = true)
  @Mapping(target = "withColumn22", ignore = true)
  @Mapping(target = "withColumn23", ignore = true)
  @Mapping(target = "withColumn24", ignore = true)
  @Mapping(target = "withColumn25", ignore = true)
  @Mapping(target = "withColumn26", ignore = true)
  @Mapping(target = "withColumn27", ignore = true)
  @Mapping(target = "withColumn28", ignore = true)
  @Mapping(target = "withColumn29", ignore = true)
  @Mapping(target = "withColumn30", ignore = true)
  @Mapping(target = "withColumn31", ignore = true)
  @Mapping(target = "withColumn32", ignore = true)
  @Mapping(target = "withColumn33", ignore = true)
  @Mapping(target = "withColumn34", ignore = true)
  @Mapping(target = "withColumn35", ignore = true)
  @Mapping(target = "withColumn36", ignore = true)
  @Mapping(target = "withColumn37", ignore = true)
  @Mapping(target = "withColumn38", ignore = true)
  @Mapping(target = "withColumn39", ignore = true)
  @Mapping(target = "withColumn40", ignore = true)
  @Mapping(target = "withColumn41", ignore = true)
  @Mapping(target = "withColumn42", ignore = true)
  @Mapping(target = "withColumn43", ignore = true)
  @Mapping(target = "withColumn44", ignore = true)
  @Mapping(target = "withColumn45", ignore = true)
  @Mapping(target = "withColumn46", ignore = true)
  @Mapping(target = "withColumn47", ignore = true)
  @Mapping(target = "withColumn48", ignore = true)
  @Mapping(target = "withColumn49", ignore = true)
  @Mapping(target = "withColumn50", ignore = true)
  @Mapping(target = "withColumn51", ignore = true)
  @Mapping(target = "withColumn52", ignore = true)
  @Mapping(target = "withColumn53", ignore = true)
  @Mapping(target = "withColumn54", ignore = true)
  @Mapping(target = "withColumn55", ignore = true)
  @Mapping(target = "withColumn56", ignore = true)
  @Mapping(target = "withColumn57", ignore = true)
  @Mapping(target = "withColumn58", ignore = true)
  @Mapping(target = "withColumn59", ignore = true)
  @Mapping(target = "withColumn60", ignore = true)
  @Mapping(target = "withColumn61", ignore = true)
  @Mapping(target = "withColumn62", ignore = true)
  @Mapping(target = "withColumn63", ignore = true)
  @Mapping(target = "withColumn64", ignore = true)
  @Mapping(target = "withColumn65", ignore = true)
  @Mapping(target = "withColumn66", ignore = true)
  @Mapping(target = "withColumn67", ignore = true)
  @Mapping(target = "withColumn68", ignore = true)
  @Mapping(target = "withColumn69", ignore = true)
  @Mapping(target = "withColumn70", ignore = true)
  @Mapping(target = "withColumn71", ignore = true)
  @Mapping(target = "withColumn72", ignore = true)
  @Mapping(target = "withColumn73", ignore = true)
  @Mapping(target = "withColumn74", ignore = true)
  @Mapping(target = "withColumn75", ignore = true)
  @Mapping(target = "withColumn76", ignore = true)
  @Mapping(target = "withColumn77", ignore = true)
  @Mapping(target = "withColumn78", ignore = true)
  @Mapping(target = "withColumn79", ignore = true)
  @Mapping(target = "withColumns", ignore = true)
  XmlRow domainRowToXmlRow(DomainRow domainRow);

  @Mapping(target = "withName", ignore = true)
  @Mapping(target = "withDate", ignore = true)
  @Mapping(target = "withRows", ignore = true)
  XmlTable domainTableToXmlTable(DomainTable domainTable);

  List<DomainRow> xmlRowsToDomainRows(List<XmlRow> xmlRows);

  DomainRow xmlRowToDomainRow(XmlRow xmlRow);

  DomainTable xmlTableToDomainTable(XmlTable xmlTable);
}
