import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
    if(args.length==3) {
      machine = args[0];
      port = Integer.parseInt(args[1]);
    } else if(args.length==2)
      machine = args[0];
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Hello obj = (Hello) registry.lookup("HelloActivatable");
      System.out.println(obj.sayHello(args[args.length-1]));
    } catch (Exception e) {
	System.out.println("Client exception: " +e);
    }
  }
}

