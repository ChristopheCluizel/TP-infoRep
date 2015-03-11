package CalculatriceRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;
import CalculatriceRMI.NombreNegatif;

public interface Calculatrice extends Remote, Serializable {   
  public int addition(int a, int b) throws RemoteException, NombreNegatif;
  public int soustraction(int a, int b) throws RemoteException, NombreNegatif;
  public int multiplication(int a, int b) throws RemoteException, NombreNegatif;
  public int division(int a, int b) throws RemoteException, NombreNegatif;
}
