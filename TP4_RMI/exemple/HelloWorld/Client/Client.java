import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import HelloWorldRMI.Hello;

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
      Hello obj = (Hello)registry.lookup("Hello");
      String message = obj.sayHello(args[args.length-1]);
      System.out.println(message);
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
