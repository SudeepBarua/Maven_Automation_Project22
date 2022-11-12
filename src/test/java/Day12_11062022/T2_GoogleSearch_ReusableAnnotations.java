package Day12_11062022;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ReusableAnnotations extends Reusable_Annotations {

    @Test
    public void searchForBMW(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        ReusableActions_Loggers.sendKeysAction(driver, "//*[@name= 'q']", "BMW", logger , "Search Field");
        //hit submit on google search button
        ReusableActions_Loggers.submitAction(driver, "//*[@name = 'btnK']", logger, "Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBMW")
    public void captureSearchNumber() {
        //capture the search results text
        String results = ReusableActions_Loggers.getTextAction(driver, "//*[@id = 'result-stats']", logger, "Search Results");
        String [] arrayResult = results.split(" ");
        //print back to html report by using log INFO
        logger.log(LogStatus.INFO, "Search number for BMW is : " + arrayResult[1]);
    }
}//end of java class
