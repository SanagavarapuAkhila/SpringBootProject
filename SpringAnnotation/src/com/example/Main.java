package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String args[]) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld h=ctx.getBean(HelloWorld.class);
		h.setMsg("Welcome to Spring");
		System.out.println(h.getMsg());
	}

}
