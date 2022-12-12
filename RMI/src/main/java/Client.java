import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        final Registry registry = LocateRegistry.getRegistry(8080);
        int x = 20;
        int y = 30;

        Calculator calculator = (Calculator) registry.lookup("server.calculator");
        int res = calculator.multiply(x, y);

        System.out.println("Произведение " + x + " * " + y + " = " + res);
    }
}
