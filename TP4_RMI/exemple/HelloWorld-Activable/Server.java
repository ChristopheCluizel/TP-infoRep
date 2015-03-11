import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.activation.*;
import java.util.Properties;

public class Server{
  public static void main(String args[]) throws Exception{
    int port  = 1099;
    if(args.length==1)
      port = Integer.parseInt(args[0]);
    try{
      System.setSecurityManager(new RMISecurityManager());
      Properties env = new Properties();
      env.put("java.security.policy","file://home/paucheta/Enseignements/InfoRep/Cours/05&06-RMI/Exemples/HelloWorld-Activable/helloworld.policy");
      ActivationGroupDesc mygroupdes = new ActivationGroupDesc(env, null);
      ActivationGroupID mygroupid = ActivationGroup.getSystem().registerGroup(mygroupdes);
      ActivationGroup.createGroup(mygroupid, mygroupdes, 0);
      ActivationDesc objectdesc = new ActivationDesc("HelloImpl","file://home/paucheta/Enseignements/InfoRep/Cours/05&06-RMI/Exemples/HelloWorld-Activable", null);
      Hello myobject = (Hello)Activatable.register(objectdesc);
      Registry registry = LocateRegistry.getRegistry(port);
      registry.rebind("HelloActivatable", myobject);
      System.out.println("HelloActivatable active et lie au registre");
    }catch(Exception e){
      System.out.println("Exception "+ e);
    }
  }
}
