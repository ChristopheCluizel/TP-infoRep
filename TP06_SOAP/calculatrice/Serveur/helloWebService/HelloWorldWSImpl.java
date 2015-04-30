package helloWebService;

import javax.jws.WebService;

@WebService(endpointInterface="helloWebService.HelloWorldWS")
  // Port (EndPoint : lien vers une Servlet)
public class HelloWorldWSImpl implements HelloWorldWS {
  @Override
  public int addition(int a, int b)   throws EntierNegatif{
	  if(a<0 || b<0)
		throw new EntierNegatif();
    return a+b;
  }
  
  @Override
  public int soustraction(int a, int b)   throws EntierNegatif{
	  if(a<0 || b<0 || b>a)
		throw new EntierNegatif();
    return a-b;
  }
  
  @Override
  public int multiplication(int a, int b)   throws EntierNegatif{
	  if(a<0 || b<0)
		throw new EntierNegatif();
    return a*b;
  }
  
  @Override
  public int division(int a, int b)   throws EntierNegatif{
	  if(a<0 || b<0)
		throw new EntierNegatif();
    return a/b;
  }
}
