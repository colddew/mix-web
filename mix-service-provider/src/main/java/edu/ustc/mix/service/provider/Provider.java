package edu.ustc.mix.service.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"applicationContext-dubbo.xml"});
		context.start();
		
		// 按任意键退出
		System.in.read();
	}

}