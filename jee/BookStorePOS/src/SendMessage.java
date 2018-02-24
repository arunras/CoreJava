import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class SendMessage {

	public static void main(String[] args) {
		
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		jndiProperties.put("jboss.naming.client.ejb.context","true");
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		
		Connection connection = null;
		
		try {
			Context ctx = new InitialContext(jndiProperties);
			Queue queue = (Queue)ctx.lookup("jms/BookStoreQueue");
			ConnectionFactory cf = (ConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");
			connection = cf.createConnection();
			
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);

      Random random = new Random();
		  for (int i = 0; i < 20; i++) {	
        int priority = random.nextInt(9);
        MapMessage message = session.createMapMessage();
        message.setInt("sku", 10296);
        message.setString("title", "Mastering Messaging with priority " + priority);
        message.setDouble("price", 10.99);
        message.setLong("date", new Date().getTime());
        
        messageProducer.send(message, DeliveryMode.PERSISTENT, priority, 10_000);
      }
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (JMSException e) {
				
			}
		}

	}

}
