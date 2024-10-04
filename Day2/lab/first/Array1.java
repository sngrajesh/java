package Day2.lab.first;
import Day1.lab.first.Date;

class Array1 {
    public static void main(String[] args) {
        // First class object in java
        int arr1[] = {1,2,3,4,5,6};
        for (int i = 0; i < arr1.length; i++){
            System.out.print(i);
            System.out.println((arr1[i]%2==1) ? "Odd" : "Even");
        }

        Date date[] = new Date[3];
        date[0] = new Date();
        date[1] = new Date();
        date[2] = new Date();
        for(Date d : date){
            d.displayDate();
        }
    }
}
