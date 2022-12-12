import java.rmi.RemoteException;

public class Server implements Calculator {
    public int multiply(int x, int y) throws RemoteException
    {
        return x * y;
    }
}
