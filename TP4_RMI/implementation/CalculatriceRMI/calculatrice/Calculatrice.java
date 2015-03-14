package calculatrice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface Calculatrice extends Remote, Serializable {
  public int addition(int nb1, int nb2) throws RemoteException, NombreNegatif;
  public int soustraction(int nb1, int nb2) throws RemoteException, NombreNegatif;
  public int multiplication(int nb1, int nb2) throws RemoteException, NombreNegatif;
  public int division(int nb1, int nb2) throws RemoteException, NombreNegatif;
}
