package helloWebService;

import javax.jws.WebService;

@WebService(endpointInterface="helloWebService.HelloWorldWS")
  // Port (EndPoint : lien vers une Servlet)
public class HelloWorldWSImpl implements HelloWorldWS {
  @Override
  public Complexe addition(Complexe a, Complexe b) {
    return a.plus(b);
  }
  
  @Override
  public Complexe soustraction(Complexe a, Complexe b) {
    return a.minus(b);
  }
  
  @Override
  public Complexe multiplication(Complexe a, Complexe b) {
    return a.times(b);
  }
  
  @Override
  public Complexe division(Complexe a, Complexe b)  {
    return a.divides(b);
  }
  
  @Override
  public String toString(Complexe a) {
	  return a.toString();
  }
}
