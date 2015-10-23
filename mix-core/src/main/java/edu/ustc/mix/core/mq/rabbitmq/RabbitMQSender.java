package edu.ustc.mix.core.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQSender {
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws Exception {
		
		ConnectionFactory factory = new ConnectionFactory();
//		setRemoteConnectionFactory(factory);
		setLocalConnectionFactory(factory);
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		
		System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
	
	public static void setLocalConnectionFactory(ConnectionFactory factory) {
		factory.setHost("localhost");
	}
	
	public static void setRemoteConnectionFactory(ConnectionFactory factory) {
		factory.setHost("10.0.40.151");
		factory.setPort(5672);
		factory.setUsername("gatewayservice");
		factory.setPassword("pass");
		factory.setVirtualHost("/contact");
	}
}
