import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException
    {
        final Server server = new Server();
        final Registry registry = LocateRegistry.createRegistry(8080);

        Remote obj = UnicastRemoteObject.exportObject(server, 0);
        registry.bind("server.calculator", obj);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
