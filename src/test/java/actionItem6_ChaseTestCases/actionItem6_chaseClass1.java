package actionItem6_ChaseTestCases;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class actionItem6_chaseClass1 extends Reusable_Annotations {

    @Test(priority = 1)
    public void tc001_penaltyFeesOfChaseSapphirePreferred() throws InterruptedException {
        //Users should be on Chase's credit card page
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //users should locate chase Sapphire preferred
        ArrayList<WebElement> sapphire = new ArrayList<>(driver.findElements(By.xpath("//*[@data-pt-name='cc_sapphire_res_allcc_name']")));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", sapphire.get(0));
        Thread.sleep(1000);
        //users should click on pricing and terms
        ReusableActions_Loggers.clickAction(driver, "//*[@data-pt-name='cc_sapphire_res_allcc_priceterm']", logger, "Pricing and Terms");
        Thread.sleep(3000);
        //go back to original tab
        ReusableActions_Loggers.switchToTabByIndex(driver, 0);
        Thread.sleep(1000);
    }//end of test 1



    @Test(priority = 2)
    public void t002_selectCreditCardBrand() throws InterruptedException {
        int j;
        int timeout = 30;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //create for loop in order to show that every card brand link works
        for(j=14; j<27; j++) {
            //Users should be on Chase's credit card page
            driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
            //click on card brands
            ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='dropdown-toggle collapsed']", 1, logger, "Card Brands");
            Thread.sleep(2000);

            ArrayList<WebElement> brandLinks = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='subnav-item']"))));

            brandLinks.get(j).click();
            Thread.sleep(2000);
        }//end of for loop
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on card brands
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='dropdown-toggle collapsed']", 1, logger, "Card Brands");
        Thread.sleep(2000);
        //print out all the available card brands the credit cards are divided into
        String brands = ReusableActions_Loggers.getTextActionByIndex(driver, "//*[@class='col-12 position-relative']", 1, logger, "Brands Text");
        System.out.println("ALL THE CREDIT CARD BRANDS CHASE OFFERS ARE: " + brands + " AND ALL OF THESE BRANDS ARE CLICKABLE LINKS THAT WILL REDIRECT YOU");
    }//end of test 2

    @Test(priority = 3)
    public void t003_allCardCategories() throws InterruptedException {
        int j;

        for(j=0; j<14; j++) {
            //navigate to chase
            driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
            //click on card categories drop down
            ReusableActions_Loggers.clickAction(driver, "//*[@id='submenu-collapse-control']", logger, "Card Categories Dropdown");
            Thread.sleep(2000);
            //click on every card category
            ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='subnav-item']", j, logger, "Card Category ");
            Thread.sleep(1000);
        }//end of for loop
        //navigate to chase
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on card categories drop down
        ReusableActions_Loggers.clickAction(driver, "//*[@id='submenu-collapse-control']", logger, "Card Categories Dropdown");
        //print all the card categories
        String categories = ReusableActions_Loggers.getTextAction(driver, "//*[@class='dropdown collapse show']", logger, "Card Category Names");
        System.out.println("ALL THE CARD CATEGORIES CHASE OFFERS ARE: " + categories + " AND ALL THE CATEGORIES ARE CLICKABLE LINKS ");
    }//end of test 3

}//end of java class

