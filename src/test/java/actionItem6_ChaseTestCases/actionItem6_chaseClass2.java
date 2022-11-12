package actionItem6_ChaseTestCases;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import zzzzzPRACTICE.Reusable;

import java.sql.SQLOutput;

public class actionItem6_chaseClass2 extends Reusable_Annotations {
    @Test (priority = 1)
    public void tc004_compareCreditCards() throws InterruptedException {
        //Users should be on Chase's credit card page
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on compare on the first credit card
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='bold-alt']", 1, logger, "Compare Check box");
        //click on compare cards
        ReusableActions_Loggers.clickAction(driver, "//*[@class='btn promo-btn compare-cards-button']", logger, "Compare Cards Button");
        Thread.sleep(2000);
        //click on add card
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@data-bs-target='#addCardModal']", 22, logger, "Add Card button");
        Thread.sleep(1000);
        //click on second card
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@alt='Chase Freedom Flex (Service Mark) credit card']", 0, logger, "Chase Freedom Flex");
        //click on third card
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='col-7 card-details']", 2, logger, "Chase Freedom Student");
        //click on compare
        ReusableActions_Loggers.clickAction(driver, "//*[@id='compareBtnSticky']", logger, "Final Compare Button");
        Thread.sleep(2000);
        //Scroll Down to view comparison
        ReusableActions_Loggers.scrollByViewByIndex(driver, "//h3[text() ='APR']", 1, logger, "Scroll");
        Thread.sleep(2000);
    }//end of test 4

    @Test(priority = 2)
    public void tc005_referAFriend() throws InterruptedException {
        //navigate to chase
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on card categories drop down
        ReusableActions_Loggers.clickAction(driver, "//*[@id='submenu-collapse-control']", logger, "Card Categories Dropdown");
        Thread.sleep(2000);
        //click on refer a friend
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='subnav-item']",11, logger, "Refer a friend button");
        Thread.sleep(2000);
        //pick a credit card to refer a friend
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@data-lh-name='InviteRAF']", 3, logger, "Refer friends Now Button");
    }//end of test 5

    @Test(priority = 3)
    public void tc006_readChaseSapphireReviews() throws InterruptedException {
        int i;
        //navigate to chase
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on the first card
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='chaseanalytics-track-link mvt-learnmore button add-jpaid learn-more-btn-test p-1']", 0,logger, "first card");
        Thread.sleep(1000);
        //print review number
        String Reviews = ReusableActions_Loggers.getTextAction(driver, "//*[@class='cardReview']", logger, "Review Number");
        String[] splitReview = Reviews.split(" ");
        System.out.println("The amount of reviews this card has is: " + splitReview[0]);
        Thread.sleep(1000);
        //click on card member reviews
        ReusableActions_Loggers.clickAction(driver, "//*[@class='cardReview']", logger, "Review Number");
        Thread.sleep(1000);
        //click on see all reviews
        ReusableActions_Loggers.clickAction(driver, "//*[@class='btn button clear-btn star_ratings']", logger, "See all Reviews");
        Thread.sleep(1000);
    }//end of test 6

}//end of java class
