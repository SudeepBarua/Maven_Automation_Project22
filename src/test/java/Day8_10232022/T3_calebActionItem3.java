package Day8_10232022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T3_calebActionItem3 {
    public static void main(String[] args) throws InterruptedException {

        //setup chrome driver using wdm
        WebDriverManager.chromedriver().setup();
        //declare and define a new chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);


        //create array list of states
        ArrayList<String> states = new ArrayList<>();
        states.add("New York");
        states.add("California");
        states.add("Texas");
        //array list of adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);
        //array list of child age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("1");
        childAge.add("1");
        childAge.add("2");


        for (int i=0;i<states.size();i++){
            //navigate to mortgage calculator website
            driver.navigate().to("https://hotels.com");
            //delay 2s
            Thread.sleep(2000);
            //set travelers adults to 1
            driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            Thread.sleep(2000);
            //click the minus button
            driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(0).click();
            Thread.sleep(2000);
            //click the done button
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();

            //find destination button
            driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
            //enter ith index of states into field
            driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(states.get(i));
            //delay 1s
            Thread.sleep(1000);
            //array list of search results
            ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='is-subText truncate']")));
            //click on the first search result
            searchResults.get(0).click();
            //click on travelers
            driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            Thread.sleep(1000);

            for (int j=0;j<(adults.get(i)-1);j++){
                driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(1).click();
            }//end of adults for loop
            //delay 1s
            Thread.sleep(1000);
            //increase child age to 1 only
            driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
            //web element of child age drop down
            WebElement childAgeDrop = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
            //delay 1s
            Thread.sleep(1000);
            //declare and define select

            Select childAgeDropDown = new Select(childAgeDrop);
            //select the ith index value
            childAgeDropDown.selectByVisibleText(childAge.get(i));
            //click the done button
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();

        }//end of states for loop


    }//end of main

}//end of class

