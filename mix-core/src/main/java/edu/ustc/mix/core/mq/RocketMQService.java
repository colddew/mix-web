package edu.ustc.mix.core.mq;

import static com.alibaba.rocketmq.common.consumer.ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

import edu.ustc.mix.persistence.entity.system.User;

@Service
public class RocketMQService {
	
	private Logger logger = LoggerFactory.getLogger(RocketMQService.class);
	
	private static final String PRODUCER_GROUP = "PRODUCER_GROUP";
	private static final String CONSUMER_GROUP = "CONSUMER_GROUP";
	private static final String NAME_SERVER_ADDRESS = "192.168.199.201:9876";
	private static final String TOPIC = "ROCKET";
	private static final String TAG = "MIX";
	
	private DefaultMQProducer producer;
	private DefaultMQPushConsumer consumer;
	
	@PostConstruct
	public void init() throws Exception {
		startProducer();
		startConsumer();
	}

	@PreDestroy
	public void destory() {
		producer.shutdown();
		consumer.shutdown();
	}

	private void startProducer() throws Exception {
		
		producer = new DefaultMQProducer(PRODUCER_GROUP);
		producer.setNamesrvAddr(NAME_SERVER_ADDRESS);
		
		producer.start();
	}
	
	private void startConsumer() throws Exception {
		
		consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
		consumer.setNamesrvAddr(NAME_SERVER_ADDRESS);
		consumer.subscribe(TOPIC, TAG);
		consumer.setConsumeFromWhere(CONSUME_FROM_FIRST_OFFSET);
		
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				Message message = msgs.get(0);
				return consumeMixMessage(message);
			}
		});
		
		consumer.start();
	}
	
	private ConsumeConcurrentlyStatus consumeMixMessage(Message message) {
		
		logger.info("consume mix message, {}", new String(message.getBody()));
		
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}
	
	public boolean sendMixMessage(User user) {
		
		Message message = new Message(TOPIC, TAG, user.getUserId().toString(), JSON.toJSONString(user).getBytes());
		
		try {
			SendResult sendResult = producer.send(message);
			if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
				logger.info("send mix message successfully");
				return true;
			} else {
				logger.info("send mix message unsuccessfully");
				return false;
			}
		} catch (Exception e) {
			logger.info("send mix message unsuccessfully, {}", e.getMessage());
			return false;
		}
	}
}
