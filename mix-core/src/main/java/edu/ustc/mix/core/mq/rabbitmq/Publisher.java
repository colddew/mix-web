package edu.ustc.mix.core.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Publisher {
	
	private static final String EXCHANGE_NAME = "persist";	// 定义Exchange名称
	private static final boolean durable = true;			// 消息队列持久化
	
	public static void main(String[] args) throws Exception {
		
		// 创建链接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		// 创建链接
		Connection connection = factory.newConnection();
		
		// 创建信息通道
		Channel channel = connection.createChannel();
		
		// 创建Exchange并声明持久化
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout", durable);
		
		String message = "Hello Wrold " + Math.random();
		
		// 消息的持久化
		channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		
		System.out.println("[x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}