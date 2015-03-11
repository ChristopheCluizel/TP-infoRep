package HelloWorldSerializable;

import java.rmi.RemoteException;
import java.io.Serializable;

public class HelloImpl implements Hello,Serializable {
   public String sayHello(Guy aGuy) throws RemoteException {
      System.out.println("Request from a guy: " + aGuy.getName());
      return "Bonjour " + aGuy.getName();
    }
}
