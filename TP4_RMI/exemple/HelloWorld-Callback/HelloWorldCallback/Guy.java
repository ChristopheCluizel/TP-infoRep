package HelloWorldCallback;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface Guy extends Remote, Serializable {
   public String getName() throws RemoteException;
   public void setName(String name) throws RemoteException;
}
