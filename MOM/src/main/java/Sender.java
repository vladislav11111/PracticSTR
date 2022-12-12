import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {

    private final MessageProducer producer;
    private final Session session;
    private final QueueConnection con;

    public Sender() throws JMSException, NamingException {
        InitialContext context = new InitialContext();
        QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup ("queue/connectionFactory");
        con = factory.createQueueConnection();
        QueueSession session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        this.session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("example.queue");
        this.producer = session.createProducer(queue);
    }

    public void sendMessage (String message) throws JMSException {
        System.out.printf("Отправка сообщения: " + message);
        TextMessage textMessage = session.createTextMessage(message);
        producer.send(textMessage);
    }

    public void destroy () throws JMSException {
        con.close();
    }
}