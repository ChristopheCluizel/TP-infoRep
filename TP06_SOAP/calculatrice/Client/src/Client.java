import hellowebservice.HelloWorldWS;
import hellowebservice.HelloWorldWSImplService;

public class Client {
  public static void main(String[] args) throws Exception {
    HelloWorldWS hello = (new HelloWorldWSImplService()).getHelloWorldWSImplPort();
    try{
    System.out.println(hello.addition(1,1));
    System.out.println(hello.soustraction(-1,1));
    System.out.println(hello.multiplication(1,1));
    System.out.println(hello.division(1,1));
	}
	catch(Exception e){
		System.out.println("oups");
	}
  }
}
