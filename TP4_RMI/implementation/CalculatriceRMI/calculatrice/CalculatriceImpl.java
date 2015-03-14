package calculatrice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class CalculatriceImpl implements Calculatrice, Remote {
	public int addition(int nb1, int nb2) throws RemoteException, NombreNegatif {
		if(nb1 < 0 || nb2 < 0)
			throw new NombreNegatif();
		return nb1 + nb2;
	}
	public int soustraction(int nb1, int nb2) throws RemoteException, NombreNegatif {
		if(nb1 < 0 || nb2 < 0 || (nb1 - nb2) < 0)
			throw new NombreNegatif();
		return nb1 - nb2;
	}
	public int multiplication(int nb1, int nb2) throws RemoteException, NombreNegatif {
		if(nb1 < 0 || nb2 < 0)
			throw new NombreNegatif();
		return nb1 * nb2;
	}
	public int division(int nb1, int nb2) throws RemoteException, NombreNegatif {
		if(nb1 < 0 || nb2 < 0)
			throw new NombreNegatif();
		return nb1 / nb2;
	}
}
