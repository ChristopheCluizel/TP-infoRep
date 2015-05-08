import hellowebservice.HelloWorldWS;
import hellowebservice.HelloWorldWSImplService;

public class Client {
  public static void main(String[] args) throws Exception {
    HelloWorldWS hello = (new HelloWorldWSImplService()).getHelloWorldWSImplPort();
    System.out.println(hello.sayHello(args[0]));
  }
}
