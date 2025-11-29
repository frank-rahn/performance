/*
 * Copyright © 2017 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import jakarta.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link Mapper}.
 * <p>
 * <strong><em>Achtung</em></strong>: Dieser Mapper liefert unter JDK-21 eine UnsupportedOperationException!
 *
 * @author Tom Hombergs
 */
@Component("reMap")
@Order(9)
public class ReMapTestBeansMapperBean implements TestBeansMapperBean {

  protected Mapper<DomainTable, XmlTable> domainToXmlTableMapper;

  protected Mapper<XmlTable, DomainTable> xmlToDomainTableMapper;

  @Override
  public String getMapperName() {
    return "reMap";
  }

  /**
   * Initialisiere diese Spring-Bean.
   */
  @PostConstruct
  public ReMapTestBeansMapperBean initialize() {
    Mapper<DomainRow, XmlRow> domainToXmlRowMapper = Mapping.from(DomainRow.class).to(XmlRow.class).mapper();
    Mapper<XmlRow, DomainRow> xmlToDomainRowMapper = Mapping.from(XmlRow.class).to(DomainRow.class).mapper();

    // @formatter:off
		domainToXmlTableMapper = Mapping
			.from(DomainTable.class)
			.to(XmlTable.class)
			.replace(DomainTable::getDate, XmlTable::getDate)
				.with(dateToCalendar())
			.useMapper(domainToXmlRowMapper)
			.mapper();

		xmlToDomainTableMapper = Mapping
			.from(XmlTable.class)
			.to(DomainTable.class)
			.replace(XmlTable::getDate, DomainTable::getDate)
				.with(calendarToDate())
			.useMapper(xmlToDomainRowMapper).mapper();
		// @formatter:on

    return this;
  }

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return domainToXmlTableMapper.map(source);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return xmlToDomainTableMapper.map(source);
  }

  /**
   * @return ein Transformer von {@link Date} nach {@link Calendar}
   */
  protected Function<Date, Calendar> dateToCalendar() {
    return source -> {
      if (source == null) {
        return null;
      }

      Calendar c = Calendar.getInstance();
      c.setTime(source);
      return c;
    };
  }

  /**
   * @return ein Transformer von {@link Calendar} nach {@link Date}
   */
  protected Function<Calendar, Date> calendarToDate() {
    return source -> {
      if (source == null) {
        return null;
      }

      return source.getTime();
    };
  }
}
