import hellowebservice.HelloWorldWS;
import hellowebservice.HelloWorldWSImplService;
import hellowebservice.Complexe;
public class Client {
  public static void main(String[] args) throws Exception {
    HelloWorldWS hello = (new HelloWorldWSImplService()).getHelloWorldWSImplPort();
    try{
		Complexe a = new Complexe();
		a.setRe(1.0);
		a.setIm(1.0);
		Complexe b = new Complexe();
		b.setRe(2.0);
		b.setIm(2.0);
    System.out.println(hello.toString(hello.addition(a,b)));
    System.out.println(hello.toString(hello.soustraction(a,b)));
    System.out.println(hello.toString(hello.multiplication(a,b)));
    System.out.println(hello.toString(hello.division(a,b)));
	}
	catch(Exception e){
		System.out.println("oups");
	}
  }
}
