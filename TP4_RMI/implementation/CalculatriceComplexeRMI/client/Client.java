import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import calculatriceComplexe.*;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;

    try {
		Registry registry = LocateRegistry.getRegistry(machine, port);
		Calculatrice obj = (Calculatrice)registry.lookup("CalculatriceComplexe");

		Complexe a = new Complexe(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		Complexe b = new Complexe(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
		String operateur = args[2];

		if(operateur.contains("+"))
			System.out.println(obj.addition(a, b));
		if(operateur.contains("-"))
			System.out.println(obj.soustraction(a, b));
		if(operateur.contains("x"))
			System.out.println(obj.multiplication(a, b));
		if(operateur.contains("/"))
			System.out.println(obj.division(a, b));

    } catch (Exception e) {
		System.out.println("Client exception: " + e);
    }
  }
}
