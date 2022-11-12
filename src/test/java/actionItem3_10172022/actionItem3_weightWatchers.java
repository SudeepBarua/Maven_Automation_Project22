package actionItem3_10172022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class actionItem3_weightWatchers {
    public static void main(String[] args) throws InterruptedException {
        //define web driver manager setup for chrome driver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing chrome window and incognito
        options.addArguments("start-maximized", "incognito");
        //define chromedriver and pass options into the method
        WebDriver driver = new ChromeDriver(options);

        //create set of arrayList for zipCodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11801");
        zipCode.add("11432");
        zipCode.add("11706");

        //initiate for loop
        for(int i =0; i< zipCode.size(); i++) {
            //navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait a few seconds
            Thread.sleep(1000);
            //Click on find a workshop
            driver.findElements(By.xpath("//*[text() = 'Find a Workshop']")).get(0).click();
            //click on in-person link
            driver.findElement(By.xpath("//*[text() = 'In-Person']"));
            //wait 2 sec
            Thread.sleep(2000);
            //clear the field and enter zipcode
            WebElement searchField = driver.findElements(By.xpath("//*[contains(@class,'3TfT5')]")).get(1);
            searchField.clear();
            searchField.sendKeys(zipCode.get(i));
            //click on search arrow
            driver.findElement(By.xpath("//*[contains(@class, 'cta-1JqRp')]")).click();
            //Wait 2 sec
            Thread.sleep(2000);
            //store driver.findElement in WebElement
            ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkUnderline-1_h4g']")));
            //click on specific studio link
            if (i==0){
                links.get(1).click();
                //wait two seconds
                Thread.sleep(2000);
                //get address and print it
                String address1 = driver.findElement(By.xpath("//*[text()= '60 Manetto Hill Mall']")).getText();
                String address2 = driver.findElement(By.xpath("//*[text()= 'PLAINVIEW, NY 11803']")).getText();
                System.out.println("A WeightWatchers near " +zipCode.get(0) + " is " + address1 + " " +address2 );
                //scroll down
                WebElement workshops = driver.findElement(By.xpath("//*[@class = 'title-bEfSM']"));
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].scrollIntoView(true);", workshops);
                //capture table
                String table = driver.findElements(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']")).get(0).getText();
                //print table
                System.out.println("and the Studio Workshops schedule is ");
                System.out.println(table);


            }else if (i==1){
                links.get(2).click();
                //wait two seconds
                Thread.sleep(2000);
                //capture address and print it
                String address3 = driver.findElement(By.xpath("//*[text() = '721 Hillside Ave PC Richards Shopping Center']")).getText();
                String address4 = driver.findElement(By.xpath("//*[text() = 'NEW HYDE PARK, NY 11040']")).getText();
                System.out.println("A WeightWatchers near " +zipCode.get(1) + " is " + address3 + " " +address4 );
                //scroll down
                WebElement workshops = driver.findElement(By.xpath("//*[@class = 'title-bEfSM']"));
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].scrollIntoView(true);", workshops);
                //capture table
                String table = driver.findElements(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']")).get(0).getText();
                //print table
                System.out.println("and the Studio Workshops schedule is ");
                System.out.println(table);


            }else {
                links.get(0).click();
                //wait two seconds
                Thread.sleep(2000);
                //capture address and print it
                String address5 = driver.findElement(By.xpath("//*[text() = '569 E Main St']")).getText();
                String address6 = driver.findElement(By.xpath("//*[text() = 'BAY SHORE, NY 11706']")).getText();
                System.out.println("A WeightWatchers near " +zipCode.get(2) + " is " + address5 + " " +address6 );
                //scroll down
                WebElement workshops = driver.findElement(By.xpath("//*[@class = 'title-bEfSM']"));
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].scrollIntoView(true);", workshops);
                //capture table
                String table = driver.findElements(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']")).get(0).getText();
                //print table
                System.out.println("and the Studio Workshops schedule is ");
                System.out.println(table);

            }//end of if else
        }//end of for loop

        driver.quit();
    }//end of main
}//end of java class
