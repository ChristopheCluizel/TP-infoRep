import java.rmi.*;
import java.rmi.activation.*;
import java.io.Serializable;

public class HelloImpl extends Activatable implements Hello,Serializable {
   public HelloImpl(ActivationID id, MarshalledObject data) throws RemoteException{
      super(id, 0);
   }
   public String sayHello(String nom) throws RemoteException{
      return "Hello "+nom;
   }
}
