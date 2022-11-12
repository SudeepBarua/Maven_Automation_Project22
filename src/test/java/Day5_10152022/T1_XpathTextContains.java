package Day5_10152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        //define the WebDriver
        WebDriver driver = new ChromeDriver();

        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //maximize the driver
        driver.manage().window().maximize();

        //Using text instead of class, Id, Name, any variable tag with a VALUE...REMOVE THE @ SYMBOL
        //  //*[NO@
        //using multiple SPACES within the format of the xpath WONT MESS IT UP
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();

        //Wait 2 seconds
        Thread.sleep(2000);

        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        //click on bell icon
        driver.findElement(By.xpath("//*[contains(@class, 'rapid-nonanchor')]")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //quit chrome
        driver.quit();
    }
}//end of java class
