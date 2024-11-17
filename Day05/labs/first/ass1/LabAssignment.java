package Day05.labs.first.ass1;

import java.util.Scanner;

public class LabAssignment {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int num = sc.nextInt();
            if (num > 60000) {
                throw new Exception("Number cannot be greater than 60000");
            }
            System.out.println("Number "+ num +" is valid");
        } catch (Exception e) {
            System.out.println("Exception caught : " + e.getMessage());
        }
    }
}
