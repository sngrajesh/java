In Java, **wrapper classes** provide a way to use primitive data types (like `int`, `char`, `float`, etc.) as objects. Since primitive types are not objects, they cannot be used in certain contexts where objects are required (e.g., with collections like `ArrayList`). To address this, Java provides wrapper classes that convert primitive types into objects.

### Primitive Types and Corresponding Wrapper Classes:
Each primitive data type has a corresponding wrapper class in `java.lang` package:

| Primitive Type | Wrapper Class |
|----------------|---------------|
| `boolean`      | `Boolean`     |
| `byte`         | `Byte`        |
| `char`         | `Character`   |
| `short`        | `Short`       |
| `int`          | `Integer`     |
| `long`         | `Long`        |
| `float`        | `Float`       |
| `double`       | `Double`      |

### Purpose of Wrapper Classes:
1. **Object representation**: Wrapper classes allow primitive types to be treated as objects.
2. **Utility methods**: Wrapper classes provide several utility methods, such as parsing strings into primitives, converting between different number bases, etc.
3. **Support for Collections**: Primitive types cannot be directly used with generic collections (`ArrayList`, `HashMap`, etc.), but wrapper classes can.
4. **Nullability**: Unlike primitive types, wrapper objects can represent `null`, which can be useful in certain situations (e.g., optional values).

### Example of Wrapper Class Usage:
```java
public class WrapperExample {
    public static void main(String[] args) {
        // Primitive type
        int num = 5;

        // Converting int to Integer (Wrapper class)
        Integer wrappedNum = Integer.valueOf(num);  // Boxing or wrapping
        System.out.println("Wrapped Integer: " + wrappedNum);

        // Unboxing (converting wrapper class to primitive)
        int unwrappedNum = wrappedNum.intValue();  // Unboxing
        System.out.println("Unwrapped Integer: " + unwrappedNum);

        // Autoboxing (automatic conversion from primitive to wrapper)
        Integer autoWrappedNum = num;  // Automatic boxing
        System.out.println("Autoboxed Integer: " + autoWrappedNum);

        // Auto-unboxing (automatic conversion from wrapper to primitive)
        int autoUnwrappedNum = autoWrappedNum;  // Automatic unboxing
        System.out.println("Auto-unboxed Integer: " + autoUnwrappedNum);
    }
}
```

### Output:
```
Wrapped Integer: 5
Unwrapped Integer: 5
Autoboxed Integer: 5
Auto-unboxed Integer: 5
```

### Key Concepts:

#### 1. **Boxing and Unboxing**:
- **Boxing**: Converting a primitive type into its corresponding wrapper class.
  ```java
  int i = 10;
  Integer wrapped = Integer.valueOf(i);  // Manual boxing
  Integer autoWrapped = i;  // Autoboxing (automatic)
  ```
- **Unboxing**: Converting a wrapper class back into its primitive type.
  ```java
  Integer wrapped = 10;
  int unwrapped = wrapped.intValue();  // Manual unboxing
  int autoUnwrapped = wrapped;  // Auto-unboxing (automatic)
  ```

#### 2. **Autoboxing and Auto-unboxing**:
- **Autoboxing**: Java automatically converts a primitive type into its corresponding wrapper class when needed.
- **Auto-unboxing**: Java automatically converts a wrapper object to its corresponding primitive type when needed.

#### Example with Autoboxing:
```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);  // Autoboxing: 10 (int) -> Integer.valueOf(10)

int num = numbers.get(0);  // Auto-unboxing: Integer -> int
```

### Utility Methods in Wrapper Classes:

1. **Parsing strings to primitive types**:
   Each wrapper class has a method that allows you to parse a string into its corresponding primitive type.

    - Example for `Integer`:
      ```java
      String str = "100";
      int num = Integer.parseInt(str);  // Converts String to int
      System.out.println(num);  // Output: 100
      ```

2. **Converting primitive types to strings**:
   Wrapper classes have `toString()` methods for converting the primitive values into strings.

    - Example:
      ```java
      int num = 100;
      String str = Integer.toString(num);  // Converts int to String
      System.out.println(str);  // Output: "100"
      ```

3. **Constants**:
   Wrapper classes have constants like `MAX_VALUE` and `MIN_VALUE` that provide information about the maximum and minimum values for their corresponding primitive types.

    - Example:
      ```java
      System.out.println("Max Integer: " + Integer.MAX_VALUE);
      System.out.println("Min Integer: " + Integer.MIN_VALUE);
      ```

### Benefits of Wrapper Classes:
1. **Collection Framework Compatibility**: Since collections like `ArrayList` and `HashMap` work with objects, not primitives, wrapper classes are needed to store primitive data types.
2. **Utility Methods**: Each wrapper class provides useful methods like parsing, converting between types, and others.
3. **Nullability**: Unlike primitive types, wrapper objects can be assigned `null` values, which is useful in scenarios where absence of value needs to be represented.

### Commonly Used Wrapper Methods:
- **`parseXxx(String s)`**: Converts a string to a primitive type (`Integer.parseInt()`, `Double.parseDouble()`, etc.).
- **`toString()`**: Converts the wrapper object into a string representation.
- **`valueOf(String s)`**: Converts a string to the corresponding wrapper class object.
- **`xxxValue()`**: Converts the wrapper object back to its primitive form (`intValue()`, `doubleValue()`, etc.).

### Wrapper Class Example with Collections:
```java
import java.util.ArrayList;

public class WrapperWithCollection {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();

        // Autoboxing: int -> Integer
        intList.add(10);
        intList.add(20);

        // Auto-unboxing: Integer -> int
        int sum = 0;
        for (Integer num : intList) {
            sum += num;  // Auto-unboxing happens here
        }

        System.out.println("Sum: " + sum);
    }
}
```

### Output:
```
Sum: 30
```

### Conclusion:
Wrapper classes in Java play a vital role in bridging the gap between primitive types and the object-oriented features of Java, particularly in scenarios where objects are required (such as in collections or with methods that accept objects). They also provide utility methods and allow for type conversions.