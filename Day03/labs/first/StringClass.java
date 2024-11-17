package Day3.labs.first;
public class StringClass {
    public static void main(String[] args) {
        // Two String literals s1 and s2 with the same value "Java"
        String s1 = "Java";
        String s2 = "Java";
        System.out.print("s1.equals(s2) : " + s1.equals(s2) + "\ns1==s2 : ");
        System.out.println(s1==s2);
        // Since s1 and s2 point to the same object in the String Pool (due to string interning),
        // their hashCode() will be the same.
        System.out.println(s1.hashCode()); // Outputs the hash code of the string "Java"
        System.out.println(s2.hashCode()); // Outputs the same hash code as s1


        // Printing the identity hash code of s1 and s2
        // This will show whether they point to the same memory location
        System.out.println("s1 identity hash code: " + System.identityHashCode(s1));
        System.out.println("s2 identity hash code: " + System.identityHashCode(s2));

        s1 += " Oracle";
        System.out.println(s1);

        // Two new String objects n1 and n2 are created using the 'new' keyword.
        // Even though they have the same value "Hello", they are distinct objects in memory (in heap memory).
        String n1 = new String("Hello");
        String n2 = new String("Hello");
        System.out.print("n1.equals(n2) : " + n1.equals(n2) + "\nn1==n2 : ");
        System.out.println(n1==n2);
        // hashCode() for n1 and n2 will be the same because hashCode() is based on the string's content,
        // but the actual objects in memory are different.
        System.out.println(n1.hashCode()); // Outputs the hash code of the string "Hello"
        System.out.println(n2.hashCode()); // Outputs the same hash code as n1, even though they are different objects

        // Printing the identity hash code of n1 and n2
        // These will likely be different because 'new' creates separate objects in memory
        System.out.println("n1 identity hash code: " + System.identityHashCode(n1));
        System.out.println("n2 identity hash code: " + System.identityHashCode(n2));

        // n1.concat(" World");         // Not modify the original string
        n1 = n1.concat(" World");
        System.out.println(n1);
    }
}
