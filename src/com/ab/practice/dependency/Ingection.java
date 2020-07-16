package com.ab.practice.dependency;

public class Ingection {

	public static void main(String[] args) {
		// call the bean class and  ingect cat and dog
		
		// making dog class object and call;
				Dog d = new Dog();
				d.makeSound();
		// making cat class object and call;
				Cat c = new Cat();
				c.makeSound();
				
		//use dependency injection concept and call new cat and dog;
		Bean b = new Bean(d); //change to c:: to see the effects
		b.getAnimal();
		

	}

}
