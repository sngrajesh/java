package Day03.labs.first;
import java.util.Arrays;

public class StringMthods {

    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        char s3[] = s1.toCharArray();
        char s4[] = s2.toCharArray();
        Arrays.sort(s3);
        Arrays.sort(s4);
        for(int i = 1; i < s3.length; i++ ){
            if(s3[i] != s4[i])
                return false;
        }
        return true;
    }

    public static void countAllChars(String s){
        int upper = 0;
        int lower = 0;
        int special = 0;

        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                lower++;
            } else if (ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if (!(ch >= '1' && ch <= '9')) {
                special++;
            }
        }
        System.out.println("upper : " + upper + " lower : " + lower + " special : " + special);
    }

    public static boolean isUpperCase(String s){
        for(char ch : s.toCharArray()){
            if(!('A' <= ch  && ch <= 'Z')) {
                return false;
            }
        }
        return true;
    }

    public static String shiftLeft(String s){
        char s6[] = s.toCharArray();
        StringBuilder s7 = new StringBuilder("");
        for(int i = 1; i < s6.length; i++ ){
            s7.append(s6[i]);
        }
        return s7.toString();
    }



    public static boolean isEquals(String s1, String s2){
        if(s1.length() != s2.length()){
            System.out.println("Not Equal");
        }
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                System.out.println("Not Equal");
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualsInoreCase(String s1, String s2){
        if(s1.length() != s2.length()){
            System.out.println("Not Equal");
        }
        for(int i = 0; i < s1.length(); i++){
            if(s1.toLowerCase().charAt(i) != s2.toLowerCase().charAt(i)){
                System.out.println("Not Equal");
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        // Two string are anagram or not
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(isAnagram(s1,s2));

        // Count no. of upper,lower,special cases in string
        String s3 = "SaFsdvDNfbdb@24$%";
        countAllChars(s3);

        // Check string is uppercase
        String s4 = "HELlO";
        System.out.println( "Is "+ s4 + " is uppercase " + isUpperCase(s4));


        // Shift characters of String to the left
        String s5 = "fsldvjn";
        System.out.println(s5+ " Left shift is " + shiftLeft(s5));



        //Implement equals and equalsIgnoreCase method
        String s6 = "osdfkbm";
        String s7 = "osdFkbm";
        System.out.println(isEquals(s6,s7));
        System.out.println(isEqualsInoreCase(s6,s7));


    }
}



