package helloWebService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService(name="HelloWorldWS") // PortType
@SOAPBinding(style=SOAPBinding.Style.RPC) // Binding
public interface HelloWorldWS {
  @WebMethod(action="sayHello") // Operation
  public String sayHello(@WebParam(name = "name") String name);
}
