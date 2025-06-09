package com.example;
import org.springframework.context.annotation.Bean;
public class HelloWorldConfig {
	@Bean
	public HelloWorld meth1()
	{
		return new HelloWorld();
	}

}
