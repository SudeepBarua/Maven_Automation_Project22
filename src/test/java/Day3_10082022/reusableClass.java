package Day3_10082022;

public class reusableClass {
    //create a void method that will add two numbers and execute the print statement
    //typing "static" makes the method reusable
    //"main" is an execution method
    //any word after void besides main would be a custom method and can be REUSABLE
    public static void addTwoNumbers(int a, int b) {
        int result = a + b;
        System.out.println("The result is " + result);
    }//end of addTwoNumbers

        //create a return method that will add two numbers and return the result from the print statement
        public static int returnAddTwoNumbers(int a, int b) {
            int result = a + b;
            System.out.println("The return result is " + result);
            return result;

    }//end of returnTwoAddNumbers
}// end of java class

