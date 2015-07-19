package edu.ustc.mix.front.action.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ustc.mix.core.mq.RocketMQService;
import edu.ustc.mix.persistence.entity.system.User;

@Controller
@Scope("prototype")
public class MQAction {
	
	@Autowired
	private RocketMQService rocketMQService;
	
	@RequestMapping("/rocketmq")
	@ResponseBody
	public String rocketmq(long count) throws Exception {
		
		if(count > 0) {
			for (long i = 0; i < count; i++) {
				
				User user = new User();
				user.setUserId(i);
				user.setUserName(Long.toString(i));
				
				rocketMQService.sendMixMessage(user);
				
				Thread.sleep(1000 * 2);
			}
		}
		
		return "rocketmq";
	}
}
