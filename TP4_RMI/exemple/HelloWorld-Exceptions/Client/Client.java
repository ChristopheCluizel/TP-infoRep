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
      Hello obj = (Hello)registry.lookup("HelloExceptions");
      if(args[args.length-1].equals("division"))
        obj.divisionParZero();
      else if(args[args.length-1].equals("vide"))
        System.out.println(obj.sayHello(""));
      else
        System.out.println(obj.sayHello(args[args.length-1]));
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
