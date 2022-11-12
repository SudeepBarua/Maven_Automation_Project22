package Day4_10092022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T4_GoogleSearch_DataDrivenTesting {

        public static void main(String[] args) throws InterruptedException {

            //arrayList for Cars
            ArrayList<String> cars = new ArrayList<>();
            cars.add("BMW");
            cars.add("Audi");
            cars.add("Mercedes");


            //define the webdriver manager setup for chromedriver
            WebDriverManager.chromedriver().setup();
            //define the chrome driver to use for your test
            //creating an instance for a chrome driver (browser) to use for automation
            WebDriver driver = new ChromeDriver();

            //have to put the for loop outside of the webdrivers^^^ because it will create a new webdriver for every instance
            for (int i = 0; i < cars.size(); i++) {


                //navigate to the google site
                driver.navigate().to("https://www.google.com");

                //maximize my window
                driver.manage().window().maximize();

                //sleep statement
                Thread.sleep(3000);
                //pauses it for 3 seconds so the browser is fully loaded and ready for the next inputs to register
                //if its still loading and you click on something it wont be there for it to click

                //search a keyword on the search field
                //relative xpath to locate the element
                driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
                //whatever you google search should start with a lowercase letter or else it won't show the result number
                //we're putting cars.get(i) instead of "cars" to feed the array list into the code

                //hit submit on the google search button
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
                //.submit is when you need to hit enter and the button you need to click on is being blocked by something
                //^^^ONLY WHEN UR SEARCHING FOR SOMETHING
                //.click is when you need to click it
                //.sendkeys is when you have to type keys

                //sleep statement because we're doing something new on a new page
                Thread.sleep(3000);

                //capture the search result text
                String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                //split message to extract out the search number
                String[] splitResult = result.split(" ");
                //had to split the result by spaces
                System.out.println("The search number is for " + cars.get(i) + " is " + splitResult[1]);
                //splitResult[1] was the second index number of search result


            }//end of for loop


            driver.quit();
            //quit the driver
        } // end of main
    }//end of java class
