import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class StartServer
{
	public static void main(String[] ar)
	{
			try{
					Registry r=LocateRegistry.createRegistry(1099);
					ChatServer ch=new ChatServer();
					r.bind("CHAT",ch);
					System.out.println("Ready");
			}catch(Exception ee){}
	}
}

