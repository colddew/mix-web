package edu.ustc.mix.core.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class RabbitMQReceiver {
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws Exception {
		
		ConnectionFactory factory = new ConnectionFactory();
//		setRemoteConnectionFactory(factory);
		setLocalConnectionFactory(factory);
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);
		
		while (true) {
			Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
		}
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
