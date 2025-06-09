package com.example;
import org.springframework.context.annotation.Bean;
public class CatConfig {
@Bean(name = "c1")
public Cat meth1()
{
return new Cat(4);
}
@Bean(name="c2")
public Cat meth2()
{
return new Cat("Tom");
}
@Bean(name="c3")
public Cat meth3()
{
return new Cat(4,"Kitty");
}
}

