package Day01.lab.second;

public class Math {
    public static long factorial(int num) {
        long ans = 1L;
        for(int i =1; i <= num; i++){
            ans*= i;
        }
        return ans;
    }

    public static boolean isPrime(int num) {
        for(int i =2; i < num; i++)
            if((num % i) == 0)
                return false;
        return true;
    }


    // Method overloading with different parameters are allowed but not allowed with (same parameter and different return type)
    public static float sum(int a, float b){
        return (float)a+b;
    }
    public static float sum(float a, float b){
        return a+b;
    }
    public static float sum(float a, int b){
        return a+(float)b;
    }
    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    // This will give error
    // public static float sum(int a, float b){
    //     return (float) a+b;
    // }

    // Variable arguments
    public static int sum(int ...num){
        int ans = 0;
        // for(int i = 0; i < num.length; i++) ans+=num[i];
        for (int j : num) ans += j;
        return ans;
    }

    public static void main(String[] args) {
        for(int i = 2; i < 20; i++){
            String isPrm = Math.isPrime(i) ? "Prime": "Non-Prime";
            System.out.println("The "+ i+ " is "+ isPrm);
        }
        for(int i = 2; i < 20; i++){
            long fact = Math.factorial(i);
            System.out.println("The factorial of "+ i+ " is "+ fact);
        }
        System.out.println("Sum is: " +  sum(1,2,3,4,5,5));
    }
}
