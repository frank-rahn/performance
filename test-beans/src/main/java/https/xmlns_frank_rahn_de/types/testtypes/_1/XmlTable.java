package https.xmlns_frank_rahn_de.types.testtypes._1;

import static de.rahn.performance.testbeans.JAXBToStringStyle.MULTI_LINE_STYLE;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.w3._2001.xmlschema.Adapter3;

/**
 * Dieser Datentyp entspricht einer Tabelle.
 *
 * <p>Java-Klasse für xmlTable complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="xmlTable"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="rows" type="{https://xmlns.frank-rahn.de/types/testtypes/1.0}xmlRow" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@SuppressWarnings({"JavadocLinkAsPlainText", "DataFlowIssue", "unused"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlTable", propOrder = {
    "name",
    "date",
    "rows"
})
public class XmlTable implements Serializable {

  @Serial
  private final static long serialVersionUID = 1L;
  @XmlElement(required = true)
  protected String name;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar date;
  protected List<XmlRow> rows;

  /**
   * Ruft den Wert der name-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Legt den Wert der name-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Ruft den Wert der date-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getDate() {
    return date;
  }

  /**
   * Legt den Wert der date-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setDate(Calendar value) {
    this.date = value;
  }

  /**
   * Gets the value of the rows' property.
   *
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore, any modification you make to
   * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
   * the rows' property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getRows().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list {@link XmlRow }
   */
  public List<XmlRow> getRows() {
    if (rows == null) {
      rows = new ArrayList<>();
    }
    return this.rows;
  }

  public void setRows(List<XmlRow> value) {
    this.rows = null;
    List<XmlRow> draftl = this.getRows();
    draftl.addAll(value);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, MULTI_LINE_STYLE);
  }

  public XmlTable withName(String value) {
    setName(value);
    return this;
  }

  public XmlTable withDate(Calendar value) {
    setDate(value);
    return this;
  }

  public XmlTable withRows(XmlRow... values) {
    if (values != null) {
      for (XmlRow value : values) {
        getRows().add(value);
      }
    }
    return this;
  }

  public XmlTable withRows(Collection<XmlRow> values) {
    if (values != null) {
      getRows().addAll(values);
    }
    return this;
  }

  public XmlTable withRows(List<XmlRow> value) {
    setRows(value);
    return this;
  }
}
