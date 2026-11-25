package com.ab.practice.dependency;

import java.util.Objects;

/**
 * Depends only on the {@link Animal} interface, never on {@code Dog} or
 * {@code Cat}. The caller decides which implementation to inject.
 * <ul>
 *   <li>Constructor injection supplies the required dependency.</li>
 *   <li>Setter injection lets the dependency be swapped later.</li>
 * </ul>
 */
public class AnimalService {

	private Animal animal;

	public AnimalService(Animal animal) {
		this.animal = Objects.requireNonNull(animal, "animal must not be null");
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = Objects.requireNonNull(animal, "animal must not be null");
	}

	/** Describes the injected animal's sound, e.g. "Dog says Woof". */
	public String speak() {
		return animal.getClass().getSimpleName() + " says " + animal.sound();
	}
}
