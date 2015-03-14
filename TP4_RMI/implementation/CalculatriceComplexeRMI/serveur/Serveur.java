import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import calculatriceComplexe.*;

public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;

    if(args.length==1)
        port = Integer.parseInt(args[0]);

    try {
        Calculatrice stub = (Calculatrice)UnicastRemoteObject.exportObject(new CalculatriceImpl(), 0);
        Registry registry = LocateRegistry.getRegistry(port);

        if(!Arrays.asList(registry.list()).contains("CalculatriceComplexe"))
            registry.bind("CalculatriceComplexe", stub);
        else
            registry.rebind("CalculatriceComplexe", stub);
        System.out.println("Service CalculatriceComplexe lie au registre");

    } catch (Exception e) {
        System.out.println(e);
    }
  }
}
