package HelloWorldRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface Hello extends Remote, Serializable {   
  public String sayHello(String nom) throws RemoteException, ChaineVide;
  public void divisionParZero() throws RemoteException;
}
