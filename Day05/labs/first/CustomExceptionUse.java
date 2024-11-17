package Day05.labs.first;

public class CustomExceptionUse {
    public static String convertToLowerCase(String str) throws CustomException {
        if(str.isEmpty())
            throw new CustomException("String cannot be empty");
        else
            return str.toLowerCase();

    }

    public static void main(String[] args) {
        //Custom Exception is always handled using try-catch block in somewhere in the code
        try {
            String str = "Hello World";
            String lowerCase = convertToLowerCase(str);
            System.out.println(lowerCase);
        } catch (CustomException e) {
            System.out.println("Exception caught : " + e.getMessage());
        }


        try {
            String str = "";
            String lowerCase = convertToLowerCase(str);
            System.out.println(lowerCase);
        }   catch (CustomException e) {
            System.out.println("Exception caught : " + e.getMessage());
        }


    }

}
