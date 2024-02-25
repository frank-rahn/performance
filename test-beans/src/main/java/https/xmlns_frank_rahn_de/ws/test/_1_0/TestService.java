package https.xmlns_frank_rahn_de.ws.test._1_0;

import https.xmlns_frank_rahn_de.services.testservice._1.TestRequest;
import https.xmlns_frank_rahn_de.services.testservice._1.TestResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "https://xmlns.frank-rahn.de/ws/test/1.0", name = "TestService")
@XmlSeeAlso({https.xmlns_frank_rahn_de.services.testservice._1.ObjectFactory.class,
    https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TestService {

  @WebMethod(action = "https://xmlns.frank-rahn.de/ws/test/1.0/test")
  @WebResult(name = "testResponse", targetNamespace = "https://xmlns.frank-rahn.de/services/testservice/1.0", partName = "testRequest")
  TestResponse test(
      @WebParam(partName = "testRequest", name = "testRequest", targetNamespace = "https://xmlns.frank-rahn.de/services/testservice/1.0")
      TestRequest testRequest
  );
}
