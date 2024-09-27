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
