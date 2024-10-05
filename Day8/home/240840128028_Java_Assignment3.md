## Assignment 3
##### Date : 4th Oct, 2024
    Rajesh Singh
    PR No: 240-840-128-028


### Part 1
```text
For a Toy manufacturing company, create an app to perform basic operations on the stock

The Toy data has
    a. product id
    b. name
    c. price
    d. category
    e. age [to present age appropriate toys]
    f. purachase month, year

1. List the Stock
2. Filter the stock by category [e.g. Educational / Battery operated etc]
3. List Toys by price range (e.g. between 500 to 1000)
4. Sort the toys by price category wise
5. Make the list of old stock [older than 1 year]
6. Make a group of toys as per their category, count them
7. Display the most expensive/least expensive toy in given category
8. Print total no of toys in stock for each age grp
```

#### Class - Date
```java
package Day8.home.first;

import java.util.Comparator;

public class Date implements Comparable{
    private int year;
    private int month;

    public Date(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return year + "/" + month;
    }

    @Override
    public int compareTo(Object o) {
        Date date = (Date) o;
        if (this.year == date.getYear()) {
            return this.month - date.getMonth();
        } else {
            return this.year - date.getYear();
        }
    }
}


class DateComparator implements Comparator<Date> {
    @Override
    public int compare(Date o1, Date o2) {
        if (o1.getYear() == o2.getYear()) {
            return o1.getMonth() - o2.getMonth();
        } else {
            return o1.getYear() - o2.getYear();
        }
    }
}
```

#### Enum - Category
```java
package Day8.home.first;

public enum Category {
    EDUCATIONAL("Educational"),
    GAMES("Games"),
    HOME("Home"),
    BATTERYOPERATED("Battery Operated");

    String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
```

#### Class - Toy
```java
package Day8.home.first;

import java.util.Comparator;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int price;
    private Category category;
    private int age;
    private Date date;

    public Toy(int id, String name, int price, Category category, int age, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.age = age;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", age=" + age +
                ", date=" + date ;
    }

    @Override
    public int compareTo(Toy o) {
        return this.id - o.getId();
    }
}

class ToyIdComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getId() - o2.getId();
    }
}

class ToyNameComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

class ToyPriceComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getPrice() - o2.getPrice();
    }
}

class ToyCategoryComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getCategory().getCategory().compareToIgnoreCase(o2.getCategory().getCategory());
    }
}

class ToyAgeComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getAge() - o2.getAge();
    }
}
```

#### Class - Inventory
```java
package Day8.home.first;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory {

    public static <T> HashMap<T, Integer> addElement(HashMap<T, Integer> inventoryMap, HashMap<T, Integer> newToys) {
        for (T toy : newToys.keySet()) {
            if (inventoryMap.containsKey(toy)) {
                inventoryMap.put(toy, inventoryMap.get(toy) + newToys.get(toy));
            } else {
                inventoryMap.put(toy, newToys.get(toy));
            }
        }
        System.out.println("\n" + newToys.keySet().size() + " Items added successfully to inventory");
        return inventoryMap;
    }

    public static <T> HashMap<T, Integer> reduceQuantity(HashMap<T, Integer> inventoryMap, T element, Integer quantity) {
        if (inventoryMap.containsKey(element) && inventoryMap.get(element) >= quantity) {
            inventoryMap.put(element, inventoryMap.get(element) - quantity);
        } else {
            System.out.println("\nNot enough quantity for the toy");
            inventoryMap.put(element, 0);
        }
        return inventoryMap;
    }

    public static <T> HashMap<T, Integer> removeElement(HashMap<T, Integer> inventoryMap, T element) {
        Stream<Map.Entry<T, Integer>> stream = inventoryMap.entrySet().stream();
        Map<T, Integer> filteredMap = stream.filter(
                e -> !e.getKey().equals(element)).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
        );
        inventoryMap.clear();
        inventoryMap.putAll(filteredMap);
        return inventoryMap;
    }

    public static <T> void displayInventory(HashMap<T, Integer> inventoryMap) {
        Stream<Map.Entry<T, Integer>> stream = inventoryMap.entrySet().stream();
        stream.forEach(e -> System.out.println(e.getKey() + " | Quantity: " + e.getValue()));
    }

    public static <T> int getTotalQuantityCount(HashMap<T, Integer> inventoryMap) {
        return inventoryMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static <T> int getTotalElementCount(Map<T, Integer> inventoryMap) {
        return inventoryMap.size();
    }

    public static <T, C> HashMap<T, Integer> filterInventoryByCategory(HashMap<T, Integer> inventoryMap, C category, Function<T, C> categoryExtractor) {
        Stream<Map.Entry<T, Integer>> stream = inventoryMap.entrySet().stream();
        Map<T, Integer> filteredMap = stream.filter(
                e -> categoryExtractor.apply(e.getKey()).equals(category)
        ).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
        );
        return new HashMap<>(filteredMap);
    }


    public static <T> HashMap<T, Integer> filterInventoryByPriceRange(HashMap<T, Integer> inventoryMap, Integer minPrice, Integer maxPrice, Function<T, Integer> priceExtractor) {
        Stream<Map.Entry<T, Integer>> stream = inventoryMap.entrySet().stream();
        HashMap<T, Integer> filteredMap = stream.filter(entry -> {
                    Integer price = priceExtractor.apply(entry.getKey());
                    return price >= minPrice && price <= maxPrice;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));
        return new HashMap<>(filteredMap);
    }

    public static <T> T searchInventoryByIdUsingBinarySearch(HashMap<T, Integer> inventoryMap, int id, Function<T, Integer> idExtractor) {
        Stream<T> stream = inventoryMap.keySet().stream();
        return stream.sorted(Comparator.comparing(idExtractor)).filter(t -> idExtractor.apply(t) == id).findFirst().orElse(null);
    }

    public static <T, E> HashMap<T, Integer> searchBySpecificField(HashMap<T, Integer> inventoryMap, E field, Function<T, E> fieldExtractor) {
        Stream<T> stream = inventoryMap.keySet().stream();
        HashMap<T, Integer> filteredMap = stream.filter(
                        t -> fieldExtractor.apply(t).equals(field)).
                collect(Collectors.toMap(Function.identity(), inventoryMap::get, (a, b) -> a, HashMap::new)
                );
        return new HashMap<>(filteredMap);
    }

    public static <T> LinkedHashMap<T, Integer> sortBySpecificField(HashMap<T, Integer> inventoryMap, Comparator<T> comparator) {
        Stream<T> stream = inventoryMap.keySet().stream();
        LinkedHashMap<T, Integer> sortedMap = stream.sorted(comparator)
                .collect(Collectors.toMap(Function.identity(), inventoryMap::get, (a, b) -> a, LinkedHashMap::new)
                );

        return sortedMap;
    }


    public static <T, E> Map<E, HashMap<T, Integer>> groupBySpecificField(HashMap<T, Integer> inventoryMap, Function<T, E> fieldExtractor) {
        Stream<Map.Entry<T, Integer>> stream = inventoryMap.entrySet().stream();
        Map<E, List<Map.Entry<T, Integer>>> groupedMap = stream.collect(Collectors.groupingBy(entry -> fieldExtractor.apply(entry.getKey())));

        Map<E, HashMap<T, Integer>> groupeMapAnswer = new HashMap<>();
        for (Map.Entry<E, List<Map.Entry<T, Integer>>> entry : groupedMap.entrySet()) {
            groupeMapAnswer.put(entry.getKey(), entry.getValue().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new)));
        }

        return groupeMapAnswer;
    }

    public static <T, D> HashMap<T, Integer> getInventoryByDate(HashMap<T, Integer> inventoryMap, D date, Function<T, D> dateExtractor, Comparator<D> comparator) {
        Stream<Map.Entry<T, Integer>> stream = inventoryMap.entrySet().stream();
        Map<T, Integer> filteredMap = stream.filter(entry -> {
                    D toyDate = dateExtractor.apply(entry.getKey());
                    return comparator.compare(toyDate, date) < 0;
                }
        ).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
        );
        return new HashMap<>(filteredMap);
    }

    public static <T> T getMaxElement(Map<T, Integer> inventoryMap, Comparator<T> comparator) {
        return inventoryMap.keySet().stream().max(comparator).get();
    }

    public static <T> T getMinElement(Map<T, Integer> inventoryMap, Comparator<T> comparator) {
        return inventoryMap.keySet().stream().min(comparator).get();
    }
}

```

