package Day06.home.assig1;

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
