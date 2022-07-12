package test;

import org.testng.annotations.Test;
import pages.HomePage;

public class SearchTest extends TestBase{
    HomePage home;


    //@Test
    public void Searching() throws InterruptedException {
        home = new HomePage(driver);
        home.UsercanSearch("macb");
        Thread.sleep(3000);
    }

    @Test
    public void UserCanSearchByAutoComplete() throws InterruptedException {
        home = new HomePage(driver);
        home.searchByAUtoComplete("Macb");
    }


}
