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


