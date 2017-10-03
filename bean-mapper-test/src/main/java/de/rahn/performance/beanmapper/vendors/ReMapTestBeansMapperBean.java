package de.rahn.performance.beanmapper.vendors;

import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import com.remondis.remap.Transform;
import de.frank_rahn.xmlns.types.testtypes._1.XmlRow;
import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class ReMapTestBeansMapperBean implements TestBeansMapperBean {

  private Mapper<XmlRow, DomainRow> xmlRowToDomainRowMapper;

  private Mapper<XmlTable, DomainTable> xmlTableToDomainTableMapper;

  private Mapper<DomainRow, XmlRow> domainRowToXmlRowMapper;

  private Mapper<DomainTable, XmlTable> domainTableToXmlTableMapper;

  public ReMapTestBeansMapperBean() {
    this.xmlRowToDomainRowMapper = Mapping
        .from(XmlRow.class)
        .to(DomainRow.class)
        .mapper();
    this.xmlTableToDomainTableMapper = Mapping
        .from(XmlTable.class)
        .to(DomainTable.class)
        .replace(XmlTable::getDate, DomainTable::getDate)
        .with(calendarToDate())
        .useMapper(xmlRowToDomainRowMapper)
        .mapper();
    this.domainRowToXmlRowMapper = Mapping
        .from(DomainRow.class)
        .to(XmlRow.class)
        .mapper();
    this.domainTableToXmlTableMapper = Mapping.from(DomainTable.class)
        .to(XmlTable.class)
        .replace(DomainTable::getDate, XmlTable::getDate)
        .with(dateToCalendar())
        .useMapper(this.domainRowToXmlRowMapper)
        .mapper();
  }

  @Override
  public String getMapperName() {
    return "reMap";
  }

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return domainTableToXmlTableMapper.map(source);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return xmlTableToDomainTableMapper.map(source);
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
