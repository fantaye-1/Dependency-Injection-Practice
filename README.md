# Dependency-Injection-Practice

A minimal, framework-free example of **dependency injection** in Java.

`AnimalService` depends only on the `Animal` interface. It never creates a
`Dog` or a `Cat` itself; whoever builds the service decides which one to
inject. That keeps the service decoupled from concrete classes and easy to
test with a stand-in.

| Class | Role |
|---|---|
| `Animal` | The dependency's interface (`String sound()`) |
| `Dog`, `Cat` | Two implementations |
| `AnimalService` | The consumer. Gets its `Animal` by **constructor injection** (required, null-checked) and can swap it by **setter injection** |
| `InjectionDemo` | `main`: wires the objects by hand and shows the swap |

Spring, Guice and Jakarta CDI automate this same wiring; this project shows
the idea without a framework.

## Requirements

- Java 17+
- Maven 3.8+

## Build and test

```bash
mvn verify
```

JUnit 5 tests in `test/` cover constructor injection, setter injection,
injecting a test double, and rejecting a missing dependency. GitHub Actions
runs the same build on every push and pull request.

## Run

```bash
mvn -q compile
java -cp target/classes com.ab.practice.dependency.InjectionDemo
```

Output:

```
Dog says Woof
Cat says Meow
```