#### Class - Store
```java
package Day8.home.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Store {

    public static HashMap<Toy, Integer> intializeInventoryMap() {
        HashMap<Toy, Integer> inventoryMap = new HashMap<>();
        Random random = new Random();

        HashMap<Toy, Integer> newToys = new HashMap<>();
        int totalToys = 15;
        for (int i = 1; i <= totalToys; i++) {
            int year = 2015 + random.nextInt(5);
            int month = 1 + random.nextInt(12);
            int catIndex = random.nextInt(Category.values().length);
            Category cat = Category.values()[catIndex];
            int randomPrice = 50 + random.nextInt(50);
            int randomAge = 1 + random.nextInt(5);
            Toy t = new Toy(i, "Toy-" + i, randomPrice, cat, randomAge, new Date(year, month));
            int randomToyCount = 1 + random.nextInt(5);
            newToys.put(t, randomToyCount);
        }
        return newToys;
    }

    public static void main(String[] args) {

        Toy temp = null;
        HashMap<Toy, Integer> inventoryMap = new HashMap<>();
        Inventory.addElement(inventoryMap, intializeInventoryMap());

        // Selecting Ranodm Date
        temp = Inventory.searchInventoryByIdUsingBinarySearch(inventoryMap, 5, Toy::getId);


        System.out.println("\nInventory Map");
        Inventory.displayInventory(inventoryMap);


        System.out.println("\nRemoving " + temp);
        Inventory.removeElement(inventoryMap, temp);


        System.out.println("\nInventory Map after removing " + temp.getName());
        Inventory.displayInventory(inventoryMap);

        HashMap<Toy, Integer> filteredMap = Inventory.filterInventoryByCategory(inventoryMap, Category.HOME, Toy::getCategory);
        System.out.println("\nFiltered Inventory Map");
        Inventory.displayInventory(filteredMap);

        HashMap<Toy, Integer> filteredMap2 = Inventory.filterInventoryByPriceRange(inventoryMap, 50, 60, Toy::getPrice);
        System.out.println("\nFiltered Inventory Map (Price Range: 50-60):");
        Inventory.displayInventory(filteredMap2);

        Toy toy = Inventory.searchInventoryByIdUsingBinarySearch(inventoryMap, 6, Toy::getId);
        System.out.println("\nToy with id: " + toy.getId() + "\n" + toy);

        // Search by specific field - age
        HashMap<Toy, Integer> filteredMap3 = Inventory.searchBySpecificField(inventoryMap, 3, Toy::getAge);
        System.out.println("\nFiltered Inventory Map (Age: 3):");
        Inventory.displayInventory(filteredMap3);

        // Sort by specific field - ToyPriceComparator
        HashMap<Toy, Integer> sortedPriceMap = Inventory.sortBySpecificField(inventoryMap, new ToyPriceComparator());
        System.out.println("\nSorted Inventory Map by Price");
        Inventory.displayInventory(sortedPriceMap);


        // Inventorty whichsi older than one year
        Date oneyearold = new Date(2018, 12);
        HashMap<Toy, Integer> oldfilteredMap = Inventory.getInventoryByDate(inventoryMap, oneyearold, Toy::getDate, new DateComparator());
        System.out.println("\nInventory which is older than one year");
        Inventory.displayInventory(oldfilteredMap);


        // Group by category
        Map<Category, HashMap<Toy, Integer>> groupByCategory = Inventory.groupBySpecificField(inventoryMap,  Toy::getCategory);

        // Group by specific field by category then Sorting each category by price using ToyPriceComparator class
        for (Map.Entry<Category, HashMap<Toy, Integer>> entry : groupByCategory.entrySet()) {
            System.out.println("\n" + entry.getKey());
            Inventory.displayInventory(Inventory.sortBySpecificField(entry.getValue(), new ToyPriceComparator()));
        }


        // Group by specific field by category and count them
        System.out.println("\nGrouped by Category and Counting");
        for (Map.Entry<Category, HashMap<Toy, Integer>> entry : groupByCategory.entrySet()) {
            System.out.println("Category : " + entry.getKey() +
                    " | No. of Toys: " + Inventory.getTotalElementCount(entry.getValue()) +
                    " | Stocks : " + Inventory.getTotalQuantityCount(entry.getValue()));
        }

        //  Display the most expensive/least expensive toy in given category
        System.out.println("\nDisplay the most expensive/least expensive toy in given category");
        for (Map.Entry<Category, HashMap<Toy, Integer>> entry : groupByCategory.entrySet()) {
            System.out.println("Category -> " + entry.getKey() +
                    "\nMax Element: " + Inventory.getMaxElement(entry.getValue(), new ToyPriceComparator())
                    + "\nMin Element: " + Inventory.getMinElement(entry.getValue(), new ToyPriceComparator())
            );
        }

        // Print total no of toys in stock for each age grp
        Map<Integer, HashMap<Toy, Integer>> grouoByAge = Inventory.groupBySpecificField(inventoryMap, Toy::getAge);
        System.out.println("\nGrouped by Age Group and Counting");
        for (Map.Entry<Integer, HashMap<Toy, Integer>> entry : grouoByAge.entrySet()) {
            System.out.println("Age Group : " + entry.getKey() +
                    " | No. of Toys: " + Inventory.getTotalElementCount(entry.getValue()) +
                    " | Stocks : " + Inventory.getTotalQuantityCount(entry.getValue())
            );
        }
    }
}

```

#### Output
```shell
15 Items added successfully to inventory

Inventory Map
id=3, name='Toy-3', price=75, category=EDUCATIONAL, age=5, date=2016/6 | Quantity: 4
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11 | Quantity: 2
id=11, name='Toy-11', price=57, category=EDUCATIONAL, age=1, date=2019/4 | Quantity: 4
id=8, name='Toy-8', price=82, category=GAMES, age=2, date=2016/9 | Quantity: 4
id=1, name='Toy-1', price=72, category=EDUCATIONAL, age=4, date=2019/5 | Quantity: 1
id=5, name='Toy-5', price=58, category=HOME, age=3, date=2017/9 | Quantity: 3
id=2, name='Toy-2', price=91, category=BATTERYOPERATED, age=1, date=2016/2 | Quantity: 5
id=12, name='Toy-12', price=85, category=EDUCATIONAL, age=5, date=2018/2 | Quantity: 3
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=7, name='Toy-7', price=87, category=GAMES, age=3, date=2019/4 | Quantity: 4
id=10, name='Toy-10', price=77, category=EDUCATIONAL, age=4, date=2016/1 | Quantity: 5
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=9, name='Toy-9', price=68, category=BATTERYOPERATED, age=4, date=2017/2 | Quantity: 4
id=14, name='Toy-14', price=76, category=GAMES, age=2, date=2017/9 | Quantity: 4

Removing id=5, name='Toy-5', price=58, category=HOME, age=3, date=2017/9

Inventory Map after removing Toy-5
id=3, name='Toy-3', price=75, category=EDUCATIONAL, age=5, date=2016/6 | Quantity: 4
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11 | Quantity: 2
id=11, name='Toy-11', price=57, category=EDUCATIONAL, age=1, date=2019/4 | Quantity: 4
id=8, name='Toy-8', price=82, category=GAMES, age=2, date=2016/9 | Quantity: 4
id=1, name='Toy-1', price=72, category=EDUCATIONAL, age=4, date=2019/5 | Quantity: 1
id=2, name='Toy-2', price=91, category=BATTERYOPERATED, age=1, date=2016/2 | Quantity: 5
id=12, name='Toy-12', price=85, category=EDUCATIONAL, age=5, date=2018/2 | Quantity: 3
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=7, name='Toy-7', price=87, category=GAMES, age=3, date=2019/4 | Quantity: 4
id=10, name='Toy-10', price=77, category=EDUCATIONAL, age=4, date=2016/1 | Quantity: 5
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=9, name='Toy-9', price=68, category=BATTERYOPERATED, age=4, date=2017/2 | Quantity: 4
id=14, name='Toy-14', price=76, category=GAMES, age=2, date=2017/9 | Quantity: 4

Filtered Inventory Map
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11 | Quantity: 2
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2

Filtered Inventory Map (Price Range: 50-60):
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=11, name='Toy-11', price=57, category=EDUCATIONAL, age=1, date=2019/4 | Quantity: 4

Toy with id: 6
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11

Filtered Inventory Map (Age: 3):
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=7, name='Toy-7', price=87, category=GAMES, age=3, date=2019/4 | Quantity: 4
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2

Sorted Inventory Map by Price
id=11, name='Toy-11', price=57, category=EDUCATIONAL, age=1, date=2019/4 | Quantity: 4
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=9, name='Toy-9', price=68, category=BATTERYOPERATED, age=4, date=2017/2 | Quantity: 4
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2
id=1, name='Toy-1', price=72, category=EDUCATIONAL, age=4, date=2019/5 | Quantity: 1
id=3, name='Toy-3', price=75, category=EDUCATIONAL, age=5, date=2016/6 | Quantity: 4
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=14, name='Toy-14', price=76, category=GAMES, age=2, date=2017/9 | Quantity: 4
id=10, name='Toy-10', price=77, category=EDUCATIONAL, age=4, date=2016/1 | Quantity: 5
id=8, name='Toy-8', price=82, category=GAMES, age=2, date=2016/9 | Quantity: 4
id=12, name='Toy-12', price=85, category=EDUCATIONAL, age=5, date=2018/2 | Quantity: 3
id=7, name='Toy-7', price=87, category=GAMES, age=3, date=2019/4 | Quantity: 4
id=2, name='Toy-2', price=91, category=BATTERYOPERATED, age=1, date=2016/2 | Quantity: 5
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11 | Quantity: 2

Inventory which is older than one year
id=12, name='Toy-12', price=85, category=EDUCATIONAL, age=5, date=2018/2 | Quantity: 3
id=3, name='Toy-3', price=75, category=EDUCATIONAL, age=5, date=2016/6 | Quantity: 4
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11 | Quantity: 2
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=10, name='Toy-10', price=77, category=EDUCATIONAL, age=4, date=2016/1 | Quantity: 5
id=8, name='Toy-8', price=82, category=GAMES, age=2, date=2016/9 | Quantity: 4
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=9, name='Toy-9', price=68, category=BATTERYOPERATED, age=4, date=2017/2 | Quantity: 4
id=2, name='Toy-2', price=91, category=BATTERYOPERATED, age=1, date=2016/2 | Quantity: 5
id=14, name='Toy-14', price=76, category=GAMES, age=2, date=2017/9 | Quantity: 4

EDUCATIONAL
id=11, name='Toy-11', price=57, category=EDUCATIONAL, age=1, date=2019/4 | Quantity: 4
id=1, name='Toy-1', price=72, category=EDUCATIONAL, age=4, date=2019/5 | Quantity: 1
id=3, name='Toy-3', price=75, category=EDUCATIONAL, age=5, date=2016/6 | Quantity: 4
id=10, name='Toy-10', price=77, category=EDUCATIONAL, age=4, date=2016/1 | Quantity: 5
id=12, name='Toy-12', price=85, category=EDUCATIONAL, age=5, date=2018/2 | Quantity: 3

GAMES
id=14, name='Toy-14', price=76, category=GAMES, age=2, date=2017/9 | Quantity: 4
id=8, name='Toy-8', price=82, category=GAMES, age=2, date=2016/9 | Quantity: 4
id=7, name='Toy-7', price=87, category=GAMES, age=3, date=2019/4 | Quantity: 4

BATTERYOPERATED
id=9, name='Toy-9', price=68, category=BATTERYOPERATED, age=4, date=2017/2 | Quantity: 4
id=2, name='Toy-2', price=91, category=BATTERYOPERATED, age=1, date=2016/2 | Quantity: 5

HOME
id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6 | Quantity: 5
id=13, name='Toy-13', price=69, category=HOME, age=3, date=2015/7 | Quantity: 2
id=15, name='Toy-15', price=76, category=HOME, age=3, date=2016/3 | Quantity: 5
id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11 | Quantity: 2

Grouped by Category and Counting
Category : EDUCATIONAL | No. of Toys: 5 | Stocks : 17
Category : GAMES | No. of Toys: 3 | Stocks : 12
Category : BATTERYOPERATED | No. of Toys: 2 | Stocks : 9
Category : HOME | No. of Toys: 4 | Stocks : 14

Display the most expensive/least expensive toy in given category
Category -> EDUCATIONAL
Max Element: id=12, name='Toy-12', price=85, category=EDUCATIONAL, age=5, date=2018/2
Min Element: id=11, name='Toy-11', price=57, category=EDUCATIONAL, age=1, date=2019/4
Category -> GAMES
Max Element: id=7, name='Toy-7', price=87, category=GAMES, age=3, date=2019/4
Min Element: id=14, name='Toy-14', price=76, category=GAMES, age=2, date=2017/9
Category -> BATTERYOPERATED
Max Element: id=2, name='Toy-2', price=91, category=BATTERYOPERATED, age=1, date=2016/2
Min Element: id=9, name='Toy-9', price=68, category=BATTERYOPERATED, age=4, date=2017/2
Category -> HOME
Max Element: id=6, name='Toy-6', price=98, category=HOME, age=4, date=2016/11
Min Element: id=4, name='Toy-4', price=57, category=HOME, age=3, date=2015/6

Grouped by Age Group and Counting
Age Group : 1 | No. of Toys: 2 | Stocks : 9
Age Group : 2 | No. of Toys: 2 | Stocks : 8
Age Group : 3 | No. of Toys: 4 | Stocks : 16
Age Group : 4 | No. of Toys: 4 | Stocks : 12
Age Group : 5 | No. of Toys: 2 | Stocks : 7

Process finished with exit code 0
```


