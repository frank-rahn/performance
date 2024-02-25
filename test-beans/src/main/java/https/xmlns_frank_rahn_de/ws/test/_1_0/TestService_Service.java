package https.xmlns_frank_rahn_de.ws.test._1_0;

import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;

@SuppressWarnings("unused")
@WebServiceClient(name = "TestService",
    wsdlLocation = "https://xmlns.frank-rahn.de/ws/test/1.0",
    targetNamespace = "https://xmlns.frank-rahn.de/ws/test/1.0")
public class TestService_Service extends Service {

  public final static URL WSDL_LOCATION;

  public final static QName SERVICE = new QName("https://xmlns.frank-rahn.de/ws/test/1.0", "TestService");
  public final static QName TestServiceSoap = new QName("https://xmlns.frank-rahn.de/ws/test/1.0", "TestServiceSoap");

  static {
    URL url = null;
    try {
      url = new URL("https://xmlns.frank-rahn.de/ws/test/1.0");
    } catch (MalformedURLException e) {
      Logger.getLogger(TestService_Service.class.getName())
          .log(Level.INFO,
              "Can not initialize the default wsdl from {0}", "https://xmlns.frank-rahn.de/ws/test/1.0");
    }
    WSDL_LOCATION = url;
  }

  public TestService_Service(URL wsdlLocation) {
    super(wsdlLocation, SERVICE);
  }

  public TestService_Service(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
  }

  public TestService_Service() {
    super(WSDL_LOCATION, SERVICE);
  }

  public TestService_Service(WebServiceFeature... features) {
    super(WSDL_LOCATION, SERVICE, features);
  }

  public TestService_Service(URL wsdlLocation, WebServiceFeature... features) {
    super(wsdlLocation, SERVICE, features);
  }

  public TestService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
    super(wsdlLocation, serviceName, features);
  }

  /**
   * @return returns TestService
   */
  @WebEndpoint(name = "TestServiceSoap")
  public TestService getTestServiceSoap() {
    return super.getPort(TestServiceSoap, TestService.class);
  }

  /**
   * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the
   *                 <code>features</code> parameter will have their default values.
   * @return returns TestService
   */
  @WebEndpoint(name = "TestServiceSoap")
  public TestService getTestServiceSoap(WebServiceFeature... features) {
    return super.getPort(TestServiceSoap, TestService.class, features);
  }
}
