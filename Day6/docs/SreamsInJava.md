### Streams in Java

**Streams** in Java, introduced in **Java 8**, are a key abstraction that allows functional-style operations on sequences of elements (like collections). They enable processing of data in a declarative and flexible way, much like query operations in databases or functional languages. Java Streams provide a more concise way to process data, making it easier to write clean, maintainable code.

Streams are part of the `java.util.stream` package and support operations like **filtering**, **mapping**, **reducing**, and **collecting** data.

---

### Key Characteristics of Streams

1. **Streams do not store data**: They operate on a source (like a collection) and produce a result without storing intermediate data.
2. **Streams are lazy**: Intermediate operations are not executed until a terminal operation is invoked.
3. **Streams are consumable**: Once a stream is processed, it cannot be reused.
4. **Streams support parallelism**: Operations can be executed in parallel to leverage multi-core processors.

---

### Stream Operations

Stream operations are divided into two categories: **intermediate** and **terminal** operations.

#### 1. Intermediate Operations

These operations are lazy and return a new stream, allowing for method chaining. They do not perform any processing until a terminal operation is invoked.

- **`filter(Predicate)`**: Filters elements based on a condition.
- **`map(Function)`**: Transforms elements by applying a function.
- **`sorted()`**: Sorts the elements of the stream.
- **`distinct()`**: Removes duplicates.
- **`limit(long n)`**: Truncates the stream to contain no more than `n` elements.
- **`skip(long n)`**: Skips the first `n` elements of the stream.

#### 2. Terminal Operations

These operations trigger the processing of the stream and produce a result. They consume the stream, meaning that after a terminal operation, the stream cannot be used further.

- **`forEach(Consumer)`**: Performs an action for each element.
- **`collect(Collector)`**: Collects the result into a collection or other form.
- **`reduce(BinaryOperator)`**: Reduces the elements to a single value.
- **`count()`**: Counts the number of elements in the stream.
- **`findFirst()`**: Returns the first element (if any).
- **`allMatch(Predicate)`**: Returns `true` if all elements match the predicate.

---

### Stream Example: Basic Operations

Here’s an example that demonstrates the basic usage of streams:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // Filter names that start with "J", convert to uppercase, sort, and collect into a list
        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("J"))
                                   .map(String::toUpperCase)
                                   .sorted()
                                   .collect(Collectors.toList());

        System.out.println(result);  // Output: [JACK, JANE, JOHN]
    }
}
```

### Stream Example: Reduction and Aggregation

Streams also provide powerful aggregation capabilities. For example, you can use the `reduce` method to aggregate elements into a single result, like summing numbers or finding a maximum value.

```java
import java.util.Arrays;
import java.util.List;

public class StreamReduction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum all numbers using reduce
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);  // Using method reference

        System.out.println("Sum: " + sum);  // Output: Sum: 15
    }
}
```

### Parallel Streams

Java streams can be made parallel, allowing the operations to be performed concurrently, which can improve performance on large datasets by taking advantage of multi-core processors.

**Example**:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Using parallel stream for processing
int sum = numbers.parallelStream()
                 .reduce(0, Integer::sum);

System.out.println("Parallel Sum: " + sum);  // Output: Parallel Sum: 15
```

---


### Collectors and Comparator in Java Streams

In Java streams, the **`Collectors`** utility class and the **`Comparator`** interface play an essential role in manipulating and collecting data efficiently.

#### 1. **`Collectors` in Java Streams**

The `Collectors` class provides a variety of useful **reduction operations** that allow the collection of elements from a stream into various data structures or formats (like a `List`, `Set`, `Map`, etc.). The class is part of the `java.util.stream` package and provides several built-in implementations of the `Collector` interface.

#### Common Collectors:

- **`toList()`**: Collects elements into a `List`.
- **`toSet()`**: Collects elements into a `Set`.
- **`joining()`**: Concatenates elements into a single `String`.
- **`groupingBy()`**: Groups elements by a classifier function and collects them into a `Map`.
- **`partitioningBy()`**: Partitions elements into two groups based on a predicate.
- **`summarizingInt()`, `summarizingDouble()`, `summarizingLong()`**: Collects statistical summary information about elements.
- **`reducing()`**: Performs a reduction of elements.

