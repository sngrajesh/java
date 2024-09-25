### Step 1: Create `Date.java` in Folder1
1. Create a folder named `Folder1`.
2. Inside `Folder1`, create a Java file called `Date.java` with the following content:

```java
// File: Folder1/Date.java
package com.myproject;

public class Date {
    public void displayDate() {
        System.out.println("Date class from com.myproject package.");
    }
}
```

### Step 2: Create `Calender.java` in Folder2
1. Create another folder named `Folder2`.
2. Inside `Folder2`, create a Java file called `Calender.java` with the following content:

```java
// File: Folder2/Calender.java
package mypack;

import com.myproject.Date;

public class Calender {
    public static void main(String[] args) {
        Date date = new Date();
        date.displayDate();
        System.out.println("Calender class from mypack package.");
    }
}
```

### Step 3: Compile `Date.java`
1. Open the command prompt and navigate to `Folder1`:
   ```bash
   cd Folder1
   ```
2. Use the `-d` option to specify the destination for the compiled `.class` files:
   ```bash
   javac -d . Date.java
   ```
3. After compilation, you should see the following directory structure:
   ```
   Folder1
   ├── com
       └── myproject
           └── Date.class
   ```

### Step 4: Set the Classpath for `Folder1`
1. Navigate to the parent directory of `Folder1` and `Folder2` and set the classpath for `Folder1`:
   ```bash
   set classpath=../../Folder1;
   ```

### Step 5: Compile `Calender.java`
1. Now, navigate to `Folder2`:
   ```bash
   cd ../Folder2
   ```
2. Compile `Calender.java` using the `-d` option:
   ```bash
   javac -d . Calender.java
   ```
3. After compilation, you should see the following directory structure:
   ```
   Folder2
   ├── mypack
       └── Calender.class
   ```

### Step 6: Run the `Calender` class
1. Finally, run the `Calender` class from `Folder2`:
   ```bash
   java mypack.Calender
   ```

### Expected Output:
```
Date class from com.myproject package.
Calender class from mypack package.
```

