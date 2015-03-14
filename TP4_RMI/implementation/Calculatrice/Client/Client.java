import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import CalculatriceRMI.Calculatrice;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Calculatrice obj = (Calculatrice)registry.lookup("CalculatriceExceptions");
      if(args[2].contains("+"))
		System.out.println(obj.addition(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
      if(args[1].contains("-"))
		System.out.println(obj.soustraction(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
      if(args[1].contains("x"))
		System.out.println(obj.multiplication(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
      if(args[1].contains("/"))
		System.out.println(obj.division(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
      
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
