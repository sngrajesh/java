package Day6.labs.first;

public class BounedGenerics<T extends Number> {
    T[] data;

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public double getAverage() {
        double sum = 0;
        for (T t : data) {
            sum += t.doubleValue();
        }
        return sum / data.length;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};

        BounedGenerics<Integer> intBouned = new BounedGenerics<>();
        intBouned.setData(intArray);
        System.out.println("Average of Integer Array: " + intBouned.getAverage());

        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        BounedGenerics<Double> doubleBouned = new BounedGenerics<>();
        doubleBouned.setData(doubleArray);
        System.out.println("Average of Double Array: " + doubleBouned.getAverage());
    }
}
