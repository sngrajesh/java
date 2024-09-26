
## Java `String` Documentation

### Overview

The `String` class in Java is one of the most commonly used classes. It is used to store and manipulate a sequence of characters. `String` in Java is an immutable object, meaning once a `String` object is created, it cannot be modified. Modifying a string creates a new `String` object.

The `String` class is part of the `java.lang` package, which is implicitly imported in every Java program.

### Key Characteristics
- **Immutable**: Once created, a `String` object cannot be changed.
- **Stored in String Pool**: String literals are stored in a common pool called the string pool, reducing memory consumption.
- **Supports a variety of operations**: Including searching, comparison, concatenation, and substring extraction.

## Creating Strings

You can create a `String` object in Java in several ways:

### Using String Literals
```java
String str = "Hello, World!";
```
When you create a string like this, it’s stored in the String Pool.

### Using the `new` Keyword
```java
String str = new String("Hello, World!");
```
This creates a new `String` object outside of the String Pool.

### From a Character Array
```java
char[] chars = { 'H', 'e', 'l', 'l', 'o' };
String str = new String(chars);
```

## Important Methods in `String` Class

### 1. `length()`
Returns the length (number of characters) of the string.
```java
String str = "Hello";
int len = str.length(); // len = 5
```

### 2. `charAt(int index)`
Returns the character at the specified index.
```java
char ch = str.charAt(1); // ch = 'e'
```

### 3. `substring(int beginIndex)`
Returns a new string that is a substring of the original string starting from `beginIndex`.
```java
String substr = str.substring(2); // substr = "llo"
```

### 4. `substring(int beginIndex, int endIndex)`
Returns a new string that is a substring of the original string from `beginIndex` to `endIndex` (exclusive).
```java
String substr = str.substring(1, 4); // substr = "ell"
```

### 5. `indexOf(String str)`
Returns the index of the first occurrence of the specified substring.
```java
int index = str.indexOf("lo"); // index = 3
```

### 6. `equals(Object another)`
Compares two strings for equality (case-sensitive).
```java
boolean isEqual = str.equals("Hello"); // isEqual = true
```

### 7. `equalsIgnoreCase(String another)`
Compares two strings for equality, ignoring case.
```java
boolean isEqual = str.equalsIgnoreCase("hello"); // isEqual = true
```

### 8. `contains(CharSequence s)`
Checks whether the string contains the specified sequence of characters.
```java
boolean contains = str.contains("ell"); // contains = true
```

### 9. `toLowerCase()` and `toUpperCase()`
Converts all characters of the string to lowercase or uppercase.
```java
String lower = str.toLowerCase(); // lower = "hello"
String upper = str.toUpperCase(); // upper = "HELLO"
```

### 10. `replace(char oldChar, char newChar)`
Returns a new string by replacing all occurrences of a specified character with another.
```java
String replaced = str.replace('l', 'p'); // replaced = "Heppo"
```

### 11. `trim()`
Removes leading and trailing white spaces from the string.
```java
String trimmed = "   Hello  ".trim(); // trimmed = "Hello"
```

### 12. `split(String regex)`
Splits the string around matches of the given regular expression and returns an array of substrings.
```java
String[] words = "Hello World".split(" "); // words = ["Hello", "World"]
```

### 13. `concat(String str)`
Concatenates the specified string to the end of the current string.
```java
String greeting = "Hello".concat(" World!"); // greeting = "Hello World!"
```

### 14. `startsWith(String prefix)` / `endsWith(String suffix)`
Checks if the string starts or ends with the specified prefix or suffix.
```java
boolean starts = str.startsWith("He"); // starts = true
boolean ends = str.endsWith("o"); // ends = true
```

### 15. `toCharArray()`
Converts the string into a character array.
```java
char[] charArray = str.toCharArray(); // charArray = ['H', 'e', 'l', 'l', 'o']
```

### 16. `isEmpty()`
Checks if the string is empty.
```java
String emptyStr = "";
boolean isEmpty = emptyStr.isEmpty(); // isEmpty = true
```

## String Comparison Methods

### `compareTo(String anotherString)`
Compares two strings lexicographically (dictionary order).
```java
int result = "apple".compareTo("banana"); // result < 0 because 'a' comes before 'b'
```

### `compareToIgnoreCase(String anotherString)`
Compares two strings lexicographically, ignoring case differences.
```java
int result = "apple".compareToIgnoreCase("Apple"); // result = 0
```

## String Immutability and Performance Considerations

Because strings are immutable, modifying a string results in the creation of a new object. This can impact performance when many concatenations or modifications are needed. In such cases, using `StringBuilder` or `StringBuffer` (mutable string classes) is recommended for better performance.

### Example of Inefficient String Concatenation
```java
String str = "";
for (int i = 0; i < 1000; i++) {
    str += i; // Creates a new String object each time, causing performance degradation.
}
```

### Efficient String Concatenation with `StringBuilder`
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i); // Efficient way of concatenating strings.
}
String result = sb.toString();
```

## Example Usage

### Example 1: Basic String Operations
```java
public class Main {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println("Length: " + str.length()); // Length: 13
        System.out.println("Character at index 4: " + str.charAt(4)); // o
        System.out.println("Substring: " + str.substring(7)); // World!
    }
}
```

### Example 2: Checking Palindrome
```java
public class Main {
    public static void main(String[] args) {
        String str = "madam";
        String reversed = new StringBuilder(str).reverse().toString();
        
        if (str.equals(reversed)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }
}
```
 