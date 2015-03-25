package helloWebService;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService(name="HelloWorldWS") // PortType
@SOAPBinding(style=SOAPBinding.Style.RPC) // Binding
public interface HelloWorldWS {  
  
  @WebMethod(action="addition") // Operation
  public Complexe addition(@WebParam(name = "a") Complexe a, @WebParam(name = "b") Complexe b ) ;
  
  
  @WebMethod(action="soustraction") // Operation
  public Complexe soustraction(@WebParam(name = "a") Complexe a, @WebParam(name = "b") Complexe b )   ;
  
  
  @WebMethod(action="multiplication") // Operation
  public Complexe multiplication(@WebParam(name = "a") Complexe a, @WebParam(name = "b") Complexe b )   ;
  
  @WebMethod(action="division") // Operation
  public Complexe division(@WebParam(name = "a") Complexe a, @WebParam(name = "b") Complexe b )   ;
  
  @WebMethod(action="toString") // Operation
  public String toString(@WebParam(name = "a") Complexe a)   ;
}
