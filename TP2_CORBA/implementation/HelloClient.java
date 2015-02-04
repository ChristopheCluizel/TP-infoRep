import HelloWorld.*;
import org.omg.CORBA.*;

public class HelloClient {
  public static void main(String args[]) {
    try {
      String orbArguments[] = new String[0];
      ORB orb = ORB.init(orbArguments, null);
      org.omg.CORBA.Object corbaObject = orb.string_to_object(args[0]);
      Hello corbaHelloObject = HelloHelper.narrow(corbaObject);
      if(args.length==1)
        System.out.println(corbaHelloObject.sayHello(""));
      else
      {
        //System.out.println(corbaHelloObject.sayHello(args[1]));
        if(args[2].contains("+"))
			System.out.println(corbaHelloObject.addition(Integer.parseInt(args[1]),Integer.parseInt(args[3])));
		if(args[2].contains("-"))
			System.out.println(corbaHelloObject.soustraction(Integer.parseInt(args[1]),Integer.parseInt(args[3])));
		if(args[2].contains("x"))
			System.out.println(corbaHelloObject.multiplication(Integer.parseInt(args[1]),Integer.parseInt(args[3])));
		if(args[2].contains("/"))
			System.out.println(corbaHelloObject.division(Integer.parseInt(args[1]),Integer.parseInt(args[3])));
	  }
    }
    catch (Exception e) {
      System.err.println("Error : "+e);
    }
  }
}

