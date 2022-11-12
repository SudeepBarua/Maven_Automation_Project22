package zzzzzPRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriverManager {
    public static void main(String[] args) {

        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        //this is called chrome options
        ChromeOptions options = new ChromeOptions();

        //assigning ChromeOptions to "options"

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);






        driver.navigate().to("https://www.polandspring.com");
        driver.findElement(By.xpath("//*[text()= 'Shop Spring Water']")).click();

        List<WebElement> instagram = driver.findElements(By.xpath("//*[@class='_yb_sc88r ']"));
        instagram.get(1).click();
        //WebElement only uses to make a locator a variable
        //Only use locators in WebElement



        String title = driver.getTitle(); // Spring water | Poland Spring

        if(title.equals("Spring water | Poland Spring")){
            System.out.println("Title is correct ");
        }else{
            System.out.println("Title is wrong and the correct title is " + title);
        }//end of if

driver.quit();

    }//end of main
}//end of java class
