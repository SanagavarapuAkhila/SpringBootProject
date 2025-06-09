package com.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
public static void main(String[] args) {
ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
Cat c1=(Cat)ctx.getBean("c1");
System.out.println("Cat has "+c1.getLegs()+" legs");
Cat c2=(Cat)ctx.getBean("c2");
System.out.println("Cat name is "+c2.getName());
Cat c3=(Cat)ctx.getBean("c3");
System.out.println(" legs "+c3.getLegs()+" name "+c3.getName());
}
}

