package actionItem5_UHC;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class actionItem5_UHC {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void employerAndIndividualPlan() throws InterruptedException {
        //navigate to uhc website
        driver.navigate().to("https://www.UHC.com");
        //click on find a doctor
        ReusableActions.clickAction(driver, "//*[@class = 'find-doctor position-relative  cta button-style__outline-blue cta--remove-icon lg-items-center lg-flex']", "findDoc");
        Thread.sleep(5000);
        //scroll to find a dentist
        driver.navigate().refresh();
        ReusableActions.scrollByView(driver, "//*[text() = 'Find a dentist']", "findDentist");
        Thread.sleep(5000);
        //click on find a dentist
        ReusableActions.clickAction(driver, "//*[text() = 'Find a dentist", "findDentist");
        Thread.sleep(5000);
        //switch to new tab
        ReusableActions.switchToTabByIndex(driver, 1);
        Thread.sleep(3000);
        //click on Employer and Individual plans
        ReusableActions.clickAction(driver, "//*[@ng-src= '/static/media/icn_united_all-7651bc16.svg']", "employerPlans");
    }//end of test 1
   @Test(priority = 2)
   public void generalDentist(){
        //Enter a zipcode
       ReusableActions.sendKeysAction(driver, "//*[@id= 'location']", "11801", "zip code");
       //Click on continue
       ReusableActions.clickAction(driver, "//*[@type= 'submit']", "continue");
       ReusableActions.clickAction(driver, "//*[@type= 'submit']", "continue");
       //click on National options PPO 30
       ReusableActions.clickActionByIndex(driver, "//*[@class= 'sc-jomqko TEkcT']", 0, "PPO");
       //click on General Dentists
       ReusableActions.clickActionByIndex(driver, "//*[@class= 'sc-gSYDnn fslDuO']", 0, "General Dentists");
   }//end of test 2


    @Test(priority = 3)
    public void Dropdown() throws InterruptedException {
        //select a mile
        ReusableActions.selectbytext(driver, "//*[@class= 'radiusMiles ng-pristine ng-valid ng-not-empty ally-focus-within ng-touched']", "Miles", "Within 1 Mile");
        //click on first doctor name
        ReusableActions.clickActionByIndex(driver, "//*[@data-test-id= 'provider-name-link']", 0, "doctor");
        Thread.sleep(1000);
        //click on save
        ReusableActions.clickActionByIndex(driver, "//*[text()= 'Save']", 0, "save");
        //capture address
        String addressCapture = ReusableActions.getTextAction(driver, "/*[@class= 'undefined adr']", "Address");
        //capture distance
        String distanceCapture = ReusableActions.getTextAction(driver, "//*[@data-test-id='distance-away']", "distance");
        //capture in network or out of network
        String networkCapture = ReusableActions.getTextAction(driver, "//*[@value='::location.inNetwork']", "network");
        //print out
        System.out.println("Address: " + addressCapture + "Miles: " +distanceCapture + "Network: " + networkCapture);
        //close tab
        driver.close();
    }//end of test 3

    @Test(priority = 4)
    public void searchNumber() throws InterruptedException {
        //switch back to default tab
        ReusableActions.switchToTabByIndex(driver, 0);
        //refresh page
        driver.navigate().refresh();
        Thread.sleep(1000);
        //search "doctor"
        ReusableActions.sendKeysAction(driver, "//*[@class = 'search-input borderRadius-35 m-0 py-2 px-3 weight-medium desktop']", "doctor", "doctor sendkeys");
        //click on search
        ReusableActions.clickAction(driver, "//*[@id = 'search__button-desktop']", "Search Icon");
        Thread.sleep(2000);
        String results = ReusableActions.getTextAction(driver, "//*[@id = 'search-results-count__header']", "Results Header");
        String[] arrayResults = results.split("results");
        //print
        System.out.println("Results Amount: " + arrayResults[0]);
    }//end of test 4

}//end of java class

