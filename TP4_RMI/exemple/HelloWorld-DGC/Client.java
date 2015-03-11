import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
    if(args.length==3) {
      machine = args[0];
      port = Integer.parseInt(args[1]);
    } else if(args.length==2)
      machine = args[0];
    Msg msg = null;
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Hello obj = (Hello)registry.lookup("HelloDGC");
      for(int i = 0; i < 100; i++) {
	msg = obj.getMsg();
	System.out.println(msg);
	msg = null;
      }
    } catch (Exception e) {
	System.out.println("Client exception: " +e);
    }
  }
}

