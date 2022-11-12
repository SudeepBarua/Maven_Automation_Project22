package Day2_100222;

public class T4_WhileLoop_LinearArray {
    public static void main(String[] args) {
        //declare and define linear array for street number
        //only one variable here so you can identify and define in the same line
        int[] streetNumber = new int[]{111,333,444,555,666,777};// can we put spaces between integers
        //iterate through all street number by while loop
        //set the initializer
        int i = 0;
        //now set the condition for while loop
        //linear array gets the count by using .length command
        while(i < streetNumber.length){
            System.out.println("Street Number: " + streetNumber[i]);

            //incrementation goes at the end of the while loop
            i = i+1; //i+1 is the same as i++
        }//end of while loop

    }//end of main
}//end of java class
