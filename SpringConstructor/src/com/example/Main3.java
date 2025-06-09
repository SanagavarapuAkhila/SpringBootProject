package com.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main3 {
public static void main(String[] args) {
ApplicationContext ctx=new ClassPathXmlApplicationContext("beans2.xml");
Tiger t=(Tiger)ctx.getBean("t");
System.out.println(t.getEat());
System.out.println(t.getRun());
}
}