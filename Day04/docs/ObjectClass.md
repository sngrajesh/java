### **The Object Class in Java**

The **`Object` class** is the root of the class hierarchy in Java. Every class in Java, either directly or indirectly, inherits from the `Object` class. This means that every Java class is a subclass of `Object` and inherits its methods. Even if a class does not explicitly extend another class, it automatically extends `Object`.

#### **Key Features of the `Object` Class**:
- The `Object` class defines the basic methods that are available to all Java objects.
- It provides fundamental methods like `equals()`, `hashCode()`, `toString()`, `clone()`, and others.
- Since `Object` is the top-level class, it plays a central role in Java’s inheritance structure.

### **Common Methods in the `Object` Class**

Here are some of the key methods provided by the `Object` class:

#### 1. **`equals(Object obj)`**
- This method checks if the current object is equal to another object. By default, it uses the memory address for comparison (i.e., checks if both references point to the same object), but it can be overridden for custom equality logic.
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;  // Same reference
    if (obj == null || getClass() != obj.getClass()) return false;
    // Custom equality logic (compare fields)
    return true;
}
```

#### 2. **`hashCode()`**
- This method returns an integer hash code that is used in hashing-based collections (e.g., `HashMap`, `HashSet`).
- If `equals()` is overridden, `hashCode()` must also be overridden to maintain consistency: if two objects are equal according to `equals()`, they must have the same hash code.
```java
@Override
public int hashCode() {
    return Objects.hash(field1, field2);  // Custom hash code generation
}
```

#### 3. **`toString()`**
- This method returns a string representation of the object. By default, it returns the class name followed by the hash code (in hexadecimal format), but it can be overridden to provide more meaningful information.
```java
@Override
public String toString() {
    return "ClassName{field1=" + field1 + ", field2=" + field2 + "}";
}
```

#### 4. **`clone()`**
- This method creates and returns a copy (or clone) of the current object. The class must implement the `Cloneable` interface for the `clone()` method to work properly, otherwise it throws a `CloneNotSupportedException`.
```java
@Override
protected Object clone() throws CloneNotSupportedException {
    return super.clone();  // Shallow copy
}
```

#### 5. **`finalize()`**
- This method is invoked by the garbage collector when it determines that there are no more references to the object. It is used for cleanup before the object is destroyed. However, it's deprecated in Java 9 and later due to unpredictable behavior.
```java
@Override
protected void finalize() throws Throwable {
    // Cleanup logic before garbage collection
    super.finalize();
}
```

#### 6. **`getClass()`**
- This method returns the runtime class of the object, which is an instance of the `Class` class. It is often used for reflection and object introspection.
```java
Class<?> clazz = this.getClass();  // Returns the runtime class of the object
```

#### 7. **`notify()`, `notifyAll()`, `wait()`**
- These methods are used for thread communication in Java’s multi-threading model.
- `notify()` and `notifyAll()` are used to wake up threads that are waiting on the object’s monitor, while `wait()` causes the current thread to wait until another thread calls `notify()` or `notifyAll()` on the same object.

---

### **Default Implementations of Object Class Methods**

#### **`toString()` (Default Implementation)**
```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```
- Default behavior returns the class name and memory address in hexadecimal.

#### **`equals(Object obj)` (Default Implementation)**
```java
public boolean equals(Object obj) {
    return (this == obj);  // Compares references (not content)
}
```
- By default, `equals()` compares object references (not content).

#### **`hashCode()` (Default Implementation)**
```java
public native int hashCode();
```
- The `hashCode()` method in `Object` class is a native method, meaning it is implemented in platform-dependent code. By default, it typically returns the memory address of the object.

---

### **Example: Overriding Object Class Methods**

Here’s an example of a custom class overriding `equals()`, `hashCode()`, and `toString()` methods to provide custom behavior.

```java
class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals() method to compare Person objects by name and age
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    // Overriding hashCode() method to generate hash based on name and age
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // Overriding toString() to return meaningful description of Person object
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("John", 30);
        Person p2 = new Person("John", 30);

        // Check equals() method
        System.out.println(p1.equals(p2));  // true

        // Check hashCode() method
        System.out.println(p1.hashCode() == p2.hashCode());  // true

        // Check toString() method
        System.out.println(p1);  // Outputs: Person{name='John', age=30}
    }
}
```

### **Summary of Common Object Class Methods**

| **Method**             | **Description**                                                                                      | **Default Behavior**                                                                 |
|------------------------|------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
| **`equals(Object obj)`**| Compares this object to another for equality.                                                        | Compares object references (i.e., `this == obj`).                                    |
| **`hashCode()`**        | Returns a hash code value for the object, used in hashing collections.                               | Based on memory address (platform-dependent).                                        |
| **`toString()`**        | Returns a string representation of the object.                                                      | Returns class name + "@" + hash code in hexadecimal.                                 |
| **`clone()`**           | Creates and returns a copy of the object (if the class implements `Cloneable`).                      | Performs a shallow copy.                                                            |
| **`getClass()`**        | Returns the runtime class of the object.                                                            | Used for reflection and class introspection.                                         |
| **`finalize()`**        | Called before garbage collection to perform any cleanup.                                            | Deprecated in Java 9 due to unpredictability.                                        |
| **`wait()`, `notify()`, `notifyAll()`** | Used for thread synchronization and communication between threads.                        | Controls object monitor for multithreading.                                          |

