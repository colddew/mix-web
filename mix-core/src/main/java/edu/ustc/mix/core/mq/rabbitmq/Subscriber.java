package edu.ustc.mix.core.mq.rabbitmq;

public class Subscriber {
	
	// private static final String[] QUEUE_NAMES = {"que_001","que_002","que_003","que_004","que_005"};
	private static final String[] QUEUE_NAMES = { "que_006", "que_007", "que_008", "que_009", "que_0010" };
	
	public static void main(String[] args) {
		for (int i = 0; i < QUEUE_NAMES.length; i++) {
			SubscriberThead sub = new SubscriberThead(QUEUE_NAMES[i]);
			Thread t = new Thread(sub);
			t.start();
		}
	}
}