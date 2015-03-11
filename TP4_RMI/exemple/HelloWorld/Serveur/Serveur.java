import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import HelloWorldRMI.*;

public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length==1)
      port = Integer.parseInt(args[0]);
    try {
      Hello stub = (Hello)UnicastRemoteObject.exportObject(new HelloImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      if(!Arrays.asList(registry.list()).contains("Hello"))
        registry.bind("Hello", stub);
      else
        registry.rebind("Hello", stub);
      System.out.println("Service Hello lie au registre");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
