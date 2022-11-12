package Day11_11052022;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;


    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    //test case 1 should verify the total count of the displayed menu headers
    @Test(priority = 1)
    public void tc001_verifySignInOptionIsChecked(){
        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in button
        ReusableActions.clickAction(driver, "//*[@class = '_yb_1933e']", "Sign in Button");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test 1

    //click on the first drop down
    @Test(priority = 2)
    public void tc002_verifySignInOptionIsUnchecked() {
        //click on check box to uncheck it
        ReusableActions.clickAction(driver, "//*[@class = 'stay-signed-in checkbox-container']", "SignedInCheckBox");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " +isSignInChecked);
    }//end of test 2


}//end of Java Class
