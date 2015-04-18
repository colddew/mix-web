package edu.ustc.mix.front.action.openapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.UserSellerGetResponse;

@Component
public class TopAPI {
	
	@Value("${top.sandbox.serverUrl}")
	private String serverUrl;
	
	@Value("${top.sandbox.appkey}")
	private String appkey;
	
	@Value("${top.sandbox.appSecret}")
	private String appSecret;
	
	@Value("${top.sandbox.sessionkey}")
	private String sessionkey;
	
	public void getSellerInfo() {
		
		// 实例化TopClient类
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appkey, appSecret);
		
		// 实例化具体API对应的Request类
		UserSellerGetRequest req = new UserSellerGetRequest();
		
		req.setFields("nick, user_id, type");
		// req.setNick("sandbox_c_1");
		
		// 执行API请求并打印结果
		UserSellerGetResponse response;
		try {
			response = client.execute(req, sessionkey);
			System.out.println("result: " + response.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.start();
		
		TopAPI topAPI = (TopAPI) ctx.getBean("topAPI");
		topAPI.getSellerInfo();
		
		ctx.close();
	}
}