import java.io.IOException;
import java.util.*;
import org.apache.xmlrpc.*;

public class Client {
    public static void main(String[] args) throws IOException, XmlRpcException {
        String server = "http://localhost:8080/RPC2";
        XmlRpcClient client = new XmlRpcClient(server);

        Vector nums = new Vector();
        nums.addElement(new Integer(17));
        nums.addElement(new Integer(2));

        Object result = client.execute("sumRPC.sum", nums);

        int sum = ((Integer) result).intValue();
        System.out.println("Сумма: " + sum);
    }
}
