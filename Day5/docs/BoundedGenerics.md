In Java, **bounded generics** and **bounded types** are related concepts that help restrict the types that can be used with generic classes or methods. They allow us to define constraints on the generic types to ensure type safety and limit the types that a generic can accept.

### 1. **Bounded Generics**:
Bounded generics allow you to place restrictions on the types that can be used as arguments for a generic class or method. There are two main types of bounds in generics: **upper bounds** and **lower bounds**.

#### **Upper Bounded Generics (`extends`)**:
This allows you to specify that a generic type must be a subclass of a specific type (or implement a specific interface). You use the `extends` keyword for upper bounds.

- **Syntax:**
  ```java
  <T extends SuperClass>
  ```

- **Example:**
  ```java
  class Box<T extends Number> { // T can be any subclass of Number (e.g., Integer, Double)
      private T value;

      public Box(T value) {
          this.value = value;
      }

      public T getValue() {
          return value;
      }
  }

  public class Main {
      public static void main(String[] args) {
          Box<Integer> intBox = new Box<>(123);   // Valid: Integer extends Number
          Box<Double> doubleBox = new Box<>(123.45); // Valid: Double extends Number
          // Box<String> stringBox = new Box<>("text"); // Invalid: String does not extend Number
      }
  }
  ```

In this example, the generic type `T` is restricted to types that extend `Number` (like `Integer`, `Double`), so you cannot use types like `String`.

#### **Lower Bounded Generics (`super`)**:
This allows you to specify that a generic type must be a superclass of a specific type. You use the `super` keyword for lower bounds.

- **Syntax:**
  ```java
  <T super SubClass>
  ```

- **Example:**
  ```java
  public static void addNumber(List<? super Integer> list) {
      list.add(10); // Valid to add Integer or its subclass
  }

  public class Main {
      public static void main(String[] args) {
          List<Number> numList = new ArrayList<>();
          addNumber(numList); // Valid: Integer is a subclass of Number
      }
  }
  ```

In this example, the `list` accepts `Integer` or any of its superclasses, such as `Number` or `Object`.

### 2. **Bounded Types**:
Bounded types refer to the actual types that can be used with generics when a bound (upper or lower) is specified. Essentially, bounded types are the specific types that fit the generic constraint defined by the bounds.

- **Upper bounded types**: When you use upper bounds, the types that can be used must extend the specified type.
  - Example: For `<T extends Number>`, valid types are `Integer`, `Double`, `Long`, etc.
  
- **Lower bounded types**: When you use lower bounds, the types that can be used must be a superclass of the specified type.
  - Example: For `<? super Integer>`, valid types are `Number` and `Object`.

### **Difference Between Bounded Generics and Bounded Types**:

| Concept            | Bounded Generics                                   | Bounded Types                                      |
|--------------------|---------------------------------------------------|---------------------------------------------------|
| Definition         | Refers to generics that restrict the types that can be used by using `extends` or `super` bounds. | Refers to the specific types that meet the constraints defined by the bounded generics. |
| Keywords           | Uses `extends` (upper bound) and `super` (lower bound) to define constraints. | Represents the actual types that fit within the defined bounds (e.g., `Integer`, `Double` for `T extends Number`). |
| Purpose            | Used to enforce certain type constraints on generics for type safety. | Represents the concrete types that satisfy the constraints of the bounded generics. |
| Example (Upper)    | `Box<T extends Number>` limits T to types like `Integer`, `Double`, etc. | `Integer`, `Double`, `Long` are valid bounded types for `T extends Number`. |
| Example (Lower)    | `<? super Integer>` allows types that are superclasses of `Integer` like `Number`, `Object`. | `Number`, `Object` are valid types for `<? super Integer>`. |

### **Examples:**
#### Upper Bounded Generic:
```java
class Example<T extends Number> { 
    T value;
    public Example(T value) {
        this.value = value;
    }

    public double getDoubleValue() {
        return value.doubleValue();
    }
}
```
- Here, `T` can only be `Number` or its subclasses like `Integer`, `Double`, etc.

#### Lower Bounded Generic:
```java
public static void addElements(List<? super Integer> list) {
    list.add(10); // Only Integer or its subclass can be added
}
```
- Here, `list` can accept `Integer` or any of its superclasses (`Number`, `Object`).

### **Wildcard Bounds (`? extends` and `? super`)**:
In addition to bounded generics in classes or methods, you can also use wildcard bounds to limit the types that a collection can accept. The two main wildcard bounds are:

- **`? extends Type`**: Restricts the type to `Type` or its subclasses.
  - Example: `List<? extends Number>` can accept `List<Integer>`, `List<Double>`, etc.
  
- **`? super Type`**: Restricts the type to `Type` or its superclasses.
  - Example: `List<? super Integer>` can accept `List<Number>`, `List<Object>`, etc.
