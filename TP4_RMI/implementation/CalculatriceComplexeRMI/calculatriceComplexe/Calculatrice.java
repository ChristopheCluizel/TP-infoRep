package CalculatriceRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;
import CalculatriceRMI.Complex;

public interface Calculatrice extends Remote, Serializable {   
  public Complex addition(Complex a, Complex b) throws RemoteException;
  public Complex soustraction(Complex a, Complex b) throws RemoteException;
  public Complex multiplication(Complex a, Complex b) throws RemoteException;
  public Complex division(Complex a, Complex b) throws RemoteException;
}

