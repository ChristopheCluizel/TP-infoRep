import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import calculatrice.*;

public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length == 1)
        port = Integer.parseInt(args[0]);
    try {
        Calculatrice stub = (Calculatrice)UnicastRemoteObject.exportObject(new CalculatriceImpl(), 0);
        Registry registry = LocateRegistry.getRegistry(port);

        if(!Arrays.asList(registry.list()).contains("Calculatrice"))
            registry.bind("Calculatrice", stub);
        else
            registry.rebind("Calculatrice", stub);
        System.out.println("Service Calculatrice lié au registre");

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
