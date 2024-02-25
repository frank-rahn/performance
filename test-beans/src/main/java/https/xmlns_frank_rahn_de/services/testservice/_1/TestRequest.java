package https.xmlns_frank_rahn_de.services.testservice._1;

import static de.rahn.performance.testbeans.JAXBToStringStyle.MULTI_LINE_STYLE;

import https.xmlns_frank_rahn_de.types.testtypes._1.XmlTable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serial;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>Java-Klasse für anonymous complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="input" type="{https://xmlns.frank-rahn.de/types/testtypes/1.0}xmlTable"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@SuppressWarnings({"JavadocLinkAsPlainText", "unused"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "input"
})
@XmlRootElement(name = "testRequest")
public class TestRequest implements Serializable {

  @Serial
  private final static long serialVersionUID = 1L;
  @XmlElement(required = true)
  protected XmlTable input;

  /**
   * Ruft den Wert der input-Eigenschaft ab.
   *
   * @return possible object is {@link XmlTable }
   */
  public XmlTable getInput() {
    return input;
  }

  /**
   * Legt den Wert der input-Eigenschaft fest.
   *
   * @param value allowed object is {@link XmlTable }
   */
  public void setInput(XmlTable value) {
    this.input = value;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, MULTI_LINE_STYLE);
  }

  public TestRequest withInput(XmlTable value) {
    setInput(value);
    return this;
  }
}