##### Example of `Collectors.toList()`:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // Collect names into a list after filtering
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("J"))
                                          .collect(Collectors.toList());

        System.out.println(filteredNames);  // Output: [John, Jane, Jack]
    }
}
```

##### Example of `Collectors.groupingBy()`:

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe", "Jill");

        // Group names by their length
        Map<Integer, List<String>> groupedByLength = names.stream()
                                                          .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);
        // Output: {3=[Doe], 4=[John, Jane, Jack], 5=[Jill]}
    }
}
```

##### Example of `Collectors.joining()`:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack");

        // Join names into a single string
        String result = names.stream()
                             .collect(Collectors.joining(", "));

        System.out.println(result);  // Output: John, Jane, Jack
    }
}
```

---

#### 2. **Comparator in Java Streams**

A **`Comparator`** in Java is used to define the order of elements in a collection, such as sorting a list or stream. It is a functional interface that provides methods to compare two objects (`compare(T o1, T o2)`).

In streams, **`Comparator`** is used primarily with the `sorted()` intermediate operation, which allows for sorting elements based on a specified comparison logic.

#### Basic `Comparator` Usage:

You can create a `Comparator` using a lambda expression, method reference, or the `Comparator` utility methods.

##### Example of `Comparator`:

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // Sort names alphabetically
        names.stream()
             .sorted()  // Natural ordering (lexicographical for strings)
             .forEach(System.out::println);

        // Output: Doe, Jack, Jane, John
    }
}
```

#### Custom Comparator with Lambda:

You can use `Comparator.comparing()` to sort based on specific properties of objects.

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // Sort names by their length
        names.stream()
             .sorted(Comparator.comparing(String::length))
             .forEach(System.out::println);

        // Output: Doe, John, Jane, Jack (sorted by length of names)
    }
}
```

#### Example: Combining `Comparator` with `Collectors`:

We can combine the power of **`Comparator`** and **`Collectors`** to first sort a collection and then collect it into a data structure.

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndCollectExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // Sort names by length and collect into a list
        List<String> sortedNames = names.stream()
                                        .sorted(Comparator.comparing(String::length))
                                        .collect(Collectors.toList());

        System.out.println(sortedNames);  // Output: [Doe, John, Jane, Jack]
    }
}
```

#### Sorting in Reverse Order:

You can also sort elements in reverse order using `Comparator.reverseOrder()` or `Comparator.reversed()`.

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseSortingExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // Sort in reverse order by length
        names.stream()
             .sorted(Comparator.comparing(String::length).reversed())
             .forEach(System.out::println);

        // Output: Jack, Jane, John, Doe
    }
}
```

---

Comparing **stateful** and **stateless** operations in Java, particularly in the context of the **Stream API**:

| Feature                     | **Stateful Operation**                            | **Stateless Operation**                           |
|-----------------------------|---------------------------------------------------|--------------------------------------------------|
| **Definition**               | Requires knowledge of the entire stream or past elements to operate. | Operates on each element independently, without needing information from other elements. |
| **Examples in Stream API**   | `distinct()`, `sorted()`, `limit()`               | `map()`, `filter()`, `forEach()`, `peek()`        |
| **Internal State**           | Maintains some internal state during execution to process elements. | Does not maintain any internal state between elements. |
| **Performance**              | Potentially slower as it may require processing the entire stream before producing any output. | Generally faster since it can process elements individually and in parallel. |
| **Memory Usage**             | May require more memory, as it needs to store elements or intermediate results. | Typically uses less memory as it does not store any elements. |
| **Ordering Requirements**    | Often relies on the order of elements (e.g., `sorted()` requires sorting all elements before processing). | Does not depend on the order of elements; can process each independently. |
| **Impact on Parallel Streams**| May limit the benefits of parallel processing because of its dependence on prior elements. | Well-suited for parallel streams because each element can be processed independently. |
| **Execution Time**           | Execution may be delayed until the entire stream is processed (e.g., in sorting or deduplication). | Execution can happen immediately for each element in the stream. |
| **Example Scenario**         | Sorting a list of numbers before processing them (e.g., `stream.sorted().forEach()`); needs to sort everything first. | Doubling each number in a list (`stream.map(i -> i * 2)`); processes each element independently. |

### Summary:
- **Stateful operations** depend on the overall state of the stream, usually requiring all or part of the stream to be processed before results can be produced.
- **Stateless operations** work element-by-element, requiring no knowledge of other elements, making them more efficient and suitable for parallelism.

