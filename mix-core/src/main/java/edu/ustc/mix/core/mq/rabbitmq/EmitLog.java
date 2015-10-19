package edu.ustc.mix.core.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {
	
	private static final String EXCHANGE_NAME = "logs";
	
	public static void main(String[] args) throws Exception {
		
		// 创建链接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		// 创建链接
		Connection connection = factory.newConnection();
		
		// 创建信息管道
		Channel channel = connection.createChannel();
		
		// 声明Exchange非持久化
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		String message = "Message " + Math.random();
		
		// 第一个参数是对应的Exchange名称,如果为空则使用默认Exchange
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
		
		System.out.println("[x] Sent '" + message + "'");
		
		// 关闭链接
		channel.close();
		connection.close();
	}
}