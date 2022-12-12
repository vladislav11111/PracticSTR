import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;

public class Provider {

    public static ConnectionFactory getConnectionFactory () {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
        return connectionFactory;
    }
}