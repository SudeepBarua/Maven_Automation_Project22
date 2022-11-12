package Day4_10092022;

public class T1_SplitCommand {
    public static void main(String[] args) {
        //declare a string variable
        String message = "My name is John";
        //extract out John from the string and print it
        //call split message by using String array
        String[] splitMessage = message.split(" ");
        //there is a space between each word so we put a space between the quotes in regex
        System.out.println("result: " + splitMessage[3]);
        //when you split something it becomes an array, everytime you split a comment you need to define an array variable using []
        //if you have String message = "My name is_John" and want just john,
        //  then you would put "_" inside message split so "My name is" would have an index of [0] and john would be index of [1]


        //extracting each character from a string
        String message2 = "abc";
        String[] splitMessage2 = message2.split("");
        //There was no space between the quotes in regex so we are splitting by nothing, allowing abc to be split to different array index number
        System.out.println("Index 2 is: " + splitMessage2[1]);


    }//End of main
}//End of java class