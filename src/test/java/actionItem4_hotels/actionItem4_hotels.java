package actionItem4_hotels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class actionItem4_hotels {
    public static void main(String[] args) throws InterruptedException {
        //setup wdm
        WebDriverManager.chromedriver().setup();
        //setup chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized and incognito
        options.addArguments("start-maximized", "incognito");
        //create new chrome driver and pass options
        WebDriver driver = new ChromeDriver(options);

        //create array list of states
        ArrayList<String> states = new ArrayList<>();
        states.add("New York");
        states.add("Colorado");
        states.add("Texas");
        //array list of adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);
        //array list of child age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("Under 1");
        childAge.add("1");
        childAge.add("2");

        for(int i=0; i<states.size(); i++){

                driver.navigate().to("https://www.Hotels.com");
            try {
                //click on "going to"
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                //type in state
                driver.findElement(By.xpath("//*[@class='uitk-field-input uitk-typeahead-input uitk-typeahead-input-v2']")).sendKeys(states.get(i));
                //wait 1 sec
                Thread.sleep(2000);
                //click on first option, first we must use array list
                ArrayList<WebElement> destination = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-typeahead-button-label truncate']")));
                destination.get(0).click();
                //wait 1 sec
                Thread.sleep(1000);
            }catch(Exception e){
               System.out.println("Error with destination" + e);
           }

            //click on travelers
            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
                //wait 1 sec
                Thread.sleep(1000);
                //set adults to 1
            }catch(Exception e){
                System.out.println("Error with Travelers" +e);
            }

            ArrayList<WebElement> sign = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
                sign.get(0).click();
                //click on done
            try {
                driver.findElement(By.xpath("//*[@id ='traveler_selector_done_button']")).click();
                //wait a sec
                Thread.sleep(1000);
                //click on travelers
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
                //wait 1s
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Unable to click on travelers again" + e);
            }

            //create a for loop logic by passing the adults array list in i < adults value
            for (int j = 1; j< adults.get(i); j++) {

                //click on plus adults
                sign.get(1).click();
            }//end of ADULTS for loop
            //delay 1s
            Thread.sleep(1000);
            //click on Children as one (Always)
            sign.get(3).click();
            //wait 1s
            Thread.sleep(1000);


            try {
                //Click on child age dropdown and use select command
                WebElement childAgeList = driver.findElement(By.xpath("//*[@id ='age-traveler_selector_children_age_selector-0-0']"));
                //wait 1s
                Thread.sleep(1000);
                //define the select command
                Select dropDown = new Select(childAgeList);
                //select the dropdown value by text
                dropDown.selectByVisibleText(childAge.get(i));
            }catch (Exception e){
                System.out.println("Unable to click on age drop down " + e);
            }

            //wait 1s
            Thread.sleep(2000);
            try {
            //click the done button
               driver.findElement(By.xpath("//*[@id ='traveler_selector_done_button']")).click();
               //click on search
               driver.findElement(By.xpath("//*[@class ='uitk-icon uitk-icon-leading uitk-icon-medium']")).click();
           }catch (Exception e){
               System.out.println("unable to click done or search" +e);
           }
            //wait few seconds
            Thread.sleep(2000);

            //start if statement
            if (i==0){
                //declare link
               try {
                   ArrayList<WebElement> link = new ArrayList<>(driver.findElements(By.xpath("//*[@rel='noopener noreferrer']")));
                   //click on first link
                   link.get(1).click();
                   //capture the tabs as array list
                   //wait 2 sec
                   Thread.sleep(2000);
                   ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                   //switch to the new tab
                   driver.switchTo().window(tabs.get(1));
                   //capture the name of the resort
                   String resort1 = new String(driver.findElement(By.xpath("//*[@class= 'uitk-heading uitk-heading-3']")).getText());
                   //print it
                   System.out.println("The name of the first resort link in " + states.get(i) + " is: " + resort1);
                   //delay 2s
                   Thread.sleep(2000);
                   //click on reserve a room
                   driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
                   //capture first price
                   ArrayList<WebElement> price1 = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")));
                   //Print first price for room
                   System.out.println("The first price per night here is: " + price1.get(0).getText());
                   //delay 2s
                   Thread.sleep(2000);
                   //click on the reserve button
                   driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(0).click();
                   //wait 1 sec
                   Thread.sleep(2000);
                   //capture check in and check out
                   String details = new String(driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText());
                   //print it out
                   System.out.println("The check in and check out dates for this hotel are: ");
                   System.out.println(details);
                   //close tab
                   driver.close();
                   //switch to parent tab
                   driver.switchTo().window(tabs.get(0));
               }catch (Exception e){
                   System.out.println("Error with New York reserve " + e);
               }

            } else if (i==1) {
                //declare link
               try{
                ArrayList<WebElement> link = new ArrayList<>(driver.findElements(By.xpath("//*[@rel='noopener noreferrer']")));
                //click on third link
                link.get(3).click();
                //wait 2 sec
                Thread.sleep(2000);
                //capture the tabs as array list
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to the new tab
                driver.switchTo().window(tabs.get(1));
                //capture the name of the resort
                String resort2 = new String(driver.findElement(By.xpath("//*[@class= 'uitk-heading uitk-heading-3']")).getText());
                //print it
                System.out.println("The name of the third resort link in " + states.get(i) + " is: " +resort2 );
                //delay 2s
                Thread.sleep(2000);
                //click on reserve a room
                driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
                //capture first price
                ArrayList<WebElement> price2 = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")));
                //Print first price for room
                System.out.println("The first price per night here is: " + price2.get(0).getText());
                //delay 2s
                Thread.sleep(2000);
                //click on reserve
                driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(0).click();
                //wait 1 sec
                Thread.sleep(1000);
                //click on pay now
                driver.findElements(By.xpath("//*[@type='submit']")).get(2).click();
                //wait 2 sec
                Thread.sleep(2000);
                //capture check in and check out
                String details = new String(driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText());
                //print it out
                System.out.println("The check in and check out dates for this hotel are: " );
                System.out.println(details);
                //close tab
                driver.close();
                //switch to parent tab
                driver.switchTo().window(tabs.get(0));
               }catch (Exception e){
                   System.out.println("Error with Colorado reserve " + e);
               }

            }else{

                try{
                //declare link
                ArrayList<WebElement> link = new ArrayList<>(driver.findElements(By.xpath("//*[@rel='noopener noreferrer']")));
                //click on second link
                link.get(2).click();
                //wait 2 sec
                Thread.sleep(2000);
                //capture the tabs as array list
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to the new tab
                driver.switchTo().window(tabs.get(1));
                //capture the name of the resort
                String resort3 = new String(driver.findElement(By.xpath("//*[@class= 'uitk-heading uitk-heading-3']")).getText());
                //print it
                System.out.println("The name of the second resort link in " + states.get(i) + " is: " +resort3 );
                //delay 2s
                Thread.sleep(2000);
                //click on reserve a room
                driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
                //capture first price
                ArrayList<WebElement> price3 = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")));
                //Print first price for room
                System.out.println("The first price per night here is: " + price3.get(0).getText());
                //delay 2s
                Thread.sleep(2000);
                //click on reserve
                driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(0).click();
                //wait 2 sec
                Thread.sleep(1000);
                //click on pay now
                driver.findElements(By.xpath("//*[@type='submit']")).get(2).click();
                //wait 2 sec
                Thread.sleep(2000);
                //capture check in and check out
                String details = new String(driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText());
                //print it out
                System.out.println("The check in and check out dates for this hotel are: " );
                System.out.println(details);
                //close tab
                driver.close();
                //switch to parent tab
                driver.switchTo().window(tabs.get(0));
                }catch (Exception e){
                    System.out.println("Error with Texas reserve " + e);
                }
            }

        }//end of STATES for loop
        driver.quit();
    }//end of main
}//end of java class
