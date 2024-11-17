In Java, exceptions are primarily divided into **checked exceptions** and **unchecked exceptions**, with a few other subtypes like **errors**. Below is a detailed classification of all the exception types in Java.

### 1. **Checked Exceptions**
Checked exceptions are those that the compiler checks at compile-time. These exceptions must be either `caught or declared in the method using throws`.

#### Common Checked Exceptions:

- **`ClassNotFoundException`**: Thrown when trying to load a class at runtime that is not found.
- **`IOException`**: Thrown when there is an input/output operation failure (e.g., file not found, or network issues).
    - **`FileNotFoundException`**: A subclass of `IOException`, thrown when trying to open a file that doesn’t exist.
    - **`EOFException`**: Thrown when an end of a file or stream is unexpectedly reached.
- **`SQLException`**: Thrown when an error occurs while accessing the database.
- **`InterruptedException`**: Thrown when a thread is interrupted while it is sleeping or waiting.
- **`InstantiationException`**: Thrown when trying to instantiate an abstract class or an interface using `new`.
- **`IllegalAccessException`**: Thrown when the currently executing method does not have access to the definition of the specified class, field, method, or constructor.
- **`InvocationTargetException`**: Thrown when an invoked method or constructor throws an exception.
- **`NoSuchMethodException`**: Thrown when a method cannot be found.
- **`CloneNotSupportedException`**: Thrown when trying to clone an object that does not implement the `Cloneable` interface.
- **`ReflectiveOperationException`**: A common superclass for exceptions in the reflection API (`IllegalAccessException`, `InstantiationException`, etc.).

### 2. **Unchecked Exceptions (Runtime Exceptions)**
Unchecked exceptions, which extend the `RuntimeException` class, are not checked at compile-time. These exceptions typically result from programming errors (e.g., accessing null objects, invalid array indices).

#### Common Unchecked Exceptions (Runtime Exceptions):

- **`NullPointerException`**: Thrown when an application attempts to use `null` where an object is required.
- **`ArrayIndexOutOfBoundsException`**: Thrown when trying to access an array with an invalid index.
- **`ArithmeticException`**: Thrown when an exceptional arithmetic condition occurs, like division by zero.
- **`ClassCastException`**: Thrown when trying to cast an object to a class of which it is not an instance.
- **`IllegalArgumentException`**: Thrown when a method receives an argument that is inappropriate.
    - **`NumberFormatException`**: A subclass of `IllegalArgumentException`, thrown when trying to convert a string into a numeric type (like `int`, `double`) that is not properly formatted.
- **`IllegalStateException`**: Thrown when a method is invoked at an illegal or inappropriate time.
- **`IndexOutOfBoundsException`**: Thrown to indicate that an index is out of range (e.g., for strings or lists).
- **`NegativeArraySizeException`**: Thrown when an application attempts to create an array with a negative size.
- **`UnsupportedOperationException`**: Thrown when an operation is not supported.
- **`ConcurrentModificationException`**: Thrown when an object is modified concurrently, and it doesn't support such modifications.

### 3. **Errors**
Errors represent serious problems that an application should not try to handle (like hardware failures or JVM errors). Errors typically indicate issues from which recovery is not possible.

#### Common Errors:

- **`StackOverflowError`**: Thrown when the stack overflows because the program recurses too deeply.
- **`OutOfMemoryError`**: Thrown when the Java Virtual Machine (JVM) cannot allocate an object because it is out of memory.
- **`InternalError`**: Thrown to indicate an internal error in the JVM.
- **`UnknownError`**: Thrown when an unknown error occurs in the JVM.
- **`VirtualMachineError`**: A superclass of errors like `StackOverflowError`, `OutOfMemoryError`, etc.
- **`AssertionError`**: Thrown to indicate that an assertion has failed (used for debugging).
- **`LinkageError`**: Thrown when a class dependency fails during the linking phase.
    - **`NoClassDefFoundError`**: Thrown when the JVM or class loader cannot find the definition of a class required by the application.
    - **`UnsatisfiedLinkError`**: Thrown when an attempt to dynamically load a native library fails.

### 4. **Custom Exceptions**
You can also define your own exceptions by extending the `Exception` class (for checked exceptions) or the `RuntimeException` class (for unchecked exceptions).

```java
class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
```

### 5. **Hierarchy of Exceptions**
Here's a basic representation of how exceptions are structured in Java:

```
java.lang.Throwable
    ├── java.lang.Exception
    │       ├── Checked Exceptions (IOException, SQLException, etc.)
    │       └── RuntimeException (Unchecked exceptions like NullPointerException, etc.)
    └── java.lang.Error
            ├── StackOverflowError
            ├── OutOfMemoryError
            └── InternalError
```
---


Exception handling in Java is a mechanism that handles runtime errors, allowing the normal flow of the program to continue without crashing. Java provides a robust and flexible framework to handle exceptions using five key keywords: `try`, `catch`, `finally`, `throw`, and `throws`.

### 1. **Keywords in Exception Handling:**

#### **1.1 `try`:**
This block contains the code that might throw an exception. If an exception occurs, it will be caught by an associated `catch` block.
```java
try {
    // Code that might throw an exception
}
```

#### **1.2 `catch`:**
This block catches the exception thrown by the `try` block and handles it.
```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Handle the exception
}
```

#### **1.3 `finally`:**
This block contains code that is always executed after the `try` and `catch` blocks, whether or not an exception occurs. It is often used to release resources such as file handles or database connections.
```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Handle the exception
} finally {
    // Code that will always execute
}
```

#### **1.4 `throw`:**
This keyword is used to explicitly throw an exception. It can be used for both checked and unchecked exceptions.
```java
throw new ExceptionType("Error message");
```

#### **1.5 `throws`:**
This is used in the method signature to indicate that a method may throw exceptions.
```java
public void myMethod() throws ExceptionType {
    // Method code
}
```

### 2. **Types of Exceptions:**

Java exceptions fall into two main categories:

#### **2.1 Checked Exceptions:**
These exceptions are checked at compile-time. If a method can throw a checked exception, the method must declare it using the `throws` keyword, or handle it with a `try-catch` block. Examples include `IOException`, `SQLException`, and `ClassNotFoundException`.

#### **2.2 Unchecked Exceptions:**
These exceptions are not checked at compile-time but rather at runtime. They extend `RuntimeException`, and the compiler doesn't require them to be declared or caught. Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.

### 3. **Custom Exceptions:**

You can create your own exception class by extending the `Exception` class (for checked exceptions) or the `RuntimeException` class (for unchecked exceptions).

```java
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

### 4. **Example of Exception Handling:**

```java
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("This will always execute.");
        }
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;  // Throws ArithmeticException if b is 0
    }
}
```

### 5. **Best Practices:**

- **Catch specific exceptions first:** Always catch more specific exceptions before general exceptions like `Exception`.
- **Avoid empty `catch` blocks:** If an exception occurs, handle it properly or at least log it.
- **Use `finally` to close resources:** Always close resources like database connections or file streams in the `finally` block.
- **Throw custom exceptions when needed:** For better error-handling, throw specific custom exceptions that represent the error clearly.

