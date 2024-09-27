## Assignment 2
##### Date : 30th Sep, 2024
    Rajesh Singh
    PR No: 240-840-128-028


#### Enum - Categories
```java
package Day6.home.assig1;

public enum Categories {
    EDUCATIONAL("Educational"),
    GAMES("Games"),
    HOME("Home"),
    BATTERYOPERATED("Battery Operated");

    String category;

    Categories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
```

---

#### Date Class
```java
package Day6.home.assig1;

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
        if (this.year == date.year) {
            return this.month - date.month;
        } else {
            return this.year - date.year;
        }
    }
}

```

---

#### Toy Class
```java
package Day6.home.assig1;

import java.util.Comparator;

public class Toy implements Comparable {
    private int id;
    private String name;
    private int price;
    private int age;
    private Categories category;
    private Date purchaseDate;

    public Toy(int id, String name, int price, int age, Date purchaseDate, Categories category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.age = age;
        this.purchaseDate = purchaseDate;
        this.category = category;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Id: " + id + " | Name: " + name + " | Price: " + price + " | Age: " + age + " | Purchase Date: " + purchaseDate + " | Category: " + category.getCategory();
    }

    @Override
    public int compareTo(Object o) {
        Toy toy = (Toy) o;
        if (this.getId() == toy.getId()) {
            return this.getName().compareTo(toy.getName());
        } else {
            return this.getId() - toy.getId();
        }
    }
}

class ToyIdComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Integer.compare(toy1.getId(), toy2.getId());
    }
}

class ToyNameComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getName().compareTo(toy2.getName());
    }
}

class ToyPriceComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getPrice() - toy2.getPrice();
    }
}

```

---

#### Stock class
```java
package Day6.home.assig1;

import java.util.*;

public class Stock {
    private HashMap<Toy, Integer> stockMap;
    private int stockCount;

    public Stock() {
        this.stockMap = new HashMap<>();
        this.stockCount = 0;
    }

    public void addToy(Toy toy) {
        if (stockMap.containsKey(toy)) {
            stockMap.put(toy, stockMap.get(toy) + 1);
        } else {
            stockMap.put(toy, 1);
            stockCount++;
        }
    }

    public void removeToy(Toy toy) {
        if (stockMap.containsKey(toy)) {
            stockMap.put(toy, stockMap.get(toy) - 1);
            if (stockMap.get(toy) == 0) {
                stockMap.remove(toy);
                stockCount--;
            }
        }
    }


    public int getStockCount() {
        return stockCount;
    }


    public void listToys() {
        for (Toy toy : stockMap.keySet()) {
            System.out.println(toy);
        }
    }


    public Toy searchToyUsingBinarySearch(int id) {
        List<Toy> keyList = new ArrayList<>(stockMap.keySet());
        keyList.sort(new ToyIdComparator());
        int t = Collections.binarySearch(keyList, new Toy(id, null, 0, 0, null, null), new ToyIdComparator());
        if (t < 0) {
            return null;
        } else {
            return keyList.get(t);
        }
    }

    public List<Toy> getToyByPriceRange(int minPrice, int maxPrice) {
        List<Toy> keyList = new ArrayList<Toy>();
        for (Toy toy : stockMap.keySet()) {
            if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
                keyList.add(toy);
            }
        }
        keyList.sort(new ToyPriceComparator());
        return keyList;
    }

    public List<Toy> getToyForSpecificAge(int ageValue) {
        List<Toy> keyList = new ArrayList<Toy>();
        for (Toy toy : stockMap.keySet()) {
            if (toy.getAge() == ageValue) {
                keyList.add(toy);
            }
        }
        return keyList;
    }

    public List<Toy> getToySortedById() {
        List<Toy> keyList = new ArrayList<>(stockMap.keySet());
        Collections.sort(keyList, new ToyIdComparator());
        return keyList;
    }

    public List<Toy> getToySortedByName() {
        List<Toy> keyList = new ArrayList<>(stockMap.keySet());
        keyList.sort(new ToyNameComparator());
        return keyList;
    }

    public List<Toy> getToySortedByPrice() {
        List<Toy> keyList = new ArrayList<>(stockMap.keySet());
        keyList.sort(new ToyPriceComparator());
        return keyList;
    }

    public HashMap<Toy, Integer> getOldToyStock(Date date) {
        HashMap<Toy, Integer> filteredMap = new HashMap<>();
        for (Toy toy : stockMap.keySet()) {
            if (toy.getPurchaseDate().compareTo(date) < 0) {
                filteredMap.put(toy, stockMap.get(toy));
            }
        }
        filteredMap.remove(null);
        return filteredMap;
    }

    public HashMap<Categories, List<Toy>> getToyByCategory() {
        HashMap<Categories, List<Toy>> filteredMap = new HashMap<Categories, List<Toy>>();
        for (Toy toy : stockMap.keySet()) {
            if (filteredMap.containsKey(toy.getCategory())) {
                filteredMap.get(toy.getCategory()).add(toy);
            } else {
                List<Toy> list = new ArrayList<>();
                list.add(toy);
                filteredMap.put(toy.getCategory(), list);
            }
        }

        return filteredMap;
    }


    public void displayStock() {
        for (Toy toy : stockMap.keySet()) {
            System.out.println(
                    "Id: " + toy.getId() +
                    " | Name :" + toy.getName() +
                    " | Purchase Date: " + toy.getPurchaseDate() +
                    " | Quantity: " + stockMap.get(toy));
        }
    }

}

```

