import java.rmi.*;

public interface Hello extends Remote {
   public String sayHello(String name) throws RemoteException;
}
