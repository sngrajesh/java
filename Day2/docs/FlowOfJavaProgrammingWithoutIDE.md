# How to compile and run a Java project using the terminal, creating packages and importing into other files in different packages:

**Step 1: Create a new directory for your project**

Open your terminal and create a new directory for your project. For example, let's call it "MyJavaProject":
```
mkdir MyJavaProject
```
**Step 2: Create a source directory**

Create a new directory called "src" inside the "MyJavaProject" directory:
```
mkdir MyJavaProject/src
```
**Step 3: Create packages and files**

Create a new package called "com.example.model" inside the "src" directory:
```
mkdir MyJavaProject/src/com/example/model
```
Create a new Java file called "User.java" inside the "com.example.model" package:
```
touch MyJavaProject/src/com/example/model/User.java
```
Add the following code to the "User.java" file:
```java
package com.example.model;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```
**Step 4: Create another package and file**

Create a new package called "com.example.service" inside the "src" directory:
```
mkdir MyJavaProject/src/com/example/service
```
Create a new Java file called "UserService.java" inside the "com.example.service" package:
```
touch MyJavaProject/src/com/example/service/UserService.java
```
Add the following code to the "UserService.java" file:
```java
package com.example.service;

import com.example.model.User;

public class UserService {
    public void printUserName(User user) {
        System.out.println("Hello, " + user.getName() + "!");
    }
}
```
**Step 5: Create a main class**

Create a new package called "com.example.main" inside the "src" directory:
```
mkdir MyJavaProject/src/com/example/main
```
Create a new Java file called "Main.java" inside the "com.example.main" package:
```
touch MyJavaProject/src/com/example/main/Main.java
```
Add the following code to the "Main.java" file:
```java
package com.example.main;

import com.example.model.User;
import com.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");
        UserService userService = new UserService();
        userService.printUserName(user);
    }
}
```
**Step 6: Compile the project**

Compile the entire project using the `javac` command:
```
javac -sourcepath MyJavaProject/src -d MyJavaProject/bin MyJavaProject/src/com/example/model/User.java MyJavaProject/src/com/example/service/UserService.java MyJavaProject/src/com/example/main/Main.java
```
This will create a new directory called "bin" inside the "MyJavaProject" directory, and compile all the Java files into `.class` files inside the "bin" directory.

**Step 7: Run the main class**

Run the "Main" class using the `java` command:
```
java -cp MyJavaProject/bin com.example.main.Main
```
This will output "Hello, John Doe!" to the terminal.

**Behind the scenes**

When you compile a Java project using the `javac` command, it creates a new `.class` file for each Java file in the specified source directory. The `-sourcepath` option tells `javac` where to find the source files, and the `-d` option specifies the output directory for the compiled `.class` files.

When you run a Java class using the `java` command, the JVM loads the specified class and executes its `main` method. The `-cp` option specifies the classpath, which is the list of directories and JAR files that the JVM searches for classes and packages.

In this example, we created three packages ("com.example.model", "com.example.service", and "com.example.main") and three Java files ("User.java", "UserService.java", and "Main.java"). We compiled the entire project using the `javac` command, and then ran the "Main" class using the `java` command. We also used the `import` statement to import classes from other packages, demonstrating how Java packages and imports work.

