package Day8_10232022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_actionItem3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized", "incognito");
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
        childAge.add("2");
        childAge.add("3");
        childAge.add("5");


        for (int i = 0; i < states.size(); i++) {
            //navigate to mortgage calculator website
            driver.navigate().to("https://hotels.com");
            //delay 2s
            Thread.sleep(2000);
            //find destination button
            try {
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                //enter ith index of states into field
                driver.findElement(By.xpath("//*[@id ='destination_form_field']")).sendKeys(states.get(i));
                //ArrayList
                ArrayList<WebElement> searchResult = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'is-subText truncate']")));
                searchResult.get(0).click();
            } catch (Exception e) {
                System.out.println("Destination error" + e);
            }//end of catch
            //delay 1s
            Thread.sleep(1000);

            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
                Thread.sleep(2000);
                //set adult size to 1
                ArrayList<WebElement> minus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
                minus.get(0).click();
                //click done button
                //driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Traveler error" + e);
            }//end of catch

            for (int j = 1; j < adults.get(i); j++) {
                //clicking on plus sign
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();

                //click done button
                // driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
                Thread.sleep(2000);

            }//end of adults for loop
            //increase child count to 1
            driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
            //starting select command for child age
            WebElement age = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
            Thread.sleep(1000);
            Select dropDownChildAge = new Select(age);
            dropDownChildAge.selectByVisibleText(childAge.get(i));
            Thread.sleep(2000);

            //clicking on done
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();

        }//end of states for loop


    }//end of main
    }//end of java class