---

### Part 2
```text
Perfors following operations for a tweeter website

A tweet should have
    a. subject
    b. date of post
    c. no of views

d. Set of hashtags (one tweet can have many hashtags e.g. #puneralns, #flood, Panatherupdate)
1. List all the tweets that are posted in current month
2. List all the tweets for a hashtag
3. Count the tweets by Subject
5. List the tweets that got more than 10k views
6. Print the top 5 trending tweets
``` 

#### Class - Tweet
```java
package Day8.home.second;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Tweet {
    String subject;
    String body;
    LocalDateTime date;
    int views;
    HashSet<String> hashtags;

    public Tweet(String subject, String body, LocalDateTime date, int views, HashSet<String> hashtags) {
        this.subject = subject;
        this.body = body;
        this.date = date;
        this.views = views;
        this.hashtags = hashtags;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public HashSet<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(HashSet<String> hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                ", views=" + views +
                ", hashtags=" + hashtags +
                '}';
    }
}
```

#### Class - Tweeter
```java
package Day8.home.second;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

public class Tweeter {


    public static LocalDateTime generateRandomDateTime() {
        // Generate date range between 5 years ago and now
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveYearsAgo = now.minus(5, ChronoUnit.YEARS);
        long startEpoch = fiveYearsAgo.toEpochSecond(ZoneOffset.UTC);
        long endEpoch = now.toEpochSecond(ZoneOffset.UTC);
        long randomEpoch = ThreadLocalRandom.current().nextLong(startEpoch, endEpoch);
        return LocalDateTime.ofEpochSecond(randomEpoch, 0, ZoneOffset.UTC);
    }

    public static HashSet<String> getHashtags(int numOfHashtags) {
        Random random = new Random();
        HashSet<String> hashtags = new HashSet<>();
        for (int i = 0; i < numOfHashtags; i++) {
            hashtags.add("#Hashtag-" + random.nextInt(20));
        }
        return hashtags;
    }

    public static Tweet getTweet() {
        Random random = new Random();
        String subject = "Tweet-" + random.nextInt(100);
        String body = "Tweet body-" + random.nextInt(100);
        LocalDateTime date =  generateRandomDateTime();
        int views = random.nextInt(12000);
        HashSet<String> hashtags = getHashtags(1 + random.nextInt(5));
        return new Tweet(subject, body, date, views, hashtags);
    }

    public static ArrayList<Tweet> getTweets(int numOfTweets) {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < numOfTweets; i++) {
            tweets.add(getTweet());
        }
        return tweets;
    }


    public static ArrayList<Tweet> getTweetsBySubject(ArrayList<Tweet> tweets, String subject) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getSubject().equals(subject)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByHashtag(ArrayList<Tweet> tweets, String hashtag) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getHashtags().contains(hashtag)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByViews(ArrayList<Tweet> tweets, int views) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getViews() > views).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByDate(ArrayList<Tweet> tweets, LocalDateTime date) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getDate().isAfter(date)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByDateRange(ArrayList<Tweet> tweets, LocalDateTime fromDate, LocalDateTime toDate) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getDate().isAfter(fromDate) && tweet.getDate().isBefore(toDate)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTrendingTweets(ArrayList<Tweet> tweets) {
        ArrayList<Tweet> recentOneMonthTweets = getTweetsByDateRange(tweets, LocalDateTime.now().minusMonths(1), LocalDateTime.now());
        Stream<Tweet> stream = recentOneMonthTweets.stream();
        return stream.sorted((t1, t2) -> Integer.compare(t2.getViews(), t1.getViews())).limit(5).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void printTweets(ArrayList<Tweet> tweets) {
        tweets.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<Tweet> tweets = getTweets(200);

        printTweets(tweets);

        // 3. Count the tweets by Subject
        System.out.println("\nTweets by Subject");
        ArrayList<Tweet> tweetsBySubject = getTweetsBySubject(tweets, "Tweet-1");
        printTweets(tweetsBySubject);

        // 2. List all the tweets for a hashtag
        System.out.println("\nTweets by Hashtag");
        ArrayList<Tweet> tweetsByHashtag = getTweetsByHashtag(tweets, "#Hashtag-1");
        printTweets(tweetsByHashtag);

        // 5. List the tweets that got more than 10k views
        System.out.println("\nTweets by Views");
        ArrayList<Tweet> tweetsByViews = getTweetsByViews(tweets, 10000);
        printTweets(tweetsByViews);

        // 1. List all the tweets that are posted in current month
        System.out.println("\nTweets of Current Month");
        ArrayList<Tweet> tweetsByDate = getTweetsByDate(tweets,
                LocalDateTime.now().minusDays(LocalDateTime.now().getDayOfMonth()));
        printTweets(tweetsByDate);

        // 6. Print the top 5 trending tweets
        System.out.println("\nTrending Tweets");
        ArrayList<Tweet> trendingTweets = getTrendingTweets(tweets);
        printTweets(trendingTweets);


    }
}
```

