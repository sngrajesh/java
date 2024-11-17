package Day04.labs.third;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("John", 30, new Address("Mumbai", "Maharashtra", 411046));
        Person p2 = new Person("John", 30, new Address("Pune", "Maharashtra", 41106));

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.hashCode() == p2.hashCode());  // true

        // Both objects have the same hash code
        System.out.println("HashCode of p1: " + p1.hashCode());
        System.out.println("HashCode of p2: " + p2.hashCode());

        Person p3 = (Person) p1.clone();

        System.out.println("Original: " + p1);
        System.out.println("Shallow Copy: " + p3);

        p3.setAddress(new Address("Satara", "Maharashtra", 4110144));

        System.out.println("Original after modification: " + p1);
        System.out.println("Shallow Copy after modification: " + p3);

    }
}