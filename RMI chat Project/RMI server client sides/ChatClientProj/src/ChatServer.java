import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface
{
	String message="";
	public ChatServer() throws RemoteException
	{
	}
	public String getMessage() throws RemoteException
	{
		return message;
	}
	public void setMessage(String msg) throws RemoteException
	{
		message=msg;
	}
}

