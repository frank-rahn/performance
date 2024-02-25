package org.w3._2001.xmlschema;

import static jakarta.xml.bind.DatatypeConverter.parseTime;
import static jakarta.xml.bind.DatatypeConverter.printTime;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

@SuppressWarnings("unused")
public class Adapter2 extends XmlAdapter<String, Calendar> {

  public Calendar unmarshal(String value) {
    return (parseTime(value));
  }

  public String marshal(Calendar value) {
    if (value == null) {
      return null;
    }
    return (printTime(value));
  }
}
