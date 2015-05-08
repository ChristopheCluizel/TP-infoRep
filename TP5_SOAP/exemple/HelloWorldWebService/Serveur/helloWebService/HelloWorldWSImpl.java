package helloWebService;

import javax.jws.WebService;

@WebService(endpointInterface="helloWebService.HelloWorldWS")
  // Port (EndPoint : lien vers une Servlet)
public class HelloWorldWSImpl implements HelloWorldWS {
  @Override
  public String sayHello(String name) {
    return "Hello " + name + " !";
  }
}
