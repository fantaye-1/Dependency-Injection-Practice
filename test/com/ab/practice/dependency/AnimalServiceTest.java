package com.ab.practice.dependency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnimalServiceTest {

	@Test
	void usesTheAnimalInjectedThroughTheConstructor() {
		assertEquals("Dog says Woof", new AnimalService(new Dog()).speak());
		assertEquals("Cat says Meow", new AnimalService(new Cat()).speak());
	}

	@Test
	void setterInjectionSwapsTheDependency() {
		AnimalService service = new AnimalService(new Dog());
		Cat cat = new Cat();

		service.setAnimal(cat);

		assertSame(cat, service.getAnimal());
		assertEquals("Cat says Meow", service.speak());
	}

	@Test
	void acceptsAnyImplementationIncludingATestDouble() {
		// the point of DI: the service can be tested with a stand-in
		Animal fake = () -> "test-sound";
		assertEquals("test-sound", new AnimalService(fake).getAnimal().sound());
		assertEquals(fake.getClass().getSimpleName() + " says test-sound", new AnimalService(fake).speak());
	}

	@Test
	void rejectsMissingDependency() {
		assertThrows(NullPointerException.class, () -> new AnimalService(null));
		AnimalService service = new AnimalService(new Dog());
		assertThrows(NullPointerException.class, () -> service.setAnimal(null));
	}
}
