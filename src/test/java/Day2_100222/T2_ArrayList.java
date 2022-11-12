package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {

        //declare and define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //now add the values for countries array
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");

        //print usa from the countries list
        System.out.println("Countries value: " + countries.get(0));
        //in arrays we use the get command because it goes by size, thats why its called resizable
        System.out.println("Countries count: " + countries.size());
        // how do you get count? say whatever the variable is and add .size
        //and to get a specific variable just type the variable and add .get

        //call an integer array list  for streetNumber
        //you have to type the integer fully
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(222);
        streetNumber.add(333);
        System.out.println("First Street Number: " + streetNumber.get(0));


    }//end of main
}//end of java class
