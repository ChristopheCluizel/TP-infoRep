import java.rmi.Remote;
import java.rmi.RemoteException;

public class HelloImpl implements Hello {
   public Msg getMsg() {
      return (Msg)new MsgImpl();
   }
}

