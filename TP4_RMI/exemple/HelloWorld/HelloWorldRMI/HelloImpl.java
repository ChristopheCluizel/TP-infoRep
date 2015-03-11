package HelloWorldRMI;

import java.io.Serializable;
import HelloWorldRMI.Hello;

public class HelloImpl implements Hello, Serializable {
   public String sayHello(String nom) {
       System.out.println("Request from " + nom);
       return "Bonjour " + nom + " !";
    }
}
