package Day2.lab.second;

import day1.lab.fourth.Date;

public class Math {


    public static int incrementNumber(int num){
        num +=1;
        return num;
    }

    public static void incrementDate(Date d) {
        d.setDay(d.getDay()+1);
    }

    public static void swapDates(Date d1, Date d2){
        Date t = d1;
        d1 = d2;
        d2 = t;
    }


    public static void bubbleSort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j=i; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }



    public static void main(String[] args) {
        // Pass by value
        System.out.println("\nPass by value");
        int n = 10;
        System.out.println(n);
        n = incrementNumber(n);
        System.out.println(n);

        // Pass by reference
        System.out.println("\nPass by Reference");
        Date d = new Date();
        d.setDay(21);
        d.setMonth("Jan");
        d.setYear(2022);
        System.out.println(d);
        incrementDate(d);
        System.out.println(d);

        // Pass by reference but not get affected
        System.out.println("\nPass by Reference for swap");
        Date d1 = new Date();
        d1.setDay(21);
        d1.setMonth("Jan");
        d1.setYear(2022);
        Date d2 = new Date();
        d2.setDay(12);
        d2.setMonth("Feb");
        d2.setYear(2022);
        System.out.println(d1 + "\n" + d2);
        swapDates(d1, d2);
        System.out.println(d1 + "\n" + d2);

        // Pass By Reference
        System.out.println("\nPass by reference for array");
        int arr1[] = {3,1,2,4,53,2,4,67};
        for (int k : arr1) System.out.print(k + " ");
        System.out.println();
        bubbleSort(arr1);
        for (int j : arr1) System.out.print(j + " ");
    }
}
