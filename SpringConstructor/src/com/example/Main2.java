package com.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main2 {
public static void main(String[] args) {
ApplicationContext ctx=new AnnotationConfigApplicationContext(CatConfig.class);
Cat c1=(Cat)ctx.getBean("c1");
System.out.println("Cat has "+c1.getLegs()+" legs");
Cat c2=(Cat)ctx.getBean("c2");
System.out.println("Cat name is "+c2.getName());
Cat c3=(Cat)ctx.getBean("c3");
System.out.println("Legs "+c3.getLegs()+" Name "+c3.getName());
}
}

