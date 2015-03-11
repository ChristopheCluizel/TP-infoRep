package HelloWorldSerializable;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
   public String sayHello(Guy aGuy) throws RemoteException;
}
