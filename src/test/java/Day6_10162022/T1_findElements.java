package Day6_10162022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_findElements {
    public static void main(String[] args) throws InterruptedException {
        //define the webDriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add the options for maximizing the chrome meeting
        options.addArguments("start-maximized");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver (browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //navigate to the google site
        driver.navigate().to("https://www.yahoo.com");

        //wait few seconds
        Thread.sleep(3000);

        //using find elements I want to click on second link within the group which is News
        driver.findElements(By.xpath("//*[contains(@class, '_yb_sc88r')]")).get(1).click();




    }//end of main
}//end of java class
