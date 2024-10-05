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


