/*
 * Copyright © 2017 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import java.util.Calendar;
import java.util.Date;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import com.remondis.remap.Transform;

import de.frank_rahn.xmlns.types.testtypes._1.XmlRow;
import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Der Mapper für {@link Mapper}.
 *
 * @author Tom Hombergs
 */
@Component("reMap")
@Order(9)
public class ReMapTestBeansMapperBean implements TestBeansMapperBean {

	/**
	 * {@inheritDoc}
	 *
	 * @see TestBeansMapperBean#getMapperName()
	 */
	@Override
	public String getMapperName() {
		return "reMap";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		Mapper<DomainRow, XmlRow> rowMapper = Mapping.from(DomainRow.class).to(XmlRow.class).mapper();

		Mapper<DomainTable, XmlTable> tableMapper = Mapping.from(DomainTable.class).to(XmlTable.class)
			.replace(DomainTable::getDate, XmlTable::getDate).with(dateToCalendar()).useMapper(rowMapper).mapper();

		return tableMapper.map(source);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		Mapper<XmlRow, DomainRow> rowMapper = Mapping.from(XmlRow.class).to(DomainRow.class).mapper();

		Mapper<XmlTable, DomainTable> tableMapper = Mapping.from(XmlTable.class).to(DomainTable.class)
			.replace(XmlTable::getDate, DomainTable::getDate).with(calendarToDate()).useMapper(rowMapper).mapper();

		return tableMapper.map(source);
	}

	private Transform<Calendar, Date> dateToCalendar() {
		return source -> {
			if (source == null) {
				return null;
			}
			Calendar c = Calendar.getInstance();
			c.setTime(source);
			return c;
		};
	}

	private Transform<Date, Calendar> calendarToDate() {
		return source -> {
			if (source == null) {
				return null;
			}
			return source.getTime();
		};
	}

}