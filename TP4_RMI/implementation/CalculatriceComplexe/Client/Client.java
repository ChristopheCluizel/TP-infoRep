import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import CalculatriceRMI.Calculatrice;
import CalculatriceRMI.Complex;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Calculatrice obj = (Calculatrice)registry.lookup("CalculatriceExceptions");
		Complex a = new Complex(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		Complex b = new Complex(Integer.parseInt(args[3]),Integer.parseInt(args[4]));
		if(args[2].contains("+"))
			System.out.println(obj.addition(a,b));
		if(args[2].contains("-"))
			System.out.println(obj.soustraction(a,b));
		if(args[2].contains("x"))
			System.out.println(obj.multiplication(a,b));
		if(args[2].contains("/"))
			System.out.println(obj.division(a,b));
      
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
