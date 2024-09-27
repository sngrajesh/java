package Day5.labs.first;

import java.io.File;
import java.io.IOException;

public class CreateExceptionUsingThrow {
    public static void checkFile1(String path) throws IOException {
        File f = new File(path);
        if(!f.exists())
            throw new IOException("File not found - 1");
    }

    public static void checkFile2(String path) {
        try {
            File f = new File(path);
            if(!f.exists())
                throw new IOException("File Not found - 2");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filename = "data.txt";

        // Checked Exception is always handled using try-catch block in somewhere in the code

        // Example 1
        try {
            checkFile1(filename);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        // Example 2
        checkFile2(filename);

    }
}
