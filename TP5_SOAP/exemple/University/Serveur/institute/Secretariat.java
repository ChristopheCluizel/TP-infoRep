package institute;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService(name="Secretariat")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface Secretariat {
  @WebMethod(action="register")
  public Student register(@WebParam(name="candidate") Candidate candidate, @WebParam(name="testValue") int testValue) throws ChaineVide;
}