---

#### Store class
```java
package Day6.home.assig1;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Store {
    private Stock stock;

    public Store() {
        this.stock = new Stock();
    }

    public void addToy(Toy toy) {
        stock.addToy(toy);
    }

    public void removeToy(Toy toy) {
        stock.removeToy(toy);
    }

    public void listToys() {
        System.out.println("\nListing all toys:");
        stock.listToys();
    }


    public Toy searchToyUsingBinarySearch(int id) {
        return stock.searchToyUsingBinarySearch(id);
    }


    public int getStockCount() {
        return stock.getStockCount();
    }

    public void displayStock() {
        System.out.println("\nStock Details ");
        stock.displayStock();
    }

    public void displayToyByCategory() {
        System.out.println("\nCategory ise description");
        HashMap<Categories, List<Toy>> map = stock.getToyByCategory();
        for (Categories c : map.keySet()) {
            System.out.println("Category -> " + c + ":");
            for (Toy toy : map.get(c)) {
                System.out.println(toy);
            }
        }
    }

    public void displayToyBySpecificCategory(Categories category) {
        HashMap<Categories, List<Toy>> map = stock.getToyByCategory();
        if (!map.containsKey(category)) {
            System.out.println("\nNo toys in category " + category.getCategory());
            return;
        }
        System.out.println();
        for (Categories c : map.keySet()) {
            if (c == category) {
                System.out.println("Toys in category " + c + ":");
                for (Toy toy : map.get(c)) {
                    System.out.println(toy);
                }
            }
        }
    }

    public void displayToyByPriceRange(int minPrice, int maxPrice) {
        System.out.println("\nToys between price range " + minPrice + " to " + maxPrice);
        List<Toy> list = stock.getToyByPriceRange(minPrice, maxPrice);
        list.sort(new ToyPriceComparator());
        for (Toy toy : list) {
            System.out.println(toy);
        }
    }


    public void getToyForSpecificAge(int ageValue) {
        List<Toy> keyList = stock.getToyForSpecificAge(ageValue);
        System.out.println("\nToys for age " + ageValue);
        for (Toy toy : keyList) {
            System.out.println(toy);
        }
    }

    public void printToysList(List<Toy> list) {
        for (Toy toy : list) {
            System.out.println(toy);
        }
    }

    public void getToySortedById() {
        System.out.println("\nSorted by id");
        List<Toy> keyList = stock.getToySortedById();
        printToysList(keyList);
    }

    public void getToySortedByName() {
        System.out.println("\nSorted by name");
        List<Toy> keyList = stock.getToySortedByName();
        printToysList(keyList);
    }

    public void getToySortedByPrice() {
        System.out.println("\nSorted by price");
        List<Toy> keyList = stock.getToySortedByPrice();
        printToysList(keyList);
    }

    public void getOldToyStock(Date date) {
        System.out.println("\nOld Stock more than " + date);
        HashMap<Toy, Integer> filteredMap = stock.getOldToyStock(date);
        for (Toy toy : filteredMap.keySet()) {
            System.out.println(toy + " | Quantity: " + filteredMap.get(toy));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Store store = new Store();

        // Initialize Toys with random data
        int totalToys = 9;
        for (int i = 1; i <= totalToys; i++) {
            int year = 2015 + random.nextInt(5);
            int month = 1 + random.nextInt(12);
            int randomToyCount = 1 + random.nextInt(5);
            int catIndex = random.nextInt(Categories.values().length);
            Categories cat = Categories.values()[catIndex];
            int randomPrice = 50 + random.nextInt(50);
            int randomAge = 1 + random.nextInt(5);
            Toy t = new Toy(i, "Toy " + i, randomPrice, randomAge, new Date(year, month), cat);
            for (int j = 0; j < randomToyCount; j++) {
                store.addToy(t);
            }
        }


        // store.displayStock() -> Display count oh all toys in the stock
        System.out.println("\nStock Count: " + store.getStockCount());

        // store.listToys() -> Display all toys in the stock
        store.listToys();

        // store.displayStock() -> Display all toys in the stock
        store.displayStock();

        // store,displayToyBySpecificCategory() -> Display filter toys by specific category
        Categories cat = Categories.BATTERYOPERATED;
        store.displayToyBySpecificCategory(cat);

        // Get toys between price range
        store.displayToyByPriceRange(50, 60);


        // Get toys for specific age
        store.getToyForSpecificAge(3);


        // Print sorted toys by price, id, name
        store.getToySortedById();
        store.getToySortedByName();
        store.getToySortedByPrice();


        // Store.displayToyByCategory() -> Display all the toys by category
        store.displayToyByCategory();

        /// Get old stock
        Date date = new Date(2016, 1);
        store.getOldToyStock(date);


        // Get stock at id with binay search
        int id = 5;
        System.out.println("\nToy with id: " + id + "\n" + store.searchToyUsingBinarySearch(5));
    }
}

```

