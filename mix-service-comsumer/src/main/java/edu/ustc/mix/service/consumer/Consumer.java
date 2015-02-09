package edu.ustc.mix.service.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ustc.mix.service.DubboService;

public class Consumer {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"applicationContext-dubbo.xml"});
		context.start();
		
		DubboService dubboService = (DubboService) context.getBean("dubboService"); // 获取远程服务代理
		// 执行远程方法
		String service = dubboService.invoke("dubbo");
		// 显示调用结果
		System.out.println(service);
		
		// 按任意键退出
		System.in.read();
	}
}