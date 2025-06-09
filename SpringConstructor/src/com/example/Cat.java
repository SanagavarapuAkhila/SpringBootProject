package com.example;
public class Cat {
private int legs;
private String name;
public Cat(int legs) {
this.legs = legs;

}

public Cat(String name) {
this.name = name;
}



public Cat(int legs, String name) {
this.legs = legs;
this.name = name;
}

public int getLegs() {
return legs;
}

public String getName() {
return name;
}
}

