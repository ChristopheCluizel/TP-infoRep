import java.rmi.Remote;
import java.io.Serializable;
import java.rmi.server.Unreferenced;

public interface Msg extends Remote, Unreferenced, Serializable { }
