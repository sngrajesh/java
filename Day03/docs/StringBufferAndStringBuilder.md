In Java, both `StringBuffer` and `StringBuilder` are used to create mutable sequences of characters, meaning their content can be modified after they are created. They are alternatives to the `String` class when frequent modifications (like appending, inserting, or deleting characters) are needed. However, there are key differences between them, especially in terms of thread-safety and performance.

### 1. **`StringBuffer` Class**
- **Mutable**: You can modify the contents of a `StringBuffer` object without creating a new object.
- **Thread-safe**: Methods of `StringBuffer` are synchronized, which means it is safe to use in a multi-threaded environment where multiple threads might be modifying the same object.
- **Slower**: Because of the synchronization overhead, `StringBuffer` is slower compared to `StringBuilder` when used in a single-threaded context.

### 2. **`StringBuilder` Class**
- **Mutable**: Like `StringBuffer`, the contents of a `StringBuilder` object can also be modified without creating a new object.
- **Not thread-safe**: Methods of `StringBuilder` are not synchronized, which makes it unsafe to use in a multi-threaded environment where multiple threads are modifying the same object.
- **Faster**: Since there is no synchronization overhead, `StringBuilder` is generally faster than `StringBuffer`, and should be preferred in single-threaded applications.

---

## Syntax

### StringBuffer Example
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World"); // Appends " World" to the original string
System.out.println(sb); // Outputs: "Hello World"
```

### StringBuilder Example
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Appends " World" to the original string
System.out.println(sb); // Outputs: "Hello World"
```

---

## Comparison Between `String`, `StringBuffer`, and `StringBuilder`

| Feature                  | `String`              | `StringBuffer`       | `StringBuilder`       |
|--------------------------|-----------------------|----------------------|-----------------------|
| **Mutability**            | Immutable             | Mutable              | Mutable               |
| **Thread-safety**         | Thread-safe (immutable objects) | Thread-safe (synchronized methods) | Not thread-safe |
| **Performance**           | Slower for modifications | Slower (due to synchronization overhead) | Faster (no synchronization) |
| **Use case**              | When string value won’t change frequently | When thread safety is important in a multi-threaded context | When frequent string modification is needed in a single-threaded context |

---

## Key Methods of `StringBuffer` and `StringBuilder`

Both `StringBuffer` and `StringBuilder` have the same set of methods since they implement the same interface (`Appendable` and `CharSequence`). Here are some common and important methods:

### 1. `append(String str)`
Appends the given string to the existing sequence.
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb); // Outputs: "Hello World"
```

### 2. `insert(int offset, String str)`
Inserts the string at the specified position (offset).
```java
StringBuffer sb = new StringBuffer("Hello");
sb.insert(5, " World");
System.out.println(sb); // Outputs: "Hello World"
```

### 3. `delete(int start, int end)`
Deletes characters from the sequence between the specified start and end indices.
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.delete(5, 11);
System.out.println(sb); // Outputs: "Hello"
```

### 4. `reverse()`
Reverses the character sequence.
```java
StringBuffer sb = new StringBuffer("Hello");
sb.reverse();
System.out.println(sb); // Outputs: "olleH"
```

### 5. `length()` and `capacity()`
- `length()` returns the number of characters currently in the buffer.
- `capacity()` returns the total allocated capacity of the buffer (it increases automatically as needed).
```java
StringBuilder sb = new StringBuilder("Hello");
System.out.println(sb.length()); // Outputs: 5
System.out.println(sb.capacity()); // Default capacity is 16 plus the length of the string
```

### 6. `setLength(int newLength)`
Sets the length of the character sequence. If the new length is shorter, the sequence is truncated. If it's longer, additional characters are filled with `\u0000`.
```java
StringBuilder sb = new StringBuilder("Hello");
sb.setLength(3);
System.out.println(sb); // Outputs: "Hel"
```

---

## Example Use Cases

### Example 1: Using `StringBuffer` in a Multi-threaded Environment
```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");

        // Creating multiple threads to modify the same StringBuffer object
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                sb.append(" World");
            }
            System.out.println(sb);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
```
In this example, the use of `StringBuffer` ensures thread-safety, even though multiple threads are modifying the same object.

### Example 2: Using `StringBuilder` in a Single-threaded Environment
```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // No synchronization is needed as it's a single-threaded environment
        sb.append(" World");
        sb.append("!");
        System.out.println(sb); // Outputs: "Hello World!"
    }
}
```
Here, `StringBuilder` is faster and more efficient in a single-threaded context.

---

| **Category**        | **Method**                                              | **Description**                                                                                  |
|---------------------|---------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| **Modification**     | `append(String str)`                                    | Appends the specified string to the end of the current sequence.                                  |
|                     | `insert(int offset, String str)`                        | Inserts the specified string at the given position (offset).                                      |
|                     | `replace(int start, int end, String str)`               | Replaces the characters between the specified indices with the specified string.                  |
|                     | `delete(int start, int end)`                            | Deletes the characters between the specified indices.                                             |
|                     | `deleteCharAt(int index)`                               | Deletes the character at the specified index.                                                     |
|                     | `reverse()`                                             | Reverses the current sequence of characters.                                                      |
|                     | `setCharAt(int index, char ch)`                         | Sets the character at the specified index to a new character.                                     |
|                     | `setLength(int newLength)`                              | Sets the length of the sequence. Truncates or pads with `\u0000` if necessary.                    |
| **Query**            | `length()`                                              | Returns the number of characters in the sequence.                                                 |
|                     | `capacity()`                                            | Returns the current capacity of the sequence (the total allocated space).                         |
|                     | `charAt(int index)`                                     | Returns the character at the specified index.                                                     |
|                     | `substring(int start)`                                  | Returns a substring from the specified start index to the end of the sequence.                    |
|                     | `substring(int start, int end)`                         | Returns a substring from the specified start index to the specified end index (exclusive).        |
|                     | `indexOf(String str)`                                   | Returns the index of the first occurrence of the specified substring.                             |
|                     | `indexOf(String str, int fromIndex)`                    | Returns the index of the first occurrence of the substring after the specified index.             |
|                     | `lastIndexOf(String str)`                               | Returns the index of the last occurrence of the specified substring.                              |
|                     | `lastIndexOf(String str, int fromIndex)`                | Returns the index of the last occurrence of the substring before the specified index.             |
| **Capacity Management** | `ensureCapacity(int minimumCapacity)`               | Ensures that the capacity is at least the specified minimum value.                                |
|                     | `trimToSize()`                                          | Reduces the capacity to match the current length of the sequence.                                 |
| **Conversion**       | `toString()`                                            | Converts the current sequence of characters to a `String`.                                        |


---

## Conclusion

- Use `String` when you need immutable strings.
- Use `StringBuffer` when you need a mutable string and thread-safety is a concern.
- Use `StringBuilder` when you need a mutable string in a single-threaded environment for better performance.

