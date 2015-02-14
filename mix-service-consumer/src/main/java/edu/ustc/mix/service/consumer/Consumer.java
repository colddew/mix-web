package edu.ustc.mix.service.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ustc.mix.service.DubboAnnotationService;
import edu.ustc.mix.service.DubboService;

public class Consumer {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"applicationContext-dubbo.xml"});
		context.start();
		
		// 获取远程服务代理
		DubboService dubboService = (DubboService) context.getBean("dubboService");
		// 执行远程方法
		String service = dubboService.invoke("dubbo");
		System.out.println("dubbo consumer invoke, " + service);
		
		DubboAnnotationService dubboAnnotationService = (DubboAnnotationService) context.getBean("dubboAnnotationService");
		String annotationService = dubboAnnotationService.invoke("dubbo annotation");
		System.out.println("dubbo consumer invoke, " + annotationService);
		
		// 按任意键退出
		System.in.read();
	}
}