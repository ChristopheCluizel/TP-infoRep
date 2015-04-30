package helloWebService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService(name="HelloWorldWS") // PortType
@SOAPBinding(style=SOAPBinding.Style.RPC) // Binding
public interface HelloWorldWS {  
  
  @WebMethod(action="addition") // Operation
  public int addition(@WebParam(name = "a") int a, @WebParam(name = "b") int b )  throws EntierNegatif ;
  
  
  @WebMethod(action="soustraction") // Operation
  public int soustraction(@WebParam(name = "a") int a, @WebParam(name = "b") int b )   throws EntierNegatif ;
  
  
  @WebMethod(action="multiplication") // Operation
  public int multiplication(@WebParam(name = "a") int a, @WebParam(name = "b") int b )   throws EntierNegatif ;
  
  @WebMethod(action="division") // Operation
  public int division(@WebParam(name = "a") int a, @WebParam(name = "b") int b )   throws EntierNegatif ;
}
