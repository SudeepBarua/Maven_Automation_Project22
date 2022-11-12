package actionItem1_10022022;

public class regionAndAreaCode_linearArray {
    public static void main(String[] args) {
       // declare and define linear array for region
    String[] region = new String[]{"New York", "California", "Texas", "Pennsylvania"};
    // declare and define linear array for areaCode
        int[] areaCode = new int[]{212,213,214,215};
        //iterate through all region and areaCode by while loop
        //set the initializer
        int i=0;
        //now set the condition for while loop
        //linear array gets the count by using .length command
        while(i < areaCode.length){
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
            //incrementation goes at the end of the while loop
            i++;
        }//end of while loop
    }//end of main
}//end of java class
