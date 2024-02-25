package org.w3._2001.xmlschema;

import static jakarta.xml.bind.DatatypeConverter.parseDateTime;
import static jakarta.xml.bind.DatatypeConverter.printDateTime;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

@SuppressWarnings("unused")
public class Adapter1 extends XmlAdapter<String, Calendar> {

  public Calendar unmarshal(String value) {
    return (parseDateTime(value));
  }

  public String marshal(Calendar value) {
    if (value == null) {
      return null;
    }
    return (printDateTime(value));
  }
}
