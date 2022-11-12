package Review_10052022;

import java.util.ArrayList;

public class reviewSession {
    public static void main(String[] args) {
        String[] carBrands;
        carBrands = new String[]{"Toyota","Honda","Acura","Audi","Infiniti"};
        int i=0;
        while(i < carBrands.length){
            System.out.println("My favorite car to drive is a " + carBrands[i]);
            i++;
        }//end of while loop
        ArrayList<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("3471238282");
        phoneNumber.add("5168282489");
        phoneNumber.add("9179298237");
        phoneNumber.add("5169298384");
        phoneNumber.add("3476216833");

        for(int j=0; j< phoneNumber.size(); j++){
            System.out.println("Hey! My phone number is " + phoneNumber.get(j));

        }//end of for loop

    }// end of main
}// end of java class
