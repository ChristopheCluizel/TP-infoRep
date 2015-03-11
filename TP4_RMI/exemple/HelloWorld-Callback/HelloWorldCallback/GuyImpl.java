package HelloWorldCallback;

import java.rmi.RemoteException;

public class GuyImpl implements Guy {
   private String name;
   public GuyImpl(String name) {
      this.name = name;
   }
   public String getName() throws RemoteException {
      return this.name;
   }
   public void setName(String name) throws RemoteException {
      this.name = name;
   }
}
