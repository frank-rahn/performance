/*
 * Copyright © 2016 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.conversion;
import static com.googlecode.jmapper.api.JMapperAPI.global;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlRow;
import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import javax.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Der Mapper für {@link JMapper}.
 *
 * @author Frank W. Rahn
 */
@Component("JMapper")
@Order(7)
public class JMapperTestBeansMapperBean extends AbstractTestBeansMapperBean {

  private JMapper<XmlTable, DomainTable> domainToXmlMapper;

  private JMapper<DomainTable, XmlTable> xmlToDomainMapper;

  /**
   * Initialisiere diese Spring-Bean.
   */
  @PostConstruct
  public void initialize() {
    JMapperAPI jMapperAPI = new JMapperAPI()
        .add(mappedClass(XmlTable.class).add(global())
            .add(conversion("dateToCalendar").from("date").to("date")
                .body("java.util.Calendar c = java.util.Calendar.getInstance(); c.setTime(${source}); return c;")))
        .add(mappedClass(XmlRow.class).add(global()))
        .add(mappedClass(DomainTable.class).add(global().excludedAttributes("id"))
            .add(conversion("calendarToDate").from("date").to("date").body("return ${source}.getTime();"))
            .add(attribute("rows").value("rows").targetClasses(DomainRow.class)))
        .add(mappedClass(DomainRow.class).add(global().excludedAttributes("id")));

    domainToXmlMapper = new JMapper<>(XmlTable.class, DomainTable.class, jMapperAPI);
    xmlToDomainMapper = new JMapper<>(DomainTable.class, XmlTable.class, jMapperAPI);
  }

  @Override
  public XmlTable map(DomainTable source) throws Exception {
    return domainToXmlMapper.getDestination(source);
  }

  @Override
  public DomainTable map(XmlTable source) throws Exception {
    return xmlToDomainMapper.getDestination(source);
  }
}
