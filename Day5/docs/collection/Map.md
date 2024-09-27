In Java, the **Map** is a part of the **Collections Framework** and is used to store data in key-value pairs. It does not allow duplicate keys, but it can have duplicate values. Maps are particularly useful when you want to quickly look up a value based on a unique key.

### Key Features of a Map:
1. **Key-Value Pair**: Every element in a `Map` is a key-value pair. Each key is associated with one value.
2. **No Duplicate Keys**: A `Map` cannot contain duplicate keys. If you try to insert a duplicate key, the old value associated with that key will be replaced.
3. **Different Implementations**: Java provides various implementations of the `Map` interface like `HashMap`, `LinkedHashMap`, `TreeMap`, and `Hashtable`, each with different performance characteristics.

### Common Map Implementations in Java:

#### 1. **`HashMap`**
- **Description**:
    - The most commonly used implementation of the `Map` interface. It is backed by a **hash table**.
    - It does not maintain any order of the keys or values.
    - Allows one `null` key and multiple `null` values.

- **Performance**:
    - **O(1)** average time complexity for basic operations like `put()` and `get()`.

#### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        
        // Adding key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        
        // Accessing values
        System.out.println("Value for key 'Banana': " + map.get("Banana"));  // Output: 2
        
        // Iterating over the Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

#### Output:
```
Value for key 'Banana': 2
Key: Apple, Value: 1
Key: Orange, Value: 3
Key: Banana, Value: 2
```

---

#### 2. **`LinkedHashMap`**
- **Description**:
    - It extends `HashMap` and maintains a **doubly-linked list** of the entries, which preserves the insertion order.
    - It allows one `null` key and multiple `null` values.

- **Performance**:
    - Similar to `HashMap`, but slightly slower due to maintaining the linked list for ordering.

#### Example:
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        
        // Adding key-value pairs
        map.put("Dog", 1);
        map.put("Cat", 2);
        map.put("Bird", 3);
        
        // Iterating over the Map (preserves insertion order)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

#### Output:
```
Key: Dog, Value: 1
Key: Cat, Value: 2
Key: Bird, Value: 3
```

---

#### 3. **`TreeMap`**
- **Description**:
    - It is a **sorted** `Map` implementation that stores its entries in **natural order** (ascending order of keys) or according to a custom comparator.
    - It is backed by a **Red-Black tree**.
    - Does not allow `null` keys, but can have multiple `null` values.

- **Performance**:
    - **O(log n)** time complexity for `put()`, `get()`, and `remove()` operations because of the tree structure.

#### Example:
```java
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        
        // Adding key-value pairs
        map.put("Zebra", 5);
        map.put("Elephant", 3);
        map.put("Lion", 4);
        
        // Iterating over the Map (sorted by keys)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

#### Output:
```
Key: Elephant, Value: 3
Key: Lion, Value: 4
Key: Zebra, Value: 5
```

---

#### 4. **`Hashtable`**
- **Description**:
    - Similar to `HashMap`, but it is **synchronized**, meaning it is thread-safe.
    - Does not allow `null` keys or `null` values.

- **Performance**:
    - Slower than `HashMap` due to synchronization overhead.

#### Example:
```java
import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();
        
        // Adding key-value pairs
        map.put("Car", 1);
        map.put("Bike", 2);
        map.put("Bus", 3);
        
        // Accessing values
        System.out.println("Value for key 'Bike': " + map.get("Bike"));  // Output: 2
    }
}
```

---

### Methods of the `Map` Interface:
Here are some of the most commonly used methods of the `Map` interface:

1. **`put(K key, V value)`**: Associates the specified value with the specified key in the map.
   ```java
   map.put("Apple", 1);
   ```

2. **`get(Object key)`**: Returns the value to which the specified key is mapped, or `null` if the map contains no mapping for the key.
   ```java
   Integer value = map.get("Apple");
   ```

3. **`remove(Object key)`**: Removes the mapping for a key from the map if it is present.
   ```java
   map.remove("Banana");
   ```

4. **`containsKey(Object key)`**: Returns `true` if the map contains a mapping for the specified key.
   ```java
   boolean hasKey = map.containsKey("Apple");
   ```

5. **`containsValue(Object value)`**: Returns `true` if the map maps one or more keys to the specified value.
   ```java
   boolean hasValue = map.containsValue(1);
   ```

6. **`keySet()`**: Returns a `Set` view of the keys contained in the map.
   ```java
   Set<String> keys = map.keySet();
   ```

7. **`values()`**: Returns a `Collection` view of the values contained in the map.
   ```java
   Collection<Integer> values = map.values();
   ```

8. **`entrySet()`**: Returns a `Set` view of the key-value pairs contained in the map.
   ```java
   Set<Map.Entry<String, Integer>> entries = map.entrySet();
   ```

9. **`size()`**: Returns the number of key-value pairs in the map.
   ```java
   int size = map.size();
   ```

10. **`clear()`**: Removes all key-value pairs from the map.
    ```java
    map.clear();
    ```

---

### Example: Using `HashMap` and Iterating Over the Entries
```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> map = new HashMap<>();
        
        // Adding elements to the map
        map.put("John", 30);
        map.put("Sarah", 25);
        map.put("Mike", 40);
        
        // Accessing a value by its key
        System.out.println("John's age: " + map.get("John"));  // Output: John's age: 30
        
        // Iterating over the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Checking if a key or value exists
        boolean hasJohn = map.containsKey("John");
        boolean hasAge30 = map.containsValue(30);
        
        System.out.println("Contains key 'John': " + hasJohn);  // Output: true
        System.out.println("Contains value 30: " + hasAge30);   // Output: true
        
        // Removing an entry
        map.remove("Mike");
        System.out.println("Map after removing Mike: " + map);
    }
}
```

#### Output:
```
John's age: 30
John: 30
Sarah: 25
Mike: 40
Contains key 'John': true
Contains value 30: true
Map after removing Mike: {John=30, Sarah=25}
```

---

### Choosing the Right Map Implementation:
- **`HashMap`**: If you don't care about the order of the

elements and want fast access to elements, use `HashMap`.
- **`LinkedHashMap`**: If you want to maintain the insertion order, use `LinkedHashMap`.
- **`TreeMap`**: If you need the keys to be sorted, use `TreeMap`.
- **`Hashtable`**: If you need a thread-safe implementation, but prefer using `ConcurrentHashMap` in modern multi-threaded environments.
