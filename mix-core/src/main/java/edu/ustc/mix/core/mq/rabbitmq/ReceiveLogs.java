package edu.ustc.mix.core.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveLogs {
	
	private static final String EXCHANGE_NAME = "logs";
	
	public static void main(String[] args) throws Exception {
		
		// 创建链接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		// 创建链接
		Connection connection = factory.newConnection();
		
		// 创建消息管道
		Channel channel = connection.createChannel();
		
		// 声明Exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		// 利用系统自动声明一个非持久化的消息队列，并返回唯一的队列名称
		String queueName = channel.queueDeclare().getQueue();
		
		// 将消息队列绑定到Exchange
		channel.queueBind(queueName, EXCHANGE_NAME, "");
		
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		
		// 声明一个消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, consumer);
		
		// 循环获取信息
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
		}
	}
}