#### Output
```shell
Tweet{subject='Tweet-27', body='Tweet body-67', date=2021-01-16T21:08:08, views=10644, hashtags=[#Hashtag-7, #Hashtag-17, #Hashtag-19]}
Tweet{subject='Tweet-70', body='Tweet body-6', date=2024-01-04T01:04:26, views=8375, hashtags=[#Hashtag-5, #Hashtag-11, #Hashtag-12, #Hashtag-3]}
Tweet{subject='Tweet-4', body='Tweet body-59', date=2022-09-30T02:00:45, views=2105, hashtags=[#Hashtag-8, #Hashtag-12, #Hashtag-16, #Hashtag-1, #Hashtag-19]}
Tweet{subject='Tweet-34', body='Tweet body-91', date=2020-05-03T14:02:39, views=2332, hashtags=[#Hashtag-14, #Hashtag-12, #Hashtag-0]}
Tweet{subject='Tweet-33', body='Tweet body-60', date=2021-03-02T16:27:04, views=6993, hashtags=[#Hashtag-12, #Hashtag-19]}
Tweet{subject='Tweet-51', body='Tweet body-59', date=2023-04-07T17:08:25, views=2274, hashtags=[#Hashtag-10, #Hashtag-8, #Hashtag-2]}
Tweet{subject='Tweet-88', body='Tweet body-33', date=2022-01-24T18:04:07, views=5797, hashtags=[#Hashtag-13, #Hashtag-9, #Hashtag-17, #Hashtag-15]}
Tweet{subject='Tweet-86', body='Tweet body-34', date=2021-10-25T07:04:04, views=4109, hashtags=[#Hashtag-1]}
Tweet{subject='Tweet-35', body='Tweet body-40', date=2023-04-05T12:46:04, views=6652, hashtags=[#Hashtag-6, #Hashtag-8, #Hashtag-2]}
Tweet{subject='Tweet-53', body='Tweet body-79', date=2024-07-03T15:09:18, views=11849, hashtags=[#Hashtag-10, #Hashtag-5, #Hashtag-17, #Hashtag-16, #Hashtag-19]}
Tweet{subject='Tweet-57', body='Tweet body-82', date=2024-05-20T08:04:05, views=3302, hashtags=[#Hashtag-4, #Hashtag-0, #Hashtag-1]}
Tweet{subject='Tweet-97', body='Tweet body-42', date=2021-07-06T17:58:24, views=10470, hashtags=[#Hashtag-12, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-36', body='Tweet body-21', date=2023-04-22T17:14:01, views=10230, hashtags=[#Hashtag-4, #Hashtag-12, #Hashtag-15]}
Tweet{subject='Tweet-32', body='Tweet body-65', date=2023-08-04T19:50:41, views=8074, hashtags=[#Hashtag-3]}
Tweet{subject='Tweet-79', body='Tweet body-44', date=2022-12-01T15:31:42, views=7544, hashtags=[#Hashtag-8, #Hashtag-0, #Hashtag-1, #Hashtag-3]}
Tweet{subject='Tweet-88', body='Tweet body-45', date=2024-07-09T03:14:55, views=7665, hashtags=[#Hashtag-6, #Hashtag-11, #Hashtag-16]}
Tweet{subject='Tweet-49', body='Tweet body-60', date=2023-10-06T18:53:59, views=5454, hashtags=[#Hashtag-15, #Hashtag-1]}
Tweet{subject='Tweet-80', body='Tweet body-57', date=2023-09-12T11:02:57, views=8523, hashtags=[#Hashtag-7, #Hashtag-14, #Hashtag-1]}
Tweet{subject='Tweet-37', body='Tweet body-62', date=2021-07-09T22:17:44, views=4192, hashtags=[#Hashtag-4]}
Tweet{subject='Tweet-3', body='Tweet body-14', date=2023-06-12T23:19:59, views=1744, hashtags=[#Hashtag-11]}
Tweet{subject='Tweet-15', body='Tweet body-11', date=2022-09-03T14:12:07, views=9985, hashtags=[#Hashtag-10, #Hashtag-13, #Hashtag-11]}
Tweet{subject='Tweet-72', body='Tweet body-4', date=2022-11-07T13:55, views=2556, hashtags=[#Hashtag-6, #Hashtag-8, #Hashtag-15]}
Tweet{subject='Tweet-38', body='Tweet body-65', date=2022-08-23T11:18:34, views=2081, hashtags=[#Hashtag-4, #Hashtag-10, #Hashtag-14, #Hashtag-16]}
Tweet{subject='Tweet-1', body='Tweet body-32', date=2022-06-18T22:51:04, views=9968, hashtags=[#Hashtag-6, #Hashtag-8, #Hashtag-15]}
Tweet{subject='Tweet-41', body='Tweet body-98', date=2021-11-19T14:50:25, views=10180, hashtags=[#Hashtag-2]}
Tweet{subject='Tweet-57', body='Tweet body-60', date=2024-08-15T00:21:01, views=8984, hashtags=[#Hashtag-8, #Hashtag-18, #Hashtag-16]}
Tweet{subject='Tweet-39', body='Tweet body-53', date=2024-03-30T17:16:32, views=653, hashtags=[#Hashtag-10, #Hashtag-12, #Hashtag-15]}
Tweet{subject='Tweet-85', body='Tweet body-73', date=2022-03-11T21:13:07, views=9864, hashtags=[#Hashtag-15, #Hashtag-16]}
Tweet{subject='Tweet-78', body='Tweet body-18', date=2022-06-09T21:26:54, views=11707, hashtags=[#Hashtag-10, #Hashtag-7]}
Tweet{subject='Tweet-14', body='Tweet body-58', date=2024-02-27T01:50:49, views=5547, hashtags=[#Hashtag-14, #Hashtag-12, #Hashtag-16]}
Tweet{subject='Tweet-33', body='Tweet body-31', date=2024-03-09T16:45:01, views=9603, hashtags=[#Hashtag-16, #Hashtag-0, #Hashtag-2, #Hashtag-3]}
Tweet{subject='Tweet-35', body='Tweet body-31', date=2019-10-11T06:33:39, views=2609, hashtags=[#Hashtag-13]}
Tweet{subject='Tweet-61', body='Tweet body-43', date=2020-03-07T18:29:38, views=9880, hashtags=[#Hashtag-4, #Hashtag-11, #Hashtag-0]}
Tweet{subject='Tweet-59', body='Tweet body-38', date=2021-01-10T22:44:56, views=8646, hashtags=[#Hashtag-11, #Hashtag-3]}
Tweet{subject='Tweet-82', body='Tweet body-39', date=2021-05-20T09:30:45, views=10318, hashtags=[#Hashtag-14, #Hashtag-11]}
Tweet{subject='Tweet-12', body='Tweet body-42', date=2023-01-20T21:45:11, views=8789, hashtags=[#Hashtag-5, #Hashtag-1]}
Tweet{subject='Tweet-6', body='Tweet body-70', date=2022-06-07T17:40:05, views=9978, hashtags=[#Hashtag-6, #Hashtag-13, #Hashtag-11, #Hashtag-12, #Hashtag-16]}
Tweet{subject='Tweet-87', body='Tweet body-33', date=2020-09-22T13:07:18, views=10556, hashtags=[#Hashtag-6, #Hashtag-17, #Hashtag-0, #Hashtag-19]}
Tweet{subject='Tweet-87', body='Tweet body-54', date=2023-01-25T12:10:26, views=4348, hashtags=[#Hashtag-6, #Hashtag-12]}
Tweet{subject='Tweet-20', body='Tweet body-84', date=2024-06-06T13:57:15, views=5055, hashtags=[#Hashtag-17, #Hashtag-2]}
Tweet{subject='Tweet-40', body='Tweet body-84', date=2021-05-05T15:48:58, views=10899, hashtags=[#Hashtag-10, #Hashtag-9]}
Tweet{subject='Tweet-45', body='Tweet body-85', date=2020-06-05T06:21:41, views=11178, hashtags=[#Hashtag-5, #Hashtag-11, #Hashtag-16]}
Tweet{subject='Tweet-88', body='Tweet body-15', date=2023-07-29T16:52:59, views=349, hashtags=[#Hashtag-6, #Hashtag-14, #Hashtag-11, #Hashtag-3]}
Tweet{subject='Tweet-97', body='Tweet body-44', date=2023-12-18T00:16:09, views=7422, hashtags=[#Hashtag-9, #Hashtag-17, #Hashtag-16, #Hashtag-2]}
Tweet{subject='Tweet-7', body='Tweet body-31', date=2024-07-26T03:28:45, views=4998, hashtags=[#Hashtag-12, #Hashtag-2]}
Tweet{subject='Tweet-92', body='Tweet body-69', date=2020-11-27T10:33:28, views=11942, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-13', body='Tweet body-37', date=2021-04-05T05:54:19, views=4158, hashtags=[#Hashtag-5, #Hashtag-7, #Hashtag-14, #Hashtag-11, #Hashtag-18]}
Tweet{subject='Tweet-83', body='Tweet body-18', date=2021-01-30T18:01:15, views=8789, hashtags=[#Hashtag-8, #Hashtag-14, #Hashtag-15, #Hashtag-16, #Hashtag-19]}
Tweet{subject='Tweet-37', body='Tweet body-73', date=2024-03-10T05:36:48, views=5256, hashtags=[#Hashtag-8, #Hashtag-9, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-87', body='Tweet body-62', date=2022-01-03T18:23:50, views=1327, hashtags=[#Hashtag-10, #Hashtag-8, #Hashtag-19]}
Tweet{subject='Tweet-69', body='Tweet body-22', date=2021-02-20T01:29:11, views=1565, hashtags=[#Hashtag-8, #Hashtag-17, #Hashtag-3]}
Tweet{subject='Tweet-31', body='Tweet body-25', date=2024-09-16T20:28:04, views=9867, hashtags=[#Hashtag-17, #Hashtag-2]}
Tweet{subject='Tweet-15', body='Tweet body-4', date=2020-07-12T11:00:25, views=2610, hashtags=[#Hashtag-12]}
Tweet{subject='Tweet-73', body='Tweet body-5', date=2021-07-17T14:55:01, views=7548, hashtags=[#Hashtag-5, #Hashtag-10, #Hashtag-18]}
Tweet{subject='Tweet-28', body='Tweet body-64', date=2023-03-19T12:10:33, views=7000, hashtags=[#Hashtag-13, #Hashtag-17, #Hashtag-3]}
Tweet{subject='Tweet-47', body='Tweet body-44', date=2022-11-01T17:36:50, views=7082, hashtags=[#Hashtag-4, #Hashtag-16, #Hashtag-0, #Hashtag-2]}
Tweet{subject='Tweet-36', body='Tweet body-74', date=2020-10-03T09:08:17, views=6582, hashtags=[#Hashtag-10, #Hashtag-12, #Hashtag-2]}
Tweet{subject='Tweet-7', body='Tweet body-50', date=2020-11-24T15:31:10, views=10198, hashtags=[#Hashtag-12, #Hashtag-18]}
Tweet{subject='Tweet-73', body='Tweet body-3', date=2021-09-24T08:54:33, views=373, hashtags=[#Hashtag-14, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-52', body='Tweet body-52', date=2024-06-12T17:18:02, views=11176, hashtags=[#Hashtag-13, #Hashtag-11, #Hashtag-12, #Hashtag-1]}
Tweet{subject='Tweet-20', body='Tweet body-3', date=2022-10-14T16:13:55, views=4647, hashtags=[#Hashtag-4, #Hashtag-11, #Hashtag-1]}
Tweet{subject='Tweet-63', body='Tweet body-23', date=2022-07-30T02:52:56, views=3599, hashtags=[#Hashtag-4, #Hashtag-6, #Hashtag-7]}
Tweet{subject='Tweet-44', body='Tweet body-97', date=2019-10-16T06:49:05, views=1530, hashtags=[#Hashtag-6, #Hashtag-18, #Hashtag-0]}
Tweet{subject='Tweet-44', body='Tweet body-4', date=2020-09-17T01:00:56, views=11479, hashtags=[#Hashtag-8]}
Tweet{subject='Tweet-19', body='Tweet body-94', date=2024-05-18T13:48:06, views=9494, hashtags=[#Hashtag-4, #Hashtag-18, #Hashtag-2]}
Tweet{subject='Tweet-22', body='Tweet body-79', date=2022-01-15T05:24:02, views=6538, hashtags=[#Hashtag-16, #Hashtag-1]}
Tweet{subject='Tweet-72', body='Tweet body-63', date=2019-11-14T22:46:18, views=8295, hashtags=[#Hashtag-10, #Hashtag-18, #Hashtag-15, #Hashtag-1, #Hashtag-3]}
Tweet{subject='Tweet-93', body='Tweet body-78', date=2024-01-09T00:27:15, views=5366, hashtags=[#Hashtag-2]}
Tweet{subject='Tweet-34', body='Tweet body-8', date=2021-10-08T18:10:42, views=6239, hashtags=[#Hashtag-14, #Hashtag-18, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-87', body='Tweet body-62', date=2020-08-31T04:08:36, views=10598, hashtags=[#Hashtag-6, #Hashtag-7]}
Tweet{subject='Tweet-80', body='Tweet body-19', date=2023-12-08T16:23:33, views=1746, hashtags=[#Hashtag-4, #Hashtag-7, #Hashtag-13, #Hashtag-9]}
Tweet{subject='Tweet-84', body='Tweet body-36', date=2023-10-31T23:00:40, views=10598, hashtags=[#Hashtag-13, #Hashtag-8, #Hashtag-11, #Hashtag-17, #Hashtag-16]}
Tweet{subject='Tweet-78', body='Tweet body-45', date=2021-01-17T04:54:05, views=8677, hashtags=[#Hashtag-5]}
Tweet{subject='Tweet-7', body='Tweet body-34', date=2024-08-10T05:33:08, views=9234, hashtags=[#Hashtag-8]}
Tweet{subject='Tweet-35', body='Tweet body-67', date=2023-01-13T01:50:25, views=10380, hashtags=[#Hashtag-13, #Hashtag-19]}
Tweet{subject='Tweet-69', body='Tweet body-99', date=2024-03-18T16:48:41, views=3753, hashtags=[#Hashtag-13, #Hashtag-17, #Hashtag-3]}
Tweet{subject='Tweet-13', body='Tweet body-78', date=2022-09-17T14:19:27, views=5511, hashtags=[#Hashtag-5, #Hashtag-9, #Hashtag-11, #Hashtag-16, #Hashtag-3]}
Tweet{subject='Tweet-32', body='Tweet body-27', date=2023-09-28T16:44:24, views=10622, hashtags=[#Hashtag-4, #Hashtag-6, #Hashtag-13, #Hashtag-11, #Hashtag-2]}
Tweet{subject='Tweet-50', body='Tweet body-38', date=2020-10-30T14:31:08, views=5533, hashtags=[#Hashtag-10, #Hashtag-11, #Hashtag-18, #Hashtag-16, #Hashtag-3]}
Tweet{subject='Tweet-33', body='Tweet body-30', date=2024-09-15T08:36:06, views=1667, hashtags=[#Hashtag-6]}
Tweet{subject='Tweet-19', body='Tweet body-44', date=2020-12-30T08:25:14, views=3833, hashtags=[#Hashtag-5, #Hashtag-17, #Hashtag-18]}
Tweet{subject='Tweet-72', body='Tweet body-81', date=2022-04-18T03:43:12, views=11707, hashtags=[#Hashtag-8, #Hashtag-15]}
Tweet{subject='Tweet-27', body='Tweet body-69', date=2021-04-30T08:06:07, views=8424, hashtags=[#Hashtag-4, #Hashtag-5, #Hashtag-19]}
Tweet{subject='Tweet-81', body='Tweet body-49', date=2022-02-07T00:27:18, views=1248, hashtags=[#Hashtag-11, #Hashtag-17, #Hashtag-18]}
Tweet{subject='Tweet-94', body='Tweet body-9', date=2020-08-30T09:24:14, views=10365, hashtags=[#Hashtag-11]}
Tweet{subject='Tweet-45', body='Tweet body-38', date=2021-08-22T10:12, views=9615, hashtags=[#Hashtag-6]}
Tweet{subject='Tweet-46', body='Tweet body-85', date=2021-04-14T17:09:11, views=11838, hashtags=[#Hashtag-8, #Hashtag-9, #Hashtag-14, #Hashtag-0]}
Tweet{subject='Tweet-39', body='Tweet body-0', date=2024-07-14T03:13:24, views=6238, hashtags=[#Hashtag-5, #Hashtag-17, #Hashtag-16]}
Tweet{subject='Tweet-81', body='Tweet body-81', date=2021-02-08T12:23:48, views=10667, hashtags=[#Hashtag-7, #Hashtag-11]}
Tweet{subject='Tweet-95', body='Tweet body-68', date=2021-08-05T15:55:06, views=113, hashtags=[#Hashtag-16, #Hashtag-1]}
Tweet{subject='Tweet-7', body='Tweet body-13', date=2019-11-11T12:30:50, views=3413, hashtags=[#Hashtag-13, #Hashtag-19]}
Tweet{subject='Tweet-67', body='Tweet body-40', date=2023-01-21T22:49:56, views=3476, hashtags=[#Hashtag-14, #Hashtag-16, #Hashtag-3]}
Tweet{subject='Tweet-7', body='Tweet body-16', date=2023-11-07T06:19:28, views=5610, hashtags=[#Hashtag-7, #Hashtag-8, #Hashtag-0, #Hashtag-2, #Hashtag-3]}
Tweet{subject='Tweet-67', body='Tweet body-84', date=2021-09-24T10:38:54, views=7776, hashtags=[#Hashtag-7, #Hashtag-14]}
Tweet{subject='Tweet-87', body='Tweet body-53', date=2021-08-05T12:39:59, views=9519, hashtags=[#Hashtag-7, #Hashtag-14, #Hashtag-18, #Hashtag-15, #Hashtag-0]}
Tweet{subject='Tweet-62', body='Tweet body-69', date=2021-03-20T15:40:20, views=9844, hashtags=[#Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-41', body='Tweet body-90', date=2021-07-31T02:14:07, views=9885, hashtags=[#Hashtag-4, #Hashtag-14, #Hashtag-3]}
Tweet{subject='Tweet-16', body='Tweet body-79', date=2024-08-08T16:56:06, views=1932, hashtags=[#Hashtag-10, #Hashtag-11]}
Tweet{subject='Tweet-14', body='Tweet body-80', date=2024-06-27T09:02:53, views=8915, hashtags=[#Hashtag-10, #Hashtag-0, #Hashtag-2]}
Tweet{subject='Tweet-66', body='Tweet body-91', date=2021-10-03T15:42:59, views=2153, hashtags=[#Hashtag-13, #Hashtag-14, #Hashtag-3]}
Tweet{subject='Tweet-43', body='Tweet body-61', date=2023-07-01T18:35:44, views=6494, hashtags=[#Hashtag-9, #Hashtag-14]}
Tweet{subject='Tweet-6', body='Tweet body-19', date=2021-10-26T08:14:07, views=6770, hashtags=[#Hashtag-4, #Hashtag-6, #Hashtag-15]}
Tweet{subject='Tweet-50', body='Tweet body-69', date=2019-12-05T23:17:10, views=6046, hashtags=[#Hashtag-9, #Hashtag-11, #Hashtag-19]}
Tweet{subject='Tweet-87', body='Tweet body-64', date=2020-05-02T23:51:08, views=5603, hashtags=[#Hashtag-10, #Hashtag-6, #Hashtag-9, #Hashtag-2]}
Tweet{subject='Tweet-78', body='Tweet body-88', date=2021-02-06T12:40:29, views=10747, hashtags=[#Hashtag-4, #Hashtag-10, #Hashtag-7, #Hashtag-14]}
Tweet{subject='Tweet-22', body='Tweet body-87', date=2022-01-22T09:02:53, views=8571, hashtags=[#Hashtag-4, #Hashtag-5, #Hashtag-8, #Hashtag-11, #Hashtag-16]}
Tweet{subject='Tweet-29', body='Tweet body-14', date=2023-09-08T08:19:36, views=5189, hashtags=[#Hashtag-9]}
Tweet{subject='Tweet-58', body='Tweet body-36', date=2020-02-15T20:22:58, views=6361, hashtags=[#Hashtag-8, #Hashtag-18]}
Tweet{subject='Tweet-40', body='Tweet body-43', date=2021-10-27T23:27:35, views=6948, hashtags=[#Hashtag-16]}
Tweet{subject='Tweet-39', body='Tweet body-82', date=2024-08-09T03:04:28, views=2963, hashtags=[#Hashtag-7, #Hashtag-2]}
Tweet{subject='Tweet-63', body='Tweet body-41', date=2023-02-22T19:24:32, views=10208, hashtags=[#Hashtag-4, #Hashtag-14, #Hashtag-18, #Hashtag-16, #Hashtag-19]}
Tweet{subject='Tweet-65', body='Tweet body-40', date=2020-05-16T13:41:58, views=7660, hashtags=[#Hashtag-15, #Hashtag-2]}
Tweet{subject='Tweet-35', body='Tweet body-66', date=2023-09-27T16:55:46, views=1303, hashtags=[#Hashtag-1]}
Tweet{subject='Tweet-11', body='Tweet body-55', date=2020-10-02T00:56:12, views=11452, hashtags=[#Hashtag-8, #Hashtag-2]}
Tweet{subject='Tweet-23', body='Tweet body-95', date=2023-10-19T18:06:37, views=1729, hashtags=[#Hashtag-6, #Hashtag-11, #Hashtag-16, #Hashtag-3]}
Tweet{subject='Tweet-31', body='Tweet body-94', date=2023-05-08T17:53:03, views=2058, hashtags=[#Hashtag-10, #Hashtag-11]}
Tweet{subject='Tweet-84', body='Tweet body-49', date=2021-05-25T17:59:40, views=4223, hashtags=[#Hashtag-10, #Hashtag-0, #Hashtag-1, #Hashtag-3]}
Tweet{subject='Tweet-35', body='Tweet body-33', date=2020-10-12T04:22:49, views=2800, hashtags=[#Hashtag-12, #Hashtag-3]}
Tweet{subject='Tweet-70', body='Tweet body-91', date=2020-07-21T09:01:21, views=10805, hashtags=[#Hashtag-9, #Hashtag-0]}
Tweet{subject='Tweet-89', body='Tweet body-57', date=2020-05-12T16:53:20, views=10032, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-53', body='Tweet body-89', date=2021-08-11T13:23:59, views=2923, hashtags=[#Hashtag-4, #Hashtag-13, #Hashtag-16]}
Tweet{subject='Tweet-51', body='Tweet body-47', date=2022-01-30T11:13:13, views=1770, hashtags=[#Hashtag-5, #Hashtag-18]}
Tweet{subject='Tweet-31', body='Tweet body-51', date=2020-10-19T07:15:18, views=9198, hashtags=[#Hashtag-17, #Hashtag-19]}
Tweet{subject='Tweet-88', body='Tweet body-81', date=2024-06-30T16:10:58, views=10303, hashtags=[#Hashtag-17, #Hashtag-0]}
Tweet{subject='Tweet-63', body='Tweet body-79', date=2021-09-28T12:40:41, views=900, hashtags=[#Hashtag-10, #Hashtag-8, #Hashtag-11, #Hashtag-12]}
Tweet{subject='Tweet-97', body='Tweet body-42', date=2023-04-07T16:15:36, views=11835, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-88', body='Tweet body-71', date=2020-05-26T09:22:05, views=3878, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-24', body='Tweet body-6', date=2021-10-02T10:21:33, views=8455, hashtags=[#Hashtag-5, #Hashtag-0]}
Tweet{subject='Tweet-54', body='Tweet body-28', date=2021-11-30T15:39:21, views=9985, hashtags=[#Hashtag-5, #Hashtag-6, #Hashtag-7, #Hashtag-3]}
Tweet{subject='Tweet-13', body='Tweet body-64', date=2023-11-13T02:53:29, views=3156, hashtags=[#Hashtag-16]}
Tweet{subject='Tweet-77', body='Tweet body-83', date=2023-04-19T01:36:56, views=12, hashtags=[#Hashtag-0]}
Tweet{subject='Tweet-98', body='Tweet body-62', date=2021-01-04T12:05:42, views=6832, hashtags=[#Hashtag-18]}
Tweet{subject='Tweet-82', body='Tweet body-78', date=2023-07-09T22:07:58, views=11012, hashtags=[#Hashtag-7, #Hashtag-8, #Hashtag-16]}
Tweet{subject='Tweet-99', body='Tweet body-87', date=2024-09-14T03:16:23, views=3266, hashtags=[#Hashtag-7, #Hashtag-11, #Hashtag-0]}
Tweet{subject='Tweet-39', body='Tweet body-21', date=2021-09-21T00:13:45, views=2783, hashtags=[#Hashtag-5, #Hashtag-8, #Hashtag-9, #Hashtag-2]}
Tweet{subject='Tweet-54', body='Tweet body-36', date=2022-09-09T07:06:16, views=6712, hashtags=[#Hashtag-11, #Hashtag-12, #Hashtag-19]}
Tweet{subject='Tweet-67', body='Tweet body-55', date=2022-10-31T17:42:59, views=4275, hashtags=[#Hashtag-10]}
Tweet{subject='Tweet-42', body='Tweet body-30', date=2022-08-21T21:17:03, views=11411, hashtags=[#Hashtag-9, #Hashtag-17, #Hashtag-15, #Hashtag-3]}
Tweet{subject='Tweet-36', body='Tweet body-48', date=2020-01-28T01:52:22, views=5557, hashtags=[#Hashtag-0, #Hashtag-19]}
Tweet{subject='Tweet-89', body='Tweet body-11', date=2021-05-19T15:42:44, views=2330, hashtags=[#Hashtag-10, #Hashtag-6, #Hashtag-17, #Hashtag-18]}
Tweet{subject='Tweet-90', body='Tweet body-70', date=2020-04-29T05:45:46, views=4936, hashtags=[#Hashtag-6, #Hashtag-16]}
Tweet{subject='Tweet-8', body='Tweet body-90', date=2021-12-24T01:54:10, views=1431, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-29', body='Tweet body-60', date=2019-11-11T03:11:06, views=2623, hashtags=[#Hashtag-14, #Hashtag-12]}
Tweet{subject='Tweet-10', body='Tweet body-63', date=2022-02-07T17:41:25, views=1802, hashtags=[#Hashtag-12]}
Tweet{subject='Tweet-20', body='Tweet body-41', date=2022-07-23T06:38:40, views=8699, hashtags=[#Hashtag-4, #Hashtag-18]}
Tweet{subject='Tweet-41', body='Tweet body-22', date=2022-11-07T18:01:22, views=8643, hashtags=[#Hashtag-10, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-64', body='Tweet body-59', date=2022-10-11T20:31:17, views=1415, hashtags=[#Hashtag-5, #Hashtag-6, #Hashtag-9, #Hashtag-3]}
Tweet{subject='Tweet-24', body='Tweet body-47', date=2024-03-27T04:16:06, views=6367, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-12', body='Tweet body-39', date=2024-06-12T04:02:27, views=9490, hashtags=[#Hashtag-13, #Hashtag-14, #Hashtag-17, #Hashtag-0, #Hashtag-19]}
Tweet{subject='Tweet-78', body='Tweet body-72', date=2022-09-28T05:54:26, views=912, hashtags=[#Hashtag-9, #Hashtag-16]}
Tweet{subject='Tweet-88', body='Tweet body-15', date=2024-06-14T10:51:40, views=2196, hashtags=[#Hashtag-11]}
Tweet{subject='Tweet-30', body='Tweet body-7', date=2021-01-01T11:59:40, views=7488, hashtags=[#Hashtag-13, #Hashtag-18]}
Tweet{subject='Tweet-98', body='Tweet body-88', date=2019-10-15T00:23:11, views=1687, hashtags=[#Hashtag-13]}
Tweet{subject='Tweet-1', body='Tweet body-56', date=2023-01-14T20:26:25, views=4971, hashtags=[#Hashtag-17, #Hashtag-3]}
Tweet{subject='Tweet-10', body='Tweet body-15', date=2020-01-16T19:15:21, views=8448, hashtags=[#Hashtag-7, #Hashtag-13, #Hashtag-11, #Hashtag-19]}
Tweet{subject='Tweet-94', body='Tweet body-85', date=2024-02-04T06:32:41, views=2193, hashtags=[#Hashtag-4, #Hashtag-7, #Hashtag-12]}
Tweet{subject='Tweet-92', body='Tweet body-59', date=2024-01-02T18:06:59, views=3987, hashtags=[#Hashtag-4, #Hashtag-5, #Hashtag-17, #Hashtag-18, #Hashtag-0]}
Tweet{subject='Tweet-14', body='Tweet body-30', date=2024-06-26T08:36:35, views=8465, hashtags=[#Hashtag-4, #Hashtag-6, #Hashtag-7, #Hashtag-8, #Hashtag-12]}
Tweet{subject='Tweet-21', body='Tweet body-57', date=2023-11-10T09:10:24, views=8202, hashtags=[#Hashtag-4, #Hashtag-13, #Hashtag-11]}
Tweet{subject='Tweet-3', body='Tweet body-34', date=2024-09-28T06:29:39, views=5779, hashtags=[#Hashtag-4, #Hashtag-13, #Hashtag-12, #Hashtag-3]}
Tweet{subject='Tweet-84', body='Tweet body-68', date=2023-10-15T18:14:09, views=11978, hashtags=[#Hashtag-10, #Hashtag-0, #Hashtag-2]}
Tweet{subject='Tweet-23', body='Tweet body-24', date=2021-12-09T19:25:04, views=2488, hashtags=[#Hashtag-5, #Hashtag-7, #Hashtag-17, #Hashtag-18]}
Tweet{subject='Tweet-67', body='Tweet body-7', date=2023-06-25T04:26:09, views=7546, hashtags=[#Hashtag-13, #Hashtag-16, #Hashtag-2, #Hashtag-3]}
Tweet{subject='Tweet-81', body='Tweet body-16', date=2020-08-28T06:52:05, views=2089, hashtags=[#Hashtag-14, #Hashtag-0]}
Tweet{subject='Tweet-18', body='Tweet body-67', date=2021-10-18T20:48:15, views=4727, hashtags=[#Hashtag-6, #Hashtag-8, #Hashtag-13]}
Tweet{subject='Tweet-74', body='Tweet body-1', date=2022-05-15T14:34:07, views=7783, hashtags=[#Hashtag-10, #Hashtag-5, #Hashtag-6]}
Tweet{subject='Tweet-98', body='Tweet body-0', date=2022-02-26T22:45:53, views=2973, hashtags=[#Hashtag-8, #Hashtag-11]}
Tweet{subject='Tweet-15', body='Tweet body-24', date=2020-10-19T16:52:46, views=5389, hashtags=[#Hashtag-4, #Hashtag-7, #Hashtag-2]}
Tweet{subject='Tweet-94', body='Tweet body-87', date=2020-12-25T09:38:15, views=7286, hashtags=[#Hashtag-12, #Hashtag-15, #Hashtag-16, #Hashtag-1]}
Tweet{subject='Tweet-85', body='Tweet body-84', date=2023-07-14T23:23:27, views=9466, hashtags=[#Hashtag-13, #Hashtag-18, #Hashtag-15, #Hashtag-16, #Hashtag-3]}
Tweet{subject='Tweet-31', body='Tweet body-2', date=2024-03-09T12:49:47, views=1601, hashtags=[#Hashtag-4, #Hashtag-6, #Hashtag-16]}
Tweet{subject='Tweet-46', body='Tweet body-24', date=2022-09-11T08:43:45, views=5060, hashtags=[#Hashtag-7, #Hashtag-12, #Hashtag-17, #Hashtag-0, #Hashtag-1]}
Tweet{subject='Tweet-66', body='Tweet body-74', date=2024-03-08T10:31:04, views=11756, hashtags=[#Hashtag-17]}
Tweet{subject='Tweet-52', body='Tweet body-83', date=2023-12-08T01:17:35, views=11734, hashtags=[#Hashtag-4, #Hashtag-7]}
Tweet{subject='Tweet-16', body='Tweet body-75', date=2022-02-04T08:55:10, views=7846, hashtags=[#Hashtag-10, #Hashtag-11]}
Tweet{subject='Tweet-70', body='Tweet body-61', date=2022-03-05T23:21:52, views=10641, hashtags=[#Hashtag-13, #Hashtag-12]}
Tweet{subject='Tweet-15', body='Tweet body-86', date=2023-07-17T05:05:33, views=8598, hashtags=[#Hashtag-7, #Hashtag-13]}
Tweet{subject='Tweet-75', body='Tweet body-94', date=2021-02-03T07:54:55, views=10562, hashtags=[#Hashtag-7, #Hashtag-13]}
Tweet{subject='Tweet-39', body='Tweet body-46', date=2024-05-08T08:50:22, views=4832, hashtags=[#Hashtag-10, #Hashtag-13, #Hashtag-1, #Hashtag-19]}
Tweet{subject='Tweet-92', body='Tweet body-13', date=2024-06-04T20:24:26, views=7672, hashtags=[#Hashtag-8, #Hashtag-9, #Hashtag-15, #Hashtag-3]}
Tweet{subject='Tweet-2', body='Tweet body-52', date=2023-07-01T18:26:07, views=5421, hashtags=[#Hashtag-10, #Hashtag-6, #Hashtag-7, #Hashtag-17, #Hashtag-3]}
Tweet{subject='Tweet-15', body='Tweet body-83', date=2022-01-02T02:23:10, views=8479, hashtags=[#Hashtag-9, #Hashtag-2]}
Tweet{subject='Tweet-0', body='Tweet body-11', date=2024-08-30T13:40:41, views=3800, hashtags=[#Hashtag-6, #Hashtag-13, #Hashtag-12, #Hashtag-15]}
Tweet{subject='Tweet-72', body='Tweet body-39', date=2024-07-24T20:50:35, views=6803, hashtags=[#Hashtag-2]}
Tweet{subject='Tweet-51', body='Tweet body-67', date=2021-12-05T00:24:54, views=2082, hashtags=[#Hashtag-19, #Hashtag-2]}
Tweet{subject='Tweet-62', body='Tweet body-1', date=2024-07-19T11:21:20, views=11802, hashtags=[#Hashtag-5, #Hashtag-6, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-0', body='Tweet body-14', date=2023-09-23T15:06:07, views=414, hashtags=[#Hashtag-5, #Hashtag-19, #Hashtag-3]}
Tweet{subject='Tweet-9', body='Tweet body-17', date=2023-11-04T17:10:35, views=9266, hashtags=[#Hashtag-12, #Hashtag-16]}
Tweet{subject='Tweet-5', body='Tweet body-76', date=2023-02-09T21:54:06, views=7171, hashtags=[#Hashtag-7, #Hashtag-8, #Hashtag-19]}
Tweet{subject='Tweet-55', body='Tweet body-37', date=2019-11-10T07:06:36, views=2759, hashtags=[#Hashtag-7, #Hashtag-1]}
Tweet{subject='Tweet-75', body='Tweet body-5', date=2023-09-29T20:46:24, views=9205, hashtags=[#Hashtag-4]}
Tweet{subject='Tweet-12', body='Tweet body-76', date=2023-01-31T10:01:49, views=1155, hashtags=[#Hashtag-16]}
Tweet{subject='Tweet-15', body='Tweet body-50', date=2021-05-01T08:27:47, views=2077, hashtags=[#Hashtag-7, #Hashtag-13, #Hashtag-11, #Hashtag-2]}
Tweet{subject='Tweet-69', body='Tweet body-76', date=2020-02-13T10:22:29, views=7472, hashtags=[#Hashtag-13, #Hashtag-9]}
Tweet{subject='Tweet-97', body='Tweet body-37', date=2022-12-13T22:40:17, views=10998, hashtags=[#Hashtag-18, #Hashtag-3]}
Tweet{subject='Tweet-1', body='Tweet body-70', date=2020-07-13T14:55:23, views=7796, hashtags=[#Hashtag-7, #Hashtag-0]}
Tweet{subject='Tweet-61', body='Tweet body-69', date=2020-06-14T04:01:46, views=4596, hashtags=[#Hashtag-4, #Hashtag-13, #Hashtag-3]}
Tweet{subject='Tweet-93', body='Tweet body-19', date=2021-02-02T12:38:39, views=3446, hashtags=[#Hashtag-10, #Hashtag-19]}
Tweet{subject='Tweet-30', body='Tweet body-18', date=2022-01-30T00:36:03, views=1436, hashtags=[#Hashtag-18, #Hashtag-16, #Hashtag-3]}
Tweet{subject='Tweet-80', body='Tweet body-35', date=2021-06-13T12:51:49, views=10518, hashtags=[#Hashtag-8, #Hashtag-3]}

Tweets by Subject
Tweet{subject='Tweet-1', body='Tweet body-32', date=2022-06-18T22:51:04, views=9968, hashtags=[#Hashtag-6, #Hashtag-8, #Hashtag-15]}
Tweet{subject='Tweet-1', body='Tweet body-56', date=2023-01-14T20:26:25, views=4971, hashtags=[#Hashtag-17, #Hashtag-3]}
Tweet{subject='Tweet-1', body='Tweet body-70', date=2020-07-13T14:55:23, views=7796, hashtags=[#Hashtag-7, #Hashtag-0]}

Tweets by Hashtag
Tweet{subject='Tweet-4', body='Tweet body-59', date=2022-09-30T02:00:45, views=2105, hashtags=[#Hashtag-8, #Hashtag-12, #Hashtag-16, #Hashtag-1, #Hashtag-19]}
Tweet{subject='Tweet-86', body='Tweet body-34', date=2021-10-25T07:04:04, views=4109, hashtags=[#Hashtag-1]}
Tweet{subject='Tweet-57', body='Tweet body-82', date=2024-05-20T08:04:05, views=3302, hashtags=[#Hashtag-4, #Hashtag-0, #Hashtag-1]}
Tweet{subject='Tweet-97', body='Tweet body-42', date=2021-07-06T17:58:24, views=10470, hashtags=[#Hashtag-12, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-79', body='Tweet body-44', date=2022-12-01T15:31:42, views=7544, hashtags=[#Hashtag-8, #Hashtag-0, #Hashtag-1, #Hashtag-3]}
Tweet{subject='Tweet-49', body='Tweet body-60', date=2023-10-06T18:53:59, views=5454, hashtags=[#Hashtag-15, #Hashtag-1]}
Tweet{subject='Tweet-80', body='Tweet body-57', date=2023-09-12T11:02:57, views=8523, hashtags=[#Hashtag-7, #Hashtag-14, #Hashtag-1]}
Tweet{subject='Tweet-12', body='Tweet body-42', date=2023-01-20T21:45:11, views=8789, hashtags=[#Hashtag-5, #Hashtag-1]}
Tweet{subject='Tweet-37', body='Tweet body-73', date=2024-03-10T05:36:48, views=5256, hashtags=[#Hashtag-8, #Hashtag-9, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-73', body='Tweet body-3', date=2021-09-24T08:54:33, views=373, hashtags=[#Hashtag-14, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-52', body='Tweet body-52', date=2024-06-12T17:18:02, views=11176, hashtags=[#Hashtag-13, #Hashtag-11, #Hashtag-12, #Hashtag-1]}
Tweet{subject='Tweet-20', body='Tweet body-3', date=2022-10-14T16:13:55, views=4647, hashtags=[#Hashtag-4, #Hashtag-11, #Hashtag-1]}
Tweet{subject='Tweet-22', body='Tweet body-79', date=2022-01-15T05:24:02, views=6538, hashtags=[#Hashtag-16, #Hashtag-1]}
Tweet{subject='Tweet-72', body='Tweet body-63', date=2019-11-14T22:46:18, views=8295, hashtags=[#Hashtag-10, #Hashtag-18, #Hashtag-15, #Hashtag-1, #Hashtag-3]}
Tweet{subject='Tweet-34', body='Tweet body-8', date=2021-10-08T18:10:42, views=6239, hashtags=[#Hashtag-14, #Hashtag-18, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-95', body='Tweet body-68', date=2021-08-05T15:55:06, views=113, hashtags=[#Hashtag-16, #Hashtag-1]}
Tweet{subject='Tweet-62', body='Tweet body-69', date=2021-03-20T15:40:20, views=9844, hashtags=[#Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-35', body='Tweet body-66', date=2023-09-27T16:55:46, views=1303, hashtags=[#Hashtag-1]}
Tweet{subject='Tweet-84', body='Tweet body-49', date=2021-05-25T17:59:40, views=4223, hashtags=[#Hashtag-10, #Hashtag-0, #Hashtag-1, #Hashtag-3]}
Tweet{subject='Tweet-41', body='Tweet body-22', date=2022-11-07T18:01:22, views=8643, hashtags=[#Hashtag-10, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-94', body='Tweet body-87', date=2020-12-25T09:38:15, views=7286, hashtags=[#Hashtag-12, #Hashtag-15, #Hashtag-16, #Hashtag-1]}
Tweet{subject='Tweet-46', body='Tweet body-24', date=2022-09-11T08:43:45, views=5060, hashtags=[#Hashtag-7, #Hashtag-12, #Hashtag-17, #Hashtag-0, #Hashtag-1]}
Tweet{subject='Tweet-39', body='Tweet body-46', date=2024-05-08T08:50:22, views=4832, hashtags=[#Hashtag-10, #Hashtag-13, #Hashtag-1, #Hashtag-19]}
Tweet{subject='Tweet-62', body='Tweet body-1', date=2024-07-19T11:21:20, views=11802, hashtags=[#Hashtag-5, #Hashtag-6, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-55', body='Tweet body-37', date=2019-11-10T07:06:36, views=2759, hashtags=[#Hashtag-7, #Hashtag-1]}

Tweets by Views
Tweet{subject='Tweet-27', body='Tweet body-67', date=2021-01-16T21:08:08, views=10644, hashtags=[#Hashtag-7, #Hashtag-17, #Hashtag-19]}
Tweet{subject='Tweet-53', body='Tweet body-79', date=2024-07-03T15:09:18, views=11849, hashtags=[#Hashtag-10, #Hashtag-5, #Hashtag-17, #Hashtag-16, #Hashtag-19]}
Tweet{subject='Tweet-97', body='Tweet body-42', date=2021-07-06T17:58:24, views=10470, hashtags=[#Hashtag-12, #Hashtag-18, #Hashtag-1]}
Tweet{subject='Tweet-36', body='Tweet body-21', date=2023-04-22T17:14:01, views=10230, hashtags=[#Hashtag-4, #Hashtag-12, #Hashtag-15]}
Tweet{subject='Tweet-41', body='Tweet body-98', date=2021-11-19T14:50:25, views=10180, hashtags=[#Hashtag-2]}
Tweet{subject='Tweet-78', body='Tweet body-18', date=2022-06-09T21:26:54, views=11707, hashtags=[#Hashtag-10, #Hashtag-7]}
Tweet{subject='Tweet-82', body='Tweet body-39', date=2021-05-20T09:30:45, views=10318, hashtags=[#Hashtag-14, #Hashtag-11]}
Tweet{subject='Tweet-87', body='Tweet body-33', date=2020-09-22T13:07:18, views=10556, hashtags=[#Hashtag-6, #Hashtag-17, #Hashtag-0, #Hashtag-19]}
Tweet{subject='Tweet-40', body='Tweet body-84', date=2021-05-05T15:48:58, views=10899, hashtags=[#Hashtag-10, #Hashtag-9]}
Tweet{subject='Tweet-45', body='Tweet body-85', date=2020-06-05T06:21:41, views=11178, hashtags=[#Hashtag-5, #Hashtag-11, #Hashtag-16]}
Tweet{subject='Tweet-92', body='Tweet body-69', date=2020-11-27T10:33:28, views=11942, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-7', body='Tweet body-50', date=2020-11-24T15:31:10, views=10198, hashtags=[#Hashtag-12, #Hashtag-18]}
Tweet{subject='Tweet-52', body='Tweet body-52', date=2024-06-12T17:18:02, views=11176, hashtags=[#Hashtag-13, #Hashtag-11, #Hashtag-12, #Hashtag-1]}
Tweet{subject='Tweet-44', body='Tweet body-4', date=2020-09-17T01:00:56, views=11479, hashtags=[#Hashtag-8]}
Tweet{subject='Tweet-87', body='Tweet body-62', date=2020-08-31T04:08:36, views=10598, hashtags=[#Hashtag-6, #Hashtag-7]}
Tweet{subject='Tweet-84', body='Tweet body-36', date=2023-10-31T23:00:40, views=10598, hashtags=[#Hashtag-13, #Hashtag-8, #Hashtag-11, #Hashtag-17, #Hashtag-16]}
Tweet{subject='Tweet-35', body='Tweet body-67', date=2023-01-13T01:50:25, views=10380, hashtags=[#Hashtag-13, #Hashtag-19]}
Tweet{subject='Tweet-32', body='Tweet body-27', date=2023-09-28T16:44:24, views=10622, hashtags=[#Hashtag-4, #Hashtag-6, #Hashtag-13, #Hashtag-11, #Hashtag-2]}
Tweet{subject='Tweet-72', body='Tweet body-81', date=2022-04-18T03:43:12, views=11707, hashtags=[#Hashtag-8, #Hashtag-15]}
Tweet{subject='Tweet-94', body='Tweet body-9', date=2020-08-30T09:24:14, views=10365, hashtags=[#Hashtag-11]}
Tweet{subject='Tweet-46', body='Tweet body-85', date=2021-04-14T17:09:11, views=11838, hashtags=[#Hashtag-8, #Hashtag-9, #Hashtag-14, #Hashtag-0]}
Tweet{subject='Tweet-81', body='Tweet body-81', date=2021-02-08T12:23:48, views=10667, hashtags=[#Hashtag-7, #Hashtag-11]}
Tweet{subject='Tweet-78', body='Tweet body-88', date=2021-02-06T12:40:29, views=10747, hashtags=[#Hashtag-4, #Hashtag-10, #Hashtag-7, #Hashtag-14]}
Tweet{subject='Tweet-63', body='Tweet body-41', date=2023-02-22T19:24:32, views=10208, hashtags=[#Hashtag-4, #Hashtag-14, #Hashtag-18, #Hashtag-16, #Hashtag-19]}
Tweet{subject='Tweet-11', body='Tweet body-55', date=2020-10-02T00:56:12, views=11452, hashtags=[#Hashtag-8, #Hashtag-2]}
Tweet{subject='Tweet-70', body='Tweet body-91', date=2020-07-21T09:01:21, views=10805, hashtags=[#Hashtag-9, #Hashtag-0]}
Tweet{subject='Tweet-89', body='Tweet body-57', date=2020-05-12T16:53:20, views=10032, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-88', body='Tweet body-81', date=2024-06-30T16:10:58, views=10303, hashtags=[#Hashtag-17, #Hashtag-0]}
Tweet{subject='Tweet-97', body='Tweet body-42', date=2023-04-07T16:15:36, views=11835, hashtags=[#Hashtag-15]}
Tweet{subject='Tweet-82', body='Tweet body-78', date=2023-07-09T22:07:58, views=11012, hashtags=[#Hashtag-7, #Hashtag-8, #Hashtag-16]}
Tweet{subject='Tweet-42', body='Tweet body-30', date=2022-08-21T21:17:03, views=11411, hashtags=[#Hashtag-9, #Hashtag-17, #Hashtag-15, #Hashtag-3]}
Tweet{subject='Tweet-84', body='Tweet body-68', date=2023-10-15T18:14:09, views=11978, hashtags=[#Hashtag-10, #Hashtag-0, #Hashtag-2]}
Tweet{subject='Tweet-66', body='Tweet body-74', date=2024-03-08T10:31:04, views=11756, hashtags=[#Hashtag-17]}
Tweet{subject='Tweet-52', body='Tweet body-83', date=2023-12-08T01:17:35, views=11734, hashtags=[#Hashtag-4, #Hashtag-7]}
Tweet{subject='Tweet-70', body='Tweet body-61', date=2022-03-05T23:21:52, views=10641, hashtags=[#Hashtag-13, #Hashtag-12]}
Tweet{subject='Tweet-75', body='Tweet body-94', date=2021-02-03T07:54:55, views=10562, hashtags=[#Hashtag-7, #Hashtag-13]}
Tweet{subject='Tweet-62', body='Tweet body-1', date=2024-07-19T11:21:20, views=11802, hashtags=[#Hashtag-5, #Hashtag-6, #Hashtag-1, #Hashtag-2]}
Tweet{subject='Tweet-97', body='Tweet body-37', date=2022-12-13T22:40:17, views=10998, hashtags=[#Hashtag-18, #Hashtag-3]}
Tweet{subject='Tweet-80', body='Tweet body-35', date=2021-06-13T12:51:49, views=10518, hashtags=[#Hashtag-8, #Hashtag-3]}

Tweets of Current Month

Trending Tweets
Tweet{subject='Tweet-31', body='Tweet body-25', date=2024-09-16T20:28:04, views=9867, hashtags=[#Hashtag-17, #Hashtag-2]}
Tweet{subject='Tweet-3', body='Tweet body-34', date=2024-09-28T06:29:39, views=5779, hashtags=[#Hashtag-4, #Hashtag-13, #Hashtag-12, #Hashtag-3]}
Tweet{subject='Tweet-99', body='Tweet body-87', date=2024-09-14T03:16:23, views=3266, hashtags=[#Hashtag-7, #Hashtag-11, #Hashtag-0]}
Tweet{subject='Tweet-33', body='Tweet body-30', date=2024-09-15T08:36:06, views=1667, hashtags=[#Hashtag-6]}

Process finished with exit code 0

```