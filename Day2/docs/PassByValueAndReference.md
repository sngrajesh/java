### 1. **Primitive Types**
When you pass a primitive data type (like `int`, `float`, `char`, etc.) to a method, Java copies the value. Changes made to the parameter inside the method do not affect the original variable.

**Example:**
```java
public class PassByValueExample {
    public static void main(String[] args) {
        int num = 10;
        modifyValue(num);
        System.out.println("After modifyValue: " + num); // Outputs: 10
    }

    public static void modifyValue(int value) {
        value = 20; // This change does not affect 'num' in main
    }
}
```

### 2. **Object References**
When you pass an object (like an array or an instance of a class), you are passing the reference to that object, but the reference itself is passed by value. This means that you can modify the object's attributes, but you cannot change the reference to point to a new object.

**Example:**
```java
class MyClass {
    int value;
}

public class PassByReferenceExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.value = 10;
        modifyObject(obj);
        System.out.println("After modifyObject: " + obj.value); // Outputs: 20
    }

    public static void modifyObject(MyClass obj) {
        obj.value = 20; // This modifies the original object's value
    }
}
```

### 3. **Arrays**
Arrays in Java are also objects. When you pass an array to a method, you can modify the elements of the array, but you cannot reassign the entire array to a new array.

**Example:**
```java
public class PassByArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        modifyArray(numbers);
        System.out.println("After modifyArray: " + numbers[0]); // Outputs: 10
    }

    public static void modifyArray(int[] arr) {
        arr[0] = 10; // Modifies the original array
    }
}
```

### Summary
- **Primitive types**: Passed by value (changes do not affect original).
- **Objects**: Reference passed by value (changes to the object are reflected).
- **Arrays**: Same as objects (elements can be modified, but the reference cannot be changed).
