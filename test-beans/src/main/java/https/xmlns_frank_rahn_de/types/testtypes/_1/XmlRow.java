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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.w3._2001.xmlschema.Adapter3;

/**
 * Dieser Datentyp entspricht einer Zeile einer Tabelle.
 *
 * <p>Java-Klasse für xmlRow complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="xmlRow"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="column00" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column01" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="column03" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column04" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column05" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column06" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column07" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column08" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column09" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column10" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column11" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column12" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="column13" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column14" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column15" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column16" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column17" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column18" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column19" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column20" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column21" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column22" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="column23" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column24" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column25" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column26" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column27" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column28" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column29" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="column30" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column31" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column32" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="column33" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column34" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column35" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column36" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column37" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column38" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column39" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="column40" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column41" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column42" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="column43" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column44" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column45" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column46" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column47" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column48" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column49" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="column50" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column51" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column52" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="column53" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column54" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column55" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column56" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column57" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column58" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column59" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="column60" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column61" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column62" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="column63" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column64" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column65" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column66" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column67" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column68" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column69" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column70" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column71" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column72" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="column73" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column74" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column75" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column76" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column77" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column78" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="column79" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="columns" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@SuppressWarnings({"DataFlowIssue", "unused", "JavadocLinkAsPlainText"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlRow", propOrder = {
    "column00",
    "column01",
    "column02",
    "column03",
    "column04",
    "column05",
    "column06",
    "column07",
    "column08",
    "column09",
    "column10",
    "column11",
    "column12",
    "column13",
    "column14",
    "column15",
    "column16",
    "column17",
    "column18",
    "column19",
    "column20",
    "column21",
    "column22",
    "column23",
    "column24",
    "column25",
    "column26",
    "column27",
    "column28",
    "column29",
    "column30",
    "column31",
    "column32",
    "column33",
    "column34",
    "column35",
    "column36",
    "column37",
    "column38",
    "column39",
    "column40",
    "column41",
    "column42",
    "column43",
    "column44",
    "column45",
    "column46",
    "column47",
    "column48",
    "column49",
    "column50",
    "column51",
    "column52",
    "column53",
    "column54",
    "column55",
    "column56",
    "column57",
    "column58",
    "column59",
    "column60",
    "column61",
    "column62",
    "column63",
    "column64",
    "column65",
    "column66",
    "column67",
    "column68",
    "column69",
    "column70",
    "column71",
    "column72",
    "column73",
    "column74",
    "column75",
    "column76",
    "column77",
    "column78",
    "column79",
    "columns"
})
public class XmlRow implements Serializable {

  @Serial
  private final static long serialVersionUID = 1L;
  @XmlElement(required = true)
  protected String column00;
  @XmlElement(required = true, defaultValue = "Test String 01")
  protected String column01;
  protected String column02;
  @XmlElement(required = true)
  protected String column03;
  @XmlElement(required = true)
  protected String column04;
  @XmlElement(required = true)
  protected String column05;
  @XmlElement(required = true)
  protected String column06;
  @XmlElement(required = true)
  protected String column07;
  @XmlElement(required = true)
  protected String column08;
  @XmlElement(required = true)
  protected String column09;
  protected int column10;
  @XmlElement(defaultValue = "11")
  protected int column11;
  protected Integer column12;
  protected int column13;
  protected int column14;
  protected int column15;
  protected int column16;
  protected int column17;
  protected int column18;
  protected int column19;
  protected boolean column20;
  @XmlElement(defaultValue = "true")
  protected boolean column21;
  protected Boolean column22;
  protected boolean column23;
  protected boolean column24;
  protected boolean column25;
  protected boolean column26;
  protected boolean column27;
  protected boolean column28;
  protected boolean column29;
  protected long column30;
  @XmlElement(defaultValue = "31")
  protected long column31;
  protected Long column32;
  protected long column33;
  protected long column34;
  protected long column35;
  protected long column36;
  protected long column37;
  protected long column38;
  protected long column39;
  @XmlElement(required = true)
  protected BigDecimal column40;
  @XmlElement(required = true, defaultValue = "41.14")
  protected BigDecimal column41;
  protected BigDecimal column42;
  @XmlElement(required = true)
  protected BigDecimal column43;
  @XmlElement(required = true)
  protected BigDecimal column44;
  @XmlElement(required = true)
  protected BigDecimal column45;
  @XmlElement(required = true)
  protected BigDecimal column46;
  @XmlElement(required = true)
  protected BigDecimal column47;
  @XmlElement(required = true)
  protected BigDecimal column48;
  @XmlElement(required = true)
  protected BigDecimal column49;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column50;
  @XmlElement(required = true, type = String.class, defaultValue = "2014-07-01")
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column51;
  @XmlElement(type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column52;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column53;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column54;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column55;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column56;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column57;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column58;
  @XmlElement(required = true, type = String.class)
  @XmlJavaTypeAdapter(Adapter3.class)
  @XmlSchemaType(name = "date")
  protected Calendar column59;
  @XmlElement(required = true)
  protected String column60;
  @XmlElement(required = true, defaultValue = "Test String 61")
  protected String column61;
  protected String column62;
  @XmlElement(required = true)
  protected String column63;
  @XmlElement(required = true)
  protected String column64;
  @XmlElement(required = true)
  protected String column65;
  @XmlElement(required = true)
  protected String column66;
  @XmlElement(required = true)
  protected String column67;
  @XmlElement(required = true)
  protected String column68;
  @XmlElement(required = true)
  protected String column69;
  protected int column70;
  @XmlElement(defaultValue = "71")
  protected int column71;
  protected Integer column72;
  protected int column73;
  protected int column74;
  protected int column75;
  protected int column76;
  protected int column77;
  protected int column78;
  protected int column79;
  protected List<String> columns;

  /**
   * Ruft den Wert der column00-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn00() {
    return column00;
  }

  /**
   * Legt den Wert der column00-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn00(String value) {
    this.column00 = value;
  }

  /**
   * Ruft den Wert der column01-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn01() {
    return column01;
  }

  /**
   * Legt den Wert der column01-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn01(String value) {
    this.column01 = value;
  }

  /**
   * Ruft den Wert der column02-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn02() {
    return column02;
  }

  /**
   * Legt den Wert der column02-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn02(String value) {
    this.column02 = value;
  }

  /**
   * Ruft den Wert der column03-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn03() {
    return column03;
  }

  /**
   * Legt den Wert der column03-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn03(String value) {
    this.column03 = value;
  }

  /**
   * Ruft den Wert der column04-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn04() {
    return column04;
  }

  /**
   * Legt den Wert der column04-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn04(String value) {
    this.column04 = value;
  }

  /**
   * Ruft den Wert der column05-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn05() {
    return column05;
  }

  /**
   * Legt den Wert der column05-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn05(String value) {
    this.column05 = value;
  }

  /**
   * Ruft den Wert der column06-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn06() {
    return column06;
  }

  /**
   * Legt den Wert der column06-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn06(String value) {
    this.column06 = value;
  }

  /**
   * Ruft den Wert der column07-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn07() {
    return column07;
  }

  /**
   * Legt den Wert der column07-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn07(String value) {
    this.column07 = value;
  }

  /**
   * Ruft den Wert der column08-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn08() {
    return column08;
  }

  /**
   * Legt den Wert der column08-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn08(String value) {
    this.column08 = value;
  }

  /**
   * Ruft den Wert der column09-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn09() {
    return column09;
  }

  /**
   * Legt den Wert der column09-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn09(String value) {
    this.column09 = value;
  }

  /**
   * Ruft den Wert der column10-Eigenschaft ab.
   */
  public int getColumn10() {
    return column10;
  }

  /**
   * Legt den Wert der column10-Eigenschaft fest.
   */
  public void setColumn10(int value) {
    this.column10 = value;
  }

  /**
   * Ruft den Wert der column11-Eigenschaft ab.
   */
  public int getColumn11() {
    return column11;
  }

  /**
   * Legt den Wert der column11-Eigenschaft fest.
   */
  public void setColumn11(int value) {
    this.column11 = value;
  }

  /**
   * Ruft den Wert der column12-Eigenschaft ab.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getColumn12() {
    return column12;
  }

  /**
   * Legt den Wert der column12-Eigenschaft fest.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setColumn12(Integer value) {
    this.column12 = value;
  }

  /**
   * Ruft den Wert der column13-Eigenschaft ab.
   */
  public int getColumn13() {
    return column13;
  }

  /**
   * Legt den Wert der column13-Eigenschaft fest.
   */
  public void setColumn13(int value) {
    this.column13 = value;
  }

  /**
   * Ruft den Wert der column14-Eigenschaft ab.
   */
  public int getColumn14() {
    return column14;
  }

  /**
   * Legt den Wert der column14-Eigenschaft fest.
   */
  public void setColumn14(int value) {
    this.column14 = value;
  }

  /**
   * Ruft den Wert der column15-Eigenschaft ab.
   */
  public int getColumn15() {
    return column15;
  }

  /**
   * Legt den Wert der column15-Eigenschaft fest.
   */
  public void setColumn15(int value) {
    this.column15 = value;
  }

  /**
   * Ruft den Wert der column16-Eigenschaft ab.
   */
  public int getColumn16() {
    return column16;
  }

  /**
   * Legt den Wert der column16-Eigenschaft fest.
   */
  public void setColumn16(int value) {
    this.column16 = value;
  }

  /**
   * Ruft den Wert der column17-Eigenschaft ab.
   */
  public int getColumn17() {
    return column17;
  }

  /**
   * Legt den Wert der column17-Eigenschaft fest.
   */
  public void setColumn17(int value) {
    this.column17 = value;
  }

  /**
   * Ruft den Wert der column18-Eigenschaft ab.
   */
  public int getColumn18() {
    return column18;
  }

  /**
   * Legt den Wert der column18-Eigenschaft fest.
   */
  public void setColumn18(int value) {
    this.column18 = value;
  }

  /**
   * Ruft den Wert der column19-Eigenschaft ab.
   */
  public int getColumn19() {
    return column19;
  }

  /**
   * Legt den Wert der column19-Eigenschaft fest.
   */
  public void setColumn19(int value) {
    this.column19 = value;
  }

  /**
   * Ruft den Wert der column20-Eigenschaft ab.
   */
  public boolean isColumn20() {
    return column20;
  }

  /**
   * Legt den Wert der column20-Eigenschaft fest.
   */
  public void setColumn20(boolean value) {
    this.column20 = value;
  }

  /**
   * Ruft den Wert der column21-Eigenschaft ab.
   */
  public boolean isColumn21() {
    return column21;
  }

  /**
   * Legt den Wert der column21-Eigenschaft fest.
   */
  public void setColumn21(boolean value) {
    this.column21 = value;
  }

  /**
   * Ruft den Wert der column22-Eigenschaft ab.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean getColumn22() {
    return column22;
  }

  /**
   * Legt den Wert der column22-Eigenschaft fest.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setColumn22(Boolean value) {
    this.column22 = value;
  }

  /**
   * Ruft den Wert der column23-Eigenschaft ab.
   */
  public boolean isColumn23() {
    return column23;
  }

  /**
   * Legt den Wert der column23-Eigenschaft fest.
   */
  public void setColumn23(boolean value) {
    this.column23 = value;
  }

  /**
   * Ruft den Wert der column24-Eigenschaft ab.
   */
  public boolean isColumn24() {
    return column24;
  }

  /**
   * Legt den Wert der column24-Eigenschaft fest.
   */
  public void setColumn24(boolean value) {
    this.column24 = value;
  }

  /**
   * Ruft den Wert der column25-Eigenschaft ab.
   */
  public boolean isColumn25() {
    return column25;
  }

  /**
   * Legt den Wert der column25-Eigenschaft fest.
   */
  public void setColumn25(boolean value) {
    this.column25 = value;
  }

  /**
   * Ruft den Wert der column26-Eigenschaft ab.
   */
  public boolean isColumn26() {
    return column26;
  }

  /**
   * Legt den Wert der column26-Eigenschaft fest.
   */
  public void setColumn26(boolean value) {
    this.column26 = value;
  }

  /**
   * Ruft den Wert der column27-Eigenschaft ab.
   */
  public boolean isColumn27() {
    return column27;
  }

  /**
   * Legt den Wert der column27-Eigenschaft fest.
   */
  public void setColumn27(boolean value) {
    this.column27 = value;
  }

  /**
   * Ruft den Wert der column28-Eigenschaft ab.
   */
  public boolean isColumn28() {
    return column28;
  }

  /**
   * Legt den Wert der column28-Eigenschaft fest.
   */
  public void setColumn28(boolean value) {
    this.column28 = value;
  }

  /**
   * Ruft den Wert der column29-Eigenschaft ab.
   */
  public boolean isColumn29() {
    return column29;
  }

  /**
   * Legt den Wert der column29-Eigenschaft fest.
   */
  public void setColumn29(boolean value) {
    this.column29 = value;
  }

  /**
   * Ruft den Wert der column30-Eigenschaft ab.
   */
  public long getColumn30() {
    return column30;
  }

  /**
   * Legt den Wert der column30-Eigenschaft fest.
   */
  public void setColumn30(long value) {
    this.column30 = value;
  }

  /**
   * Ruft den Wert der column31-Eigenschaft ab.
   */
  public long getColumn31() {
    return column31;
  }

  /**
   * Legt den Wert der column31-Eigenschaft fest.
   */
  public void setColumn31(long value) {
    this.column31 = value;
  }

  /**
   * Ruft den Wert der column32-Eigenschaft ab.
   *
   * @return possible object is {@link Long }
   */
  public Long getColumn32() {
    return column32;
  }

  /**
   * Legt den Wert der column32-Eigenschaft fest.
   *
   * @param value allowed object is {@link Long }
   */
  public void setColumn32(Long value) {
    this.column32 = value;
  }

  /**
   * Ruft den Wert der column33-Eigenschaft ab.
   */
  public long getColumn33() {
    return column33;
  }

  /**
   * Legt den Wert der column33-Eigenschaft fest.
   */
  public void setColumn33(long value) {
    this.column33 = value;
  }

  /**
   * Ruft den Wert der column34-Eigenschaft ab.
   */
  public long getColumn34() {
    return column34;
  }

  /**
   * Legt den Wert der column34-Eigenschaft fest.
   */
  public void setColumn34(long value) {
    this.column34 = value;
  }

  /**
   * Ruft den Wert der column35-Eigenschaft ab.
   */
  public long getColumn35() {
    return column35;
  }

  /**
   * Legt den Wert der column35-Eigenschaft fest.
   */
  public void setColumn35(long value) {
    this.column35 = value;
  }

  /**
   * Ruft den Wert der column36-Eigenschaft ab.
   */
  public long getColumn36() {
    return column36;
  }

  /**
   * Legt den Wert der column36-Eigenschaft fest.
   */
  public void setColumn36(long value) {
    this.column36 = value;
  }

  /**
   * Ruft den Wert der column37-Eigenschaft ab.
   */
  public long getColumn37() {
    return column37;
  }

  /**
   * Legt den Wert der column37-Eigenschaft fest.
   */
  public void setColumn37(long value) {
    this.column37 = value;
  }

  /**
   * Ruft den Wert der column38-Eigenschaft ab.
   */
  public long getColumn38() {
    return column38;
  }

  /**
   * Legt den Wert der column38-Eigenschaft fest.
   */
  public void setColumn38(long value) {
    this.column38 = value;
  }

  /**
   * Ruft den Wert der column39-Eigenschaft ab.
   */
  public long getColumn39() {
    return column39;
  }

  /**
   * Legt den Wert der column39-Eigenschaft fest.
   */
  public void setColumn39(long value) {
    this.column39 = value;
  }

  /**
   * Ruft den Wert der column40-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn40() {
    return column40;
  }

  /**
   * Legt den Wert der column40-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn40(BigDecimal value) {
    this.column40 = value;
  }

  /**
   * Ruft den Wert der column41-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn41() {
    return column41;
  }

  /**
   * Legt den Wert der column41-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn41(BigDecimal value) {
    this.column41 = value;
  }

  /**
   * Ruft den Wert der column42-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn42() {
    return column42;
  }

  /**
   * Legt den Wert der column42-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn42(BigDecimal value) {
    this.column42 = value;
  }

  /**
   * Ruft den Wert der column43-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn43() {
    return column43;
  }

  /**
   * Legt den Wert der column43-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn43(BigDecimal value) {
    this.column43 = value;
  }

  /**
   * Ruft den Wert der column44-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn44() {
    return column44;
  }

  /**
   * Legt den Wert der column44-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn44(BigDecimal value) {
    this.column44 = value;
  }

  /**
   * Ruft den Wert der column45-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn45() {
    return column45;
  }

  /**
   * Legt den Wert der column45-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn45(BigDecimal value) {
    this.column45 = value;
  }

  /**
   * Ruft den Wert der column46-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn46() {
    return column46;
  }

  /**
   * Legt den Wert der column46-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn46(BigDecimal value) {
    this.column46 = value;
  }

  /**
   * Ruft den Wert der column47-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn47() {
    return column47;
  }

  /**
   * Legt den Wert der column47-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn47(BigDecimal value) {
    this.column47 = value;
  }

  /**
   * Ruft den Wert der column48-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn48() {
    return column48;
  }

  /**
   * Legt den Wert der column48-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn48(BigDecimal value) {
    this.column48 = value;
  }

  /**
   * Ruft den Wert der column49-Eigenschaft ab.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getColumn49() {
    return column49;
  }

  /**
   * Legt den Wert der column49-Eigenschaft fest.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setColumn49(BigDecimal value) {
    this.column49 = value;
  }

  /**
   * Ruft den Wert der column50-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn50() {
    return column50;
  }

  /**
   * Legt den Wert der column50-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn50(Calendar value) {
    this.column50 = value;
  }

  /**
   * Ruft den Wert der column51-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn51() {
    return column51;
  }

  /**
   * Legt den Wert der column51-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn51(Calendar value) {
    this.column51 = value;
  }

  /**
   * Ruft den Wert der column52-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn52() {
    return column52;
  }

  /**
   * Legt den Wert der column52-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn52(Calendar value) {
    this.column52 = value;
  }

  /**
   * Ruft den Wert der column53-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn53() {
    return column53;
  }

  /**
   * Legt den Wert der column53-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn53(Calendar value) {
    this.column53 = value;
  }

  /**
   * Ruft den Wert der column54-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn54() {
    return column54;
  }

  /**
   * Legt den Wert der column54-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn54(Calendar value) {
    this.column54 = value;
  }

  /**
   * Ruft den Wert der column55-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn55() {
    return column55;
  }

  /**
   * Legt den Wert der column55-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn55(Calendar value) {
    this.column55 = value;
  }

  /**
   * Ruft den Wert der column56-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn56() {
    return column56;
  }

  /**
   * Legt den Wert der column56-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn56(Calendar value) {
    this.column56 = value;
  }

  /**
   * Ruft den Wert der column57-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn57() {
    return column57;
  }

  /**
   * Legt den Wert der column57-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn57(Calendar value) {
    this.column57 = value;
  }

  /**
   * Ruft den Wert der column58-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn58() {
    return column58;
  }

  /**
   * Legt den Wert der column58-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn58(Calendar value) {
    this.column58 = value;
  }

  /**
   * Ruft den Wert der column59-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public Calendar getColumn59() {
    return column59;
  }

  /**
   * Legt den Wert der column59-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn59(Calendar value) {
    this.column59 = value;
  }

  /**
   * Ruft den Wert der column60-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn60() {
    return column60;
  }

  /**
   * Legt den Wert der column60-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn60(String value) {
    this.column60 = value;
  }

  /**
   * Ruft den Wert der column61-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn61() {
    return column61;
  }

  /**
   * Legt den Wert der column61-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn61(String value) {
    this.column61 = value;
  }

  /**
   * Ruft den Wert der column62-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn62() {
    return column62;
  }

  /**
   * Legt den Wert der column62-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn62(String value) {
    this.column62 = value;
  }

  /**
   * Ruft den Wert der column63-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn63() {
    return column63;
  }

  /**
   * Legt den Wert der column63-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn63(String value) {
    this.column63 = value;
  }

  /**
   * Ruft den Wert der column64-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn64() {
    return column64;
  }

  /**
   * Legt den Wert der column64-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn64(String value) {
    this.column64 = value;
  }

  /**
   * Ruft den Wert der column65-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn65() {
    return column65;
  }

  /**
   * Legt den Wert der column65-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn65(String value) {
    this.column65 = value;
  }

  /**
   * Ruft den Wert der column66-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn66() {
    return column66;
  }

  /**
   * Legt den Wert der column66-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn66(String value) {
    this.column66 = value;
  }

  /**
   * Ruft den Wert der column67-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn67() {
    return column67;
  }

  /**
   * Legt den Wert der column67-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn67(String value) {
    this.column67 = value;
  }

  /**
   * Ruft den Wert der column68-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn68() {
    return column68;
  }

  /**
   * Legt den Wert der column68-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn68(String value) {
    this.column68 = value;
  }

  /**
   * Ruft den Wert der column69-Eigenschaft ab.
   *
   * @return possible object is {@link String }
   */
  public String getColumn69() {
    return column69;
  }

  /**
   * Legt den Wert der column69-Eigenschaft fest.
   *
   * @param value allowed object is {@link String }
   */
  public void setColumn69(String value) {
    this.column69 = value;
  }

  /**
   * Ruft den Wert der column70-Eigenschaft ab.
   */
  public int getColumn70() {
    return column70;
  }

  /**
   * Legt den Wert der column70-Eigenschaft fest.
   */
  public void setColumn70(int value) {
    this.column70 = value;
  }

  /**
   * Ruft den Wert der column71-Eigenschaft ab.
   */
  public int getColumn71() {
    return column71;
  }

  /**
   * Legt den Wert der column71-Eigenschaft fest.
   */
  public void setColumn71(int value) {
    this.column71 = value;
  }

  /**
   * Ruft den Wert der column72-Eigenschaft ab.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getColumn72() {
    return column72;
  }

  /**
   * Legt den Wert der column72-Eigenschaft fest.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setColumn72(Integer value) {
    this.column72 = value;
  }

  /**
   * Ruft den Wert der column73-Eigenschaft ab.
   */
  public int getColumn73() {
    return column73;
  }

  /**
   * Legt den Wert der column73-Eigenschaft fest.
   */
  public void setColumn73(int value) {
    this.column73 = value;
  }

  /**
   * Ruft den Wert der column74-Eigenschaft ab.
   */
  public int getColumn74() {
    return column74;
  }

  /**
   * Legt den Wert der column74-Eigenschaft fest.
   */
  public void setColumn74(int value) {
    this.column74 = value;
  }

  /**
   * Ruft den Wert der column75-Eigenschaft ab.
   */
  public int getColumn75() {
    return column75;
  }

  /**
   * Legt den Wert der column75-Eigenschaft fest.
   */
  public void setColumn75(int value) {
    this.column75 = value;
  }

  /**
   * Ruft den Wert der column76-Eigenschaft ab.
   */
  public int getColumn76() {
    return column76;
  }

  /**
   * Legt den Wert der column76-Eigenschaft fest.
   */
  public void setColumn76(int value) {
    this.column76 = value;
  }

  /**
   * Ruft den Wert der column77-Eigenschaft ab.
   */
  public int getColumn77() {
    return column77;
  }

  /**
   * Legt den Wert der column77-Eigenschaft fest.
   */
  public void setColumn77(int value) {
    this.column77 = value;
  }

  /**
   * Ruft den Wert der column78-Eigenschaft ab.
   */
  public int getColumn78() {
    return column78;
  }

  /**
   * Legt den Wert der column78-Eigenschaft fest.
   */
  public void setColumn78(int value) {
    this.column78 = value;
  }

  /**
   * Ruft den Wert der column79-Eigenschaft ab.
   */
  public int getColumn79() {
    return column79;
  }

  /**
   * Legt den Wert der column79-Eigenschaft fest.
   */
  public void setColumn79(int value) {
    this.column79 = value;
  }

  /**
   * Gets the value of the columns' property.
   *
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore, any modification you make to
   * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
   * the columns' property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getColumns().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list {@link String }
   */
  public List<String> getColumns() {
    if (columns == null) {
      columns = new ArrayList<>();
    }
    return this.columns;
  }

  public void setColumns(List<String> value) {
    this.columns = null;
    List<String> draftl = this.getColumns();
    draftl.addAll(value);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, MULTI_LINE_STYLE);
  }

  public XmlRow withColumn00(String value) {
    setColumn00(value);
    return this;
  }

  public XmlRow withColumn01(String value) {
    setColumn01(value);
    return this;
  }

  public XmlRow withColumn02(String value) {
    setColumn02(value);
    return this;
  }

  public XmlRow withColumn03(String value) {
    setColumn03(value);
    return this;
  }

  public XmlRow withColumn04(String value) {
    setColumn04(value);
    return this;
  }

  public XmlRow withColumn05(String value) {
    setColumn05(value);
    return this;
  }

  public XmlRow withColumn06(String value) {
    setColumn06(value);
    return this;
  }

  public XmlRow withColumn07(String value) {
    setColumn07(value);
    return this;
  }

  public XmlRow withColumn08(String value) {
    setColumn08(value);
    return this;
  }

  public XmlRow withColumn09(String value) {
    setColumn09(value);
    return this;
  }

  public XmlRow withColumn10(int value) {
    setColumn10(value);
    return this;
  }

  public XmlRow withColumn11(int value) {
    setColumn11(value);
    return this;
  }

  public XmlRow withColumn12(Integer value) {
    setColumn12(value);
    return this;
  }

  public XmlRow withColumn13(int value) {
    setColumn13(value);
    return this;
  }

  public XmlRow withColumn14(int value) {
    setColumn14(value);
    return this;
  }

  public XmlRow withColumn15(int value) {
    setColumn15(value);
    return this;
  }

  public XmlRow withColumn16(int value) {
    setColumn16(value);
    return this;
  }

  public XmlRow withColumn17(int value) {
    setColumn17(value);
    return this;
  }

  public XmlRow withColumn18(int value) {
    setColumn18(value);
    return this;
  }

  public XmlRow withColumn19(int value) {
    setColumn19(value);
    return this;
  }

  public XmlRow withColumn20(boolean value) {
    setColumn20(value);
    return this;
  }

  public XmlRow withColumn21(boolean value) {
    setColumn21(value);
    return this;
  }

  public XmlRow withColumn22(Boolean value) {
    setColumn22(value);
    return this;
  }

  public XmlRow withColumn23(boolean value) {
    setColumn23(value);
    return this;
  }

  public XmlRow withColumn24(boolean value) {
    setColumn24(value);
    return this;
  }

  public XmlRow withColumn25(boolean value) {
    setColumn25(value);
    return this;
  }

  public XmlRow withColumn26(boolean value) {
    setColumn26(value);
    return this;
  }

  public XmlRow withColumn27(boolean value) {
    setColumn27(value);
    return this;
  }

  public XmlRow withColumn28(boolean value) {
    setColumn28(value);
    return this;
  }

  public XmlRow withColumn29(boolean value) {
    setColumn29(value);
    return this;
  }

  public XmlRow withColumn30(long value) {
    setColumn30(value);
    return this;
  }

  public XmlRow withColumn31(long value) {
    setColumn31(value);
    return this;
  }

  public XmlRow withColumn32(Long value) {
    setColumn32(value);
    return this;
  }

  public XmlRow withColumn33(long value) {
    setColumn33(value);
    return this;
  }

  public XmlRow withColumn34(long value) {
    setColumn34(value);
    return this;
  }

  public XmlRow withColumn35(long value) {
    setColumn35(value);
    return this;
  }

  public XmlRow withColumn36(long value) {
    setColumn36(value);
    return this;
  }

  public XmlRow withColumn37(long value) {
    setColumn37(value);
    return this;
  }

  public XmlRow withColumn38(long value) {
    setColumn38(value);
    return this;
  }

  public XmlRow withColumn39(long value) {
    setColumn39(value);
    return this;
  }

  public XmlRow withColumn40(BigDecimal value) {
    setColumn40(value);
    return this;
  }

  public XmlRow withColumn41(BigDecimal value) {
    setColumn41(value);
    return this;
  }

  public XmlRow withColumn42(BigDecimal value) {
    setColumn42(value);
    return this;
  }

  public XmlRow withColumn43(BigDecimal value) {
    setColumn43(value);
    return this;
  }

  public XmlRow withColumn44(BigDecimal value) {
    setColumn44(value);
    return this;
  }

  public XmlRow withColumn45(BigDecimal value) {
    setColumn45(value);
    return this;
  }

  public XmlRow withColumn46(BigDecimal value) {
    setColumn46(value);
    return this;
  }

  public XmlRow withColumn47(BigDecimal value) {
    setColumn47(value);
    return this;
  }

  public XmlRow withColumn48(BigDecimal value) {
    setColumn48(value);
    return this;
  }

  public XmlRow withColumn49(BigDecimal value) {
    setColumn49(value);
    return this;
  }

  public XmlRow withColumn50(Calendar value) {
    setColumn50(value);
    return this;
  }

  public XmlRow withColumn51(Calendar value) {
    setColumn51(value);
    return this;
  }

  public XmlRow withColumn52(Calendar value) {
    setColumn52(value);
    return this;
  }

  public XmlRow withColumn53(Calendar value) {
    setColumn53(value);
    return this;
  }

  public XmlRow withColumn54(Calendar value) {
    setColumn54(value);
    return this;
  }

  public XmlRow withColumn55(Calendar value) {
    setColumn55(value);
    return this;
  }

  public XmlRow withColumn56(Calendar value) {
    setColumn56(value);
    return this;
  }

  public XmlRow withColumn57(Calendar value) {
    setColumn57(value);
    return this;
  }

  public XmlRow withColumn58(Calendar value) {
    setColumn58(value);
    return this;
  }

  public XmlRow withColumn59(Calendar value) {
    setColumn59(value);
    return this;
  }

  public XmlRow withColumn60(String value) {
    setColumn60(value);
    return this;
  }

  public XmlRow withColumn61(String value) {
    setColumn61(value);
    return this;
  }

  public XmlRow withColumn62(String value) {
    setColumn62(value);
    return this;
  }

  public XmlRow withColumn63(String value) {
    setColumn63(value);
    return this;
  }

  public XmlRow withColumn64(String value) {
    setColumn64(value);
    return this;
  }

  public XmlRow withColumn65(String value) {
    setColumn65(value);
    return this;
  }

  public XmlRow withColumn66(String value) {
    setColumn66(value);
    return this;
  }

  public XmlRow withColumn67(String value) {
    setColumn67(value);
    return this;
  }

  public XmlRow withColumn68(String value) {
    setColumn68(value);
    return this;
  }

  public XmlRow withColumn69(String value) {
    setColumn69(value);
    return this;
  }

  public XmlRow withColumn70(int value) {
    setColumn70(value);
    return this;
  }

  public XmlRow withColumn71(int value) {
    setColumn71(value);
    return this;
  }

  public XmlRow withColumn72(Integer value) {
    setColumn72(value);
    return this;
  }

  public XmlRow withColumn73(int value) {
    setColumn73(value);
    return this;
  }

  public XmlRow withColumn74(int value) {
    setColumn74(value);
    return this;
  }

  public XmlRow withColumn75(int value) {
    setColumn75(value);
    return this;
  }

  public XmlRow withColumn76(int value) {
    setColumn76(value);
    return this;
  }

  public XmlRow withColumn77(int value) {
    setColumn77(value);
    return this;
  }

  public XmlRow withColumn78(int value) {
    setColumn78(value);
    return this;
  }

  public XmlRow withColumn79(int value) {
    setColumn79(value);
    return this;
  }

  public XmlRow withColumns(String... values) {
    if (values != null) {
      for (String value : values) {
        getColumns().add(value);
      }
    }
    return this;
  }

  public XmlRow withColumns(Collection<String> values) {
    if (values != null) {
      getColumns().addAll(values);
    }
    return this;
  }

  public XmlRow withColumns(List<String> value) {
    setColumns(value);
    return this;
  }
}
