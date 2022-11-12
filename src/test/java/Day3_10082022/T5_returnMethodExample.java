package Day3_10082022;

public class T5_returnMethodExample {
    public static void main(String[] args) {
        //the result of return method is equal to the value you stored in the new variable
        //store the method into a variable WHOLE POINT OF RETURN
        int value = reusableClass.returnAddTwoNumbers(5,3);
        //now you can set additional calculation to the value
        //Lets you mess around with the new Value to add new info
        System.out.println("new value is " + (value+3));
    }//end of main
}//end of java class
