In Java, when we talk about **deep copy** and **shallow copy**, we are referring to the way objects are copied in memory. The difference between them lies in whether the copy duplicates the actual objects (deep copy) or just references to the objects (shallow copy).

Let's explore these concepts using the same `Person` class example, and then demonstrate how deep and shallow copies work.

### **Shallow Copy**

A **shallow copy** of an object creates a new object, but it copies the **references** of the fields (if the fields are objects) rather than creating copies of the actual objects. Primitive types (like `int`, `char`, etc.) are copied directly because they are not references.

In shallow copy:
- If a field is a **primitive type** (e.g., `int`, `char`), its value is copied directly.
- If a field is a **reference type** (e.g., `String`, arrays, other objects), the reference (or address) is copied, not the actual object itself.

#### **Example of Shallow Copy in the `Person` class:**

```java
class Person implements Cloneable {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Shallow copy method using clone() 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // This performs a shallow copy
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person original = new Person("Alice", 30);

        // Performing a shallow copy using clone()
        Person shallowCopy = (Person) original.clone();

        // Printing both objects
        System.out.println("Original: " + original);
        System.out.println("Shallow Copy: " + shallowCopy);

        // Modifying the shallow copy's name
        shallowCopy.setName("Bob");

        // Observe changes
        System.out.println("Original after modification: " + original);
        System.out.println("Shallow Copy after modification: " + shallowCopy);
    }
}
```

#### **Explanation**:
- In this example, we perform a **shallow copy** using the `clone()` method from the `Object` class.
- After cloning, both `original` and `shallowCopy` refer to distinct `Person` objects. However, if any field was a reference to an object, it would still point to the same object in memory.
- Modifying the `name` field of `shallowCopy` does not affect `original` because `String` in Java is **immutable** (a new object is created when you modify it). However, with mutable reference types, shallow copies could lead to shared references.

#### **Output**:
```
Original: Person{name='Alice', age=30}
Shallow Copy: Person{name='Alice', age=30}
Original after modification: Person{name='Alice', age=30}
Shallow Copy after modification: Person{name='Bob', age=30}
```

---

### **Deep Copy**

A **deep copy** involves copying all fields, and for any field that is a reference to an object, it creates a **new copy of that object**, rather than copying the reference. This way, changes made to the copied object do not affect the original object, even if the fields are references to other objects.

In deep copy:
- Primitive types are copied directly.
- Reference types (like objects or arrays) are duplicated by creating new objects, and the references are updated to point to these new objects.

#### **Example of Deep Copy in the `Person` class:**

Let's modify the `Person` class to include a field that is a reference type, like an array of `Address` objects, and then implement a deep copy.

```java
class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return city;
    }
}

class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;  // Reference type field

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Deep copy method using clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();  // Shallow copy first
        clonedPerson.address = new Address(this.address.getCity());  // Create deep copy of address
        return clonedPerson;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address + "}";
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person original = new Person("Alice", 30, address);

        // Performing a deep copy using clone()
        Person deepCopy = (Person) original.clone();

        // Printing both objects
        System.out.println("Original: " + original);
        System.out.println("Deep Copy: " + deepCopy);

        // Modifying the deep copy's address
        deepCopy.getAddress().setCity("San Francisco");

        // Observe changes
        System.out.println("Original after modification: " + original);
        System.out.println("Deep Copy after modification: " + deepCopy);
    }
}
```

#### **Explanation**:
- In the deep copy implementation, we first perform a shallow copy using `super.clone()`.
- We then manually create a new `Address` object for the `address` field, ensuring that the deep copy has its own `Address` object rather than sharing the reference to the original one.
- This ensures that changes to the `deepCopy` object do not affect the `original` object.

#### **Output**:
```
Original: Person{name='Alice', age=30, address=New York}
Deep Copy: Person{name='Alice', age=30, address=New York}
Original after modification: Person{name='Alice', age=30, address=New York}
Deep Copy after modification: Person{name='Alice', age=30, address=San Francisco}
```

### **Key Differences between Shallow Copy and Deep Copy**

| **Aspect**             | **Shallow Copy**                                              | **Deep Copy**                                                  |
|------------------------|---------------------------------------------------------------|----------------------------------------------------------------|
| **Primitive Fields**    | Copies the values directly.                                   | Copies the values directly.                                    |
| **Reference Fields**    | Copies the references, meaning both objects point to the same referenced objects. | Creates new objects for the referenced fields. No shared references. |
| **Memory Usage**        | More memory-efficient since it shares object references.      | Uses more memory as it creates new objects for all references.  |
| **When to Use**         | Suitable when the referenced objects are immutable or should be shared. | Necessary when you need independent copies of the referenced objects. |

---

### **Summary**

- **Shallow Copy**: Copies only the fields of the object itself and shares the references to the original object's contained objects. Changes in the referenced objects will affect both copies.
- **Deep Copy**: Copies both the object and all objects referenced by it. Any changes made to the deep-copied object or its referenced objects will not affect the original object.

In Java, creating deep copies often requires custom implementation, as the default `clone()` method performs a shallow copy.