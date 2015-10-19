package edu.ustc.mix.core.mq.rabbitmq;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class SubscriberThead implements Runnable {
	
	private String queue_name;
	private static final String EXCHANGE_NAME = "persist";	// 定义交换机名称
	private static final boolean durable = true;			// 消息队列持久化
	
	public SubscriberThead(String queue_name) {
		this.queue_name = queue_name;
	}
	
	@Override
	public void run() {
		
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout", durable);
			
			DeclareOk ok = channel.queueDeclare(queue_name, durable, false, false, null);
			String queueName = ok.getQueue();
			
			channel.queueBind(queueName, EXCHANGE_NAME, "");
			
			System.out.println(" [" + queue_name + "] Waiting for messages. To exit press CTRL+C");
			
			channel.basicQos(1);	// 消息分发处理
			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(queueName, false, consumer);
			
			while (true) {
				Thread.sleep(2000);
				Delivery delivery = consumer.nextDelivery();
				String message = new String(delivery.getBody());
				System.out.println(" [" + queue_name + "] Received '" + message + "'");
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}