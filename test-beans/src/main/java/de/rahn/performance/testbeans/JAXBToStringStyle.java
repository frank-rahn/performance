package de.rahn.performance.testbeans;

import jakarta.xml.bind.JAXBElement;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public interface JAXBToStringStyle {

  ToStringStyle MULTI_LINE_STYLE = new ToStringStyle() {
    {
      this.setContentStart("[");
      this.setFieldSeparator(System.lineSeparator() + "  ");
      this.setFieldSeparatorAtStart(true);
      this.setContentEnd(System.lineSeparator() + "]");
    }

    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
      if (value instanceof JAXBElement) {
        buffer.append(ToStringBuilder.reflectionToString(value, this));
      } else {
        buffer.append(value);
      }
    }
  };
}
