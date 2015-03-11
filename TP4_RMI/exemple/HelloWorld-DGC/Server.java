import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Server {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length==1)
      port = Integer.parseInt(args[0]);
    try {
      Hello stub = (Hello)UnicastRemoteObject.exportObject(new HelloImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      if(!Arrays.asList(registry.list()).contains("HelloDGC"))
        registry.bind("HelloDGC", stub);
      else
        registry.rebind("HelloDGC", stub);
      System.out.println("Service HelloDGC lie au registre");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
