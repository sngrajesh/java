In Java, both **`comparable`** and **`comparator`** are interfaces used to compare objects, but they differ in their purpose and how they are implemented.

### 1. **`Comparable` Interface:**
The `Comparable` interface is used when we want to define a natural ordering for objects of a class. A class that implements `Comparable` can compare its objects with one another.

- **Method to implement:**
    - `int compareTo(T obj)`
        - Returns:
            - Negative integer if the current object is less than the specified object.
            - Zero if they are equal.
            - Positive integer if the current object is greater than the specified object.

- **How to use:**
    - Implement the `Comparable` interface in the class and override the `compareTo` method.

- **Example:**
  ```java
  class Student implements Comparable<Student> {
      int id;
      String name;

      public Student(int id, String name) {
          this.id = id;
          this.name = name;
      }

      @Override
      public int compareTo(Student other) {
          return this.id - other.id; // Compare based on the 'id'
      }
  }

  public class Main {
      public static void main(String[] args) {
          List<Student> students = new ArrayList<>();
          students.add(new Student(3, "John"));
          students.add(new Student(1, "Jane"));
          students.add(new Student(2, "Bob"));

          Collections.sort(students); // Uses compareTo() for sorting
      }
  }
  ```

### 2. **`Comparator` Interface:**
The `Comparator` interface is used when we want to define multiple ways of comparing objects or when we don't have control over the class source code (i.e., when the class does not implement `Comparable`).

- **Methods to implement:**
    - `int compare(T obj1, T obj2)`
        - Returns:
            - Negative integer if `obj1` is less than `obj2`.
            - Zero if they are equal.
            - Positive integer if `obj1` is greater than `obj2`.

    - Optionally, `boolean equals(Object obj)`.

- **How to use:**
    - You create a separate class that implements `Comparator`, or you can use a lambda expression (from Java 8 onwards) to define a comparator.

- **Example:**
  ```java
  class Student {
      int id;
      String name;

      public Student(int id, String name) {
          this.id = id;
          this.name = name;
      }
  }

  class StudentNameComparator implements Comparator<Student> {
      @Override
      public int compare(Student s1, Student s2) {
          return s1.name.compareTo(s2.name); // Compare based on the 'name'
      }
  }

  public class Main {
      public static void main(String[] args) {
          List<Student> students = new ArrayList<>();
          students.add(new Student(3, "John"));
          students.add(new Student(1, "Jane"));
          students.add(new Student(2, "Bob"));

          Collections.sort(students, new StudentNameComparator()); // Uses the comparator for sorting by name
      }
  }
  ```

### **Key Differences:**
| Aspect           | `Comparable`                           | `Comparator`                           |
|------------------|----------------------------------------|----------------------------------------|
| Purpose          | Defines a default (natural) ordering for objects of a class. | Defines custom, multiple orderings for objects. |
| Interface Method | `compareTo(Object obj)`                | `compare(Object obj1, Object obj2)`    |
| Implementation   | Implemented directly in the class.     | Implemented in a separate class or using lambdas. |
| Number of Sorting Logics | One natural order.               | Multiple orderings possible.           |
| Example          | Sorting by `id` (in class itself).     | Sorting by `name` (outside class).     |

### When to use:
- Use `Comparable` when you have a single natural ordering that is closely tied to the class.
- Use `Comparator` when you want to define multiple comparison strategies, or when you don't have control over the class to implement `Comparable`.

