import HelloWorld.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class HelloServer {
  public static void main(String args[]) {
    try {
      String orbArguments[]=new String[0];
      ORB orb=ORB.init(orbArguments,null);
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
      HelloServant helloServant=new HelloServant();
      Hello corbaHelloObject = HelloHelper.narrow(rootpoa.servant_to_reference(helloServant));
      System.out.println(orb.object_to_string(corbaHelloObject));
      orb.run();
    }
    catch (Exception e) {
      System.err.println("Error : "+e);
    }
  }
}

