package actionItem2_10092022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class actionItem2_bingSearch {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Basketball");
        sports.add("Lacrosse");
        sports.add("Tennis");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        for (int i = 0; i < sports.size(); i++) {
            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            driver.findElement(By.xpath("//*[@viewBox='0 0 25 25']")).click();
            Thread.sleep(3000);

            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            String[] splitResult = result.split(" ");
            System.out.println("When I searched up the sport " + sports.get(i) + ", I found " + splitResult[0] + " results!");

        }//end of for loop
        driver.quit();
    }//end of main
}//end of java class
