In Java, **collections** are part of the `java.util` package and provide a framework for storing and manipulating groups of objects. The Java **Collections Framework** includes interfaces, implementations (classes), and algorithms to manage collections of data efficiently.

### 1. **Core Interfaces in Collections Framework**
Java Collections Framework defines several interfaces, which are the root types for the collections:

#### 1.1 **Collection Interface**
- **Subinterfaces**: List, Set, Queue, Deque
- It represents a group of objects known as elements.
- Core methods: `add()`, `remove()`, `clear()`, `size()`, `isEmpty()`, `contains()`, `iterator()`

#### 1.2 **List Interface**
- **Classes**: `ArrayList`, `LinkedList`, `Vector`
- Ordered collection (sequence) of elements.
- Elements can be accessed by their index (zero-based).
- Allows duplicate elements.

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.get(0);  // returns "A"
```

#### 1.3 **Set Interface**
- **Classes**: `HashSet`, `LinkedHashSet`, `TreeSet`
- Collection that does not allow duplicate elements.
- No defined order for elements (except for `TreeSet` which is sorted).

```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("A");  // Duplicate "A" will not be added
```

#### 1.4 **Queue Interface**
- **Classes**: `PriorityQueue`, `LinkedList` (also implements `Queue`)
- Typically orders elements in a first-in, first-out (FIFO) manner.
- Useful for processing tasks in order.

```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.poll();  // returns "A" and removes it
```

#### 1.5 **Map Interface** (Note: Map is not a Collection)
- **Classes**: `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`
- A map holds key-value pairs, where each key maps to one value.
- Keys are unique, but values may be duplicated.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.get("A");  // returns 1
```

### 2. **Popular Implementations**
Java provides many classes to implement these interfaces. The most commonly used implementations are:

- **`ArrayList`**: Resizable array implementation of the `List` interface.
- **`LinkedList`**: Doubly linked list implementation of both `List` and `Queue` interfaces.
- **`HashSet`**: Implementation of the `Set` interface backed by a hash table.
- **`TreeSet`**: Implements `Set`, but stores elements in a sorted tree.
- **`HashMap`**: Implements the `Map` interface using a hash table.
- **`LinkedHashMap`**: Same as `HashMap` but maintains insertion order.

### 3. **Collections Utility Class**
The `Collections` class in Java provides static methods to manipulate collections:
- `sort(List<T> list)`: Sorts a list in natural order.
- `reverse(List<T> list)`: Reverses the order of elements.
- `shuffle(List<T> list)`: Randomly shuffles elements.
- `max(Collection<T> coll)`: Returns the largest element.
- `min(Collection<T> coll)`: Returns the smallest element.

### 4. **Iterating Through Collections**
You can iterate through collections using several techniques:

#### 4.1 Using a `for-each` loop:
```java
for (String element : list) {
    System.out.println(element);
}
```

#### 4.2 Using an `Iterator`:
```java
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

#### 4.3 Using Java 8 Streams:
```java
list.stream().forEach(System.out::println);
```

### 5. **Generics in Collections**
Java collections are generic, meaning you can specify the type of elements they store. This helps avoid `ClassCastException` at runtime.

Example:
```java
List<Integer> list = new ArrayList<>();
list.add(1);   // Only integers can be added to this list
```

### 6. **Thread-Safe Collections**
For multithreaded environments, use thread-safe collections such as `Vector`, `Stack`, or synchronized versions:
- `Collections.synchronizedList(new ArrayList<>())`
- Use concurrent collections like `ConcurrentHashMap`, `CopyOnWriteArrayList`.

### 7. **Important Points**
- **`List`** allows duplicates and is ordered.
- **`Set`** does not allow duplicates, and some implementations (`TreeSet`) are ordered/sorted.
- **`Map`** stores key-value pairs, and keys must be unique.

### Example Usage
```java
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // List Example
        List<String> arrayList = new ArrayList<>();
        arrayList.add("One");
        arrayList.add("Two");
        
        // Set.md Example
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        
        // Map Example
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);

        // Iterating through List
        for (String str : arrayList) {
            System.out.println(str);
        }
        
        // Iterating through Map
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```



### Tree diagram
```shell
Java Collections Framework
├── Collection (Interface)
│   ├── List (Interface)
│   │   ├── ArrayList (Class)
│   │   ├── LinkedList (Class)
│   │   ├── Vector (Class)
│   │   └── Methods:
│   │       ├── add(index, element)
│   │       ├── get(index)
│   │       ├── remove(index)
│   │       ├── indexOf(element)
│   │       └── subList(fromIndex, toIndex)
│   │
│   ├── Set.md (Interface)
│   │   ├── HashSet (Class)
│   │   ├── LinkedHashSet (Class)
│   │   ├── TreeSet (Class)
│   │   └── Methods:
│   │       ├── add(element)
│   │       ├── remove(element)
│   │       ├── contains(element)
│   │       └── iterator()
│   │
│   ├── Queue (Interface)
│   │   ├── PriorityQueue (Class)
│   │   ├── LinkedList (Class)  ⟶ Implements both List & Queue
│   │   └── Methods:
│   │       ├── offer(element)
│   │       ├── poll()
│   │       ├── peek()
│   │       └── remove()
│   │
│   └── Deque (Interface)
│       ├── ArrayDeque (Class)
│       ├── LinkedList (Class)
│       └── Methods:
│           ├── addFirst(element)
│           ├── addLast(element)
│           ├── removeFirst()
│           ├── removeLast()
│           ├── peekFirst()
│           └── peekLast()

├── Map (Interface)
│   ├── HashMap (Class)
│   ├── LinkedHashMap (Class)
│   ├── TreeMap (Class)
│   ├── Hashtable (Class)
│   ├── ConcurrentHashMap (Class)
│   └── Methods:
│       ├── put(key, value)
│       ├── get(key)
│       ├── remove(key)
│       ├── containsKey(key)
│       ├── keySet()
│       ├── values()
│       └── entrySet()

├── Specialized Collections
│   ├── Stack (Class)
│   ├── Vector (Class)
│   └── Methods:
│       ├── push(element)
│       ├── pop()
│       ├── peek()
│       ├── empty()
│       └── search(element)

└── Utility Classes
├── Collections (Class)
│   └── Methods:
│       ├── sort(List)
│       ├── reverse(List)
│       ├── shuffle(List)
│       ├── min(Collection)
│       ├── max(Collection)
│       └── synchronizedList(List)
│
├── Arrays (Class)
│   └── Methods:
│       ├── asList(array)
│       ├── binarySearch(array, key)
│       ├── sort(array)
│       ├── equals(array1, array2)
│       ├── fill(array, value)
│       └── copyOf(array, newLength)

```