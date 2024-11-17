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
        Map<Category, HashMap<Toy, Integer>> groupByCategory = Inventory.groupBySpecificField(inventoryMap, Toy::getCategory);

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
                    + "\nMin Element: " +
                    Inventory.getMinElement(entry.getValue(), new ToyPriceComparator())
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
