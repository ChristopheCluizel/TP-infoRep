package calculatriceComplexe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface Calculatrice extends Remote, Serializable {
	public Complexe addition(Complexe a, Complexe b) throws RemoteException;
	public Complexe soustraction(Complexe a, Complexe b) throws RemoteException;
	public Complexe multiplication(Complexe a, Complexe b) throws RemoteException;
	public Complexe division(Complexe a, Complexe b) throws RemoteException;
}

