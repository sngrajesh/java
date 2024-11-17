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

