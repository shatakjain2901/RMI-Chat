import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;


public interface ChatClientInt extends Remote {
	public String getMessage() throws RemoteException;
	public void setMessage(String msg) throws RemoteException;
}
