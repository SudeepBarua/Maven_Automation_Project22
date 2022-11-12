package zzzzzPRACTICE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class findElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        //assigning ChromeOptions to "options"

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);



        driver.navigate().to("https://www.yahoo.com");
        driver.findElements(By.xpath("//*[@class='_yb_sc88r ']")).get(1).click();





    }
}//end of java class
