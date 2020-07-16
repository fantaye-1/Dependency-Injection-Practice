package com.ab.practice.dependency;

public class Bean {
	
	private Animal a;
	
	Bean(Animal animal){
		this.a = animal;
	}	

	public void getAnimal() {
		 a.makeSound();
	}

	public void setAnimal(Animal animal) {
		this.a = animal;
	}
	
}
