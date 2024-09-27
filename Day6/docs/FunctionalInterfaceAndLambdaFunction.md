### Functional Programming in Java

**Functional Programming** is a programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing state or mutable data. It promotes writing code in a declarative manner by focusing on the "what" (logic) instead of the "how" (implementation details). Functional programming relies heavily on functions as first-class citizens, meaning functions can be passed as parameters, returned from other functions, or assigned to variables.

In Java, **functional programming** is supported through the use of functional interfaces and lambda expressions starting from Java 8.

---

### Functional Interfaces

A **functional interface** in Java is an `interface that contains exactly one abstract method.` These interfaces are the foundation for functional programming in Java, as they represent the target types for lambda expressions.

- **Definition**: A functional interface can be defined using the `@FunctionalInterface` annotation, though this is optional. This annotation ensures that the interface cannot have more than one abstract method.

**Example of a Functional Interface:**

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);  // Single abstract method
}
```

---

### Lambda Expressions

**Lambda expressions** provide a way to create anonymous methods (functions) that can be treated as instances of functional interfaces. They allow more concise syntax for implementing interfaces with a single method.

**Syntax of Lambda Expression**:

```java
(parameters) -> expression
```

or

```java
(parameters) -> { block of code }
```

**Example**:

Let's implement the `Calculator` functional interface using a lambda expression.

```java
Calculator addFunction = (a, b) -> a + b;

int result = addFunction.add(5, 10);  // result = 15
```

---

### Built-in Functional Interfaces

Java provides several built-in functional interfaces in the `java.util.function` package, such as:

- **Predicate<T>**: Represents a function that takes a single argument and returns a boolean (`boolean test(T t)`).
- **Function<T, R>**: Represents a function that takes one argument and produces a result (`R apply(T t)`).
- **Consumer<T>**: Represents a function that takes one argument and returns nothing (`void accept(T t)`).
- **Supplier<T>**: Represents a function that takes no arguments and returns a result (`T get()`).

**Example using a Predicate**:

```java
Predicate<Integer> isPositive = (n) -> n > 0;

System.out.println(isPositive.test(5));   // Output: true
System.out.println(isPositive.test(-3));  // Output: false
```

---

### Method References

Java also allows **method references**, which provide a shorthand way to refer to methods or constructors using the `::` operator.

**Example**:

```java
Consumer<String> printFunction = System.out::println;
printFunction.accept("Hello, world!");  // Output: Hello, world!
```

---

### Conclusion

- **Functional interfaces** enable functional programming in Java by providing a way to define single-method contracts.
- **Lambda expressions** provide a concise way to implement functional interfaces, enabling more readable and flexible code.
- **Method references** offer further syntactic sugar for referring to methods in a clean, simple way.
 