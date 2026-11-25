package com.ab.practice.dependency;

/** Entry point: wires the dependencies by hand and shows how swapping them changes behavior. */
public class InjectionDemo {

	public static void main(String[] args) {
		// constructor injection: the service gets its Animal from outside
		AnimalService service = new AnimalService(new Dog());
		System.out.println(service.speak());

		// setter injection: swap the dependency without changing AnimalService
		service.setAnimal(new Cat());
		System.out.println(service.speak());
	}
}
