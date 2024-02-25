package org.w3._2001.xmlschema;

import static jakarta.xml.bind.DatatypeConverter.parseDate;
import static jakarta.xml.bind.DatatypeConverter.printDate;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

public class Adapter3 extends XmlAdapter<String, Calendar> {

  public Calendar unmarshal(String value) {
    return (parseDate(value));
  }

  public String marshal(Calendar value) {
    if (value == null) {
      return null;
    }
    return (printDate(value));
  }
}
