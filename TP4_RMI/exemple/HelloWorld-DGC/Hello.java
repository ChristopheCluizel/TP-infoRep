import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface Hello extends Remote, Serializable {
   public Msg getMsg() throws RemoteException;
}

