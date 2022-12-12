import org.apache.xmlrpc.*;

public class Server {
    static int port = 8080;

    public Integer sum(int x, int y)
    {
        return x + y;
    }

    public static void main(String[] args) {
        System.out.println("Сервер запускается...");

        WebServer webServer = new WebServer(port);
        webServer.addHandler("sumRPC", new Server());
        webServer.start();

        System.out.println("Сервер запущен");
    }
}
