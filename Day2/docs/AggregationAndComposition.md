In Java, **aggregation** and **composition** are two types of relationships that describe how objects are related to each other. Both are types of **association**, which represents a "has-a" relationship between two classes. However, the key difference lies in the strength of the relationship and the life cycle dependency between the objects involved.

### 1. **Aggregation**:
- Aggregation is a **weaker form of association**.
- It represents a **"has-a" relationship**, but the contained object (part) can exist independently of the container (whole).
- The life cycle of the part and the whole is **independent**. That means if the whole object is destroyed, the part object can still exist.
- **Example**: A university has departments, but departments can exist without the university. If the university ceases to exist, departments may continue to exist on their own.

#### Example of Aggregation:
```java
class Department {
    String name;

    public Department(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return name;
    }
}

class University {
    private String name;
    private List<Department> departments;

    public University(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getUniversityName() {
        return name;
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mathematics");

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(d1);
        departmentList.add(d2);

        University university = new University("XYZ University", departmentList);

        System.out.println("University: " + university.getUniversityName());
        System.out.println("Departments:");
        for (Department dept : university.getDepartments()) {
            System.out.println(dept.getDepartmentName());
        }
    }
}
```

### Key Points of Aggregation:
1. **Independent existence**: The `Department` objects can exist without the `University` object.
2. **Weak relationship**: The university aggregates departments but doesn't necessarily "own" them in a strict sense.
3. **No strict life cycle dependency**: If the `University` object is destroyed, `Department` objects can still exist.

### 2. **Composition**:
- Composition is a **stronger form of association**.
- It represents a **"has-a" relationship** where the contained object (part) **cannot exist independently** of the container (whole).
- The life cycle of the part is strictly dependent on the whole. If the whole object is destroyed, the part object is also destroyed.
- **Example**: A house has rooms, and rooms cannot exist without the house. If the house is destroyed, the rooms are also destroyed.

#### Example of Composition:
```java
class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getRoomName() {
        return name;
    }
}

class House {
    private String address;
    private List<Room> rooms;

    public House(String address) {
        this.address = address;
        this.rooms = new ArrayList<>();
        this.rooms.add(new Room("Living Room"));
        this.rooms.add(new Room("Bedroom"));
        this.rooms.add(new Room("Kitchen"));
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        House house = new House("123 Main St");

        System.out.println("House Address: " + house.getAddress());
        System.out.println("Rooms:");
        for (Room room : house.getRooms()) {
            System.out.println(room.getRoomName());
        }
    }
}
```

### Key Points of Composition:
1. **Dependent existence**: The `Room` objects cannot exist without the `House` object.
2. **Strong relationship**: The `House` "owns" its `Room` objects completely, meaning the rooms' existence is tied to the house.
3. **Strict life cycle dependency**: If the `House` object is destroyed, its `Room` objects are also destroyed.

### Differences Between Aggregation and Composition:

| Feature           | Aggregation                          | Composition                      |
|-------------------|--------------------------------------|----------------------------------|
| **Relationship**   | Weaker "has-a" relationship          | Strong "has-a" relationship      |
| **Life cycle**     | Independent life cycle               | Dependent life cycle             |
| **Ownership**      | Part can exist independently of whole| Part cannot exist without whole  |
| **Example**        | University and Department            | House and Room                   |

### UML Representation:
- **Aggregation** is usually represented by a **hollow diamond** on the UML diagram, pointing to the container class.
- **Composition** is represented by a **filled diamond**, also pointing to the container class.

### Summary:
- **Aggregation** represents a weaker relationship, where the part can exist independently of the whole.
- **Composition** represents a stronger relationship, where the part cannot exist independently of the whole.
