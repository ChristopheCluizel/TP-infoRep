import java.rmi.Remote;
import java.rmi.RemoteException;

public class MsgImpl implements Msg {
   private static int counter;
   private int id;

   public MsgImpl() {
      super();
      this.id = ++MsgImpl.counter;
      System.out.println("Message created:" + MsgImpl.counter);
   }

   public void unreferenced(){ System.out.println("Methode unreferenced() called by " + this.id ); }

   public void finalize(){ System.out.println("Methode finalize() called by " + this.id ); }
}