---

### Output

```shell
Stock Count: 9

Listing all toys:
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated
Id: 6 | Name: Toy 6 | Price: 60 | Age: 1 | Purchase Date: 2016/6 | Category: Games
Id: 9 | Name: Toy 9 | Price: 88 | Age: 5 | Purchase Date: 2017/7 | Category: Home
Id: 7 | Name: Toy 7 | Price: 56 | Age: 1 | Purchase Date: 2016/9 | Category: Educational
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated
Id: 3 | Name: Toy 3 | Price: 74 | Age: 5 | Purchase Date: 2016/12 | Category: Home
Id: 8 | Name: Toy 8 | Price: 84 | Age: 4 | Purchase Date: 2017/8 | Category: Home
Id: 1 | Name: Toy 1 | Price: 85 | Age: 4 | Purchase Date: 2017/1 | Category: Educational

Stock Details 
Id: 2 | Name :Toy 2 | Purchase Date: 2015/6 | Quantity: 4
Id: 5 | Name :Toy 5 | Purchase Date: 2019/8 | Quantity: 2
Id: 6 | Name :Toy 6 | Purchase Date: 2016/6 | Quantity: 4
Id: 9 | Name :Toy 9 | Purchase Date: 2017/7 | Quantity: 4
Id: 7 | Name :Toy 7 | Purchase Date: 2016/9 | Quantity: 3
Id: 4 | Name :Toy 4 | Purchase Date: 2015/8 | Quantity: 4
Id: 3 | Name :Toy 3 | Purchase Date: 2016/12 | Quantity: 3
Id: 8 | Name :Toy 8 | Purchase Date: 2017/8 | Quantity: 3
Id: 1 | Name :Toy 1 | Purchase Date: 2017/1 | Quantity: 2

Toys in category BATTERYOPERATED:
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated

Toys between price range 50 to 60
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 7 | Name: Toy 7 | Price: 56 | Age: 1 | Purchase Date: 2016/9 | Category: Educational
Id: 6 | Name: Toy 6 | Price: 60 | Age: 1 | Purchase Date: 2016/6 | Category: Games

Toys for age 3
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated

Sorted by id
Id: 1 | Name: Toy 1 | Price: 85 | Age: 4 | Purchase Date: 2017/1 | Category: Educational
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 3 | Name: Toy 3 | Price: 74 | Age: 5 | Purchase Date: 2016/12 | Category: Home
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated
Id: 6 | Name: Toy 6 | Price: 60 | Age: 1 | Purchase Date: 2016/6 | Category: Games
Id: 7 | Name: Toy 7 | Price: 56 | Age: 1 | Purchase Date: 2016/9 | Category: Educational
Id: 8 | Name: Toy 8 | Price: 84 | Age: 4 | Purchase Date: 2017/8 | Category: Home
Id: 9 | Name: Toy 9 | Price: 88 | Age: 5 | Purchase Date: 2017/7 | Category: Home

Sorted by name
Id: 1 | Name: Toy 1 | Price: 85 | Age: 4 | Purchase Date: 2017/1 | Category: Educational
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 3 | Name: Toy 3 | Price: 74 | Age: 5 | Purchase Date: 2016/12 | Category: Home
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated
Id: 6 | Name: Toy 6 | Price: 60 | Age: 1 | Purchase Date: 2016/6 | Category: Games
Id: 7 | Name: Toy 7 | Price: 56 | Age: 1 | Purchase Date: 2016/9 | Category: Educational
Id: 8 | Name: Toy 8 | Price: 84 | Age: 4 | Purchase Date: 2017/8 | Category: Home
Id: 9 | Name: Toy 9 | Price: 88 | Age: 5 | Purchase Date: 2017/7 | Category: Home

Sorted by price
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 7 | Name: Toy 7 | Price: 56 | Age: 1 | Purchase Date: 2016/9 | Category: Educational
Id: 6 | Name: Toy 6 | Price: 60 | Age: 1 | Purchase Date: 2016/6 | Category: Games
Id: 3 | Name: Toy 3 | Price: 74 | Age: 5 | Purchase Date: 2016/12 | Category: Home
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated
Id: 8 | Name: Toy 8 | Price: 84 | Age: 4 | Purchase Date: 2017/8 | Category: Home
Id: 1 | Name: Toy 1 | Price: 85 | Age: 4 | Purchase Date: 2017/1 | Category: Educational
Id: 9 | Name: Toy 9 | Price: 88 | Age: 5 | Purchase Date: 2017/7 | Category: Home

Category ise description
Category -> EDUCATIONAL:
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational
Id: 7 | Name: Toy 7 | Price: 56 | Age: 1 | Purchase Date: 2016/9 | Category: Educational
Id: 1 | Name: Toy 1 | Price: 85 | Age: 4 | Purchase Date: 2017/1 | Category: Educational
Category -> GAMES:
Id: 6 | Name: Toy 6 | Price: 60 | Age: 1 | Purchase Date: 2016/6 | Category: Games
Category -> HOME:
Id: 9 | Name: Toy 9 | Price: 88 | Age: 5 | Purchase Date: 2017/7 | Category: Home
Id: 3 | Name: Toy 3 | Price: 74 | Age: 5 | Purchase Date: 2016/12 | Category: Home
Id: 8 | Name: Toy 8 | Price: 84 | Age: 4 | Purchase Date: 2017/8 | Category: Home
Category -> BATTERYOPERATED:
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated

Old Stock more than 2016/1
Id: 2 | Name: Toy 2 | Price: 50 | Age: 3 | Purchase Date: 2015/6 | Category: Educational | Quantity: 4
Id: 4 | Name: Toy 4 | Price: 79 | Age: 3 | Purchase Date: 2015/8 | Category: Battery Operated | Quantity: 4

Toy with id: 5
Id: 5 | Name: Toy 5 | Price: 83 | Age: 5 | Purchase Date: 2019/8 | Category: Battery Operated

Process finished with exit code 0

```



