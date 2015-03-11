import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import HelloWorldSerializable.*;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
    Guy aGuy = new Guy(args[args.length-1]);
    if(args.length==3) {
      machine = args[0];
      port = Integer.parseInt(args[1]);
    } else if(args.length==2)
      machine = args[0];
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Hello obj = (Hello)registry.lookup("HelloSerializable");
      System.out.println(obj.sayHello(aGuy));
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
