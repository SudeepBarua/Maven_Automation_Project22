package actionItem1_10022022;

import java.util.ArrayList;

public class Country_ArrayList {
    public static void main(String[] args) {
        //declare and define arrayList for country
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("China");
        country.add("Singapore");
        country.add("Italy");

        //declare and define arrayList for countryCode
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(86);
        countryCode.add(65);
        countryCode.add(39);

        //call for loop to print out country and countryCode
        for(int i=0; i<country.size(); i++){
            //print out 4 data for each variable and iterate through each to print out the i for both variables
            System.out.println("My country is " + country.get(i) + " and my country code is: " + countryCode.get(i));

        }//end of for loop

    }//end of main
}//end of Java Class
