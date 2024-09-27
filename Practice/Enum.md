Java enums can have functions, fields, and constructors, making them more powerful than enums in some other languages. Here's an example of a Java enum with functions:
Java
public enum Color {
RED("red", "#FF0000"),
GREEN("green", "#00FF00"),
BLUE("blue", "#0000FF");

    private final String name;
    private final String hexCode;

    // Constructor
    Color(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    // Function to get the name
    public String getName() {
        return name;
    }

    // Function to get the hex code
    public String getHexCode() {
        return hexCode;
    }

    // Function to print the color details
    public void printColorDetails() {
        System.out.println("Name: " + name + ", Hex Code: " + hexCode);
    }
}
In this example:
We define an enum Color with three values: RED, GREEN, and BLUE.
Each enum value has two fields: name and hexCode, which are initialized through the enum's constructor.
We define three functions: getName(), getHexCode(), and printColorDetails().
You can use the enum functions like this:
Java
public class Main {
public static void main(String[] args) {
Color color = Color.RED;

        System.out.println("Name: " + color.getName());
        System.out.println("Hex Code: " + color.getHexCode());
        color.printColorDetails();
    }
}
This will output:
Name: red
Hex Code: #FF0000
Name: red, Hex Code: #FF0000
Enums with functions are useful when you need to associate behaviors or computations with specific enum values. They promote code readability and maintainability by encapsulating related logic within the enum itself.