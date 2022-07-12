package test;

import org.testng.annotations.Test;
import pages.HomePage;

public class Hovermenue extends TestBase{
    HomePage home;

    @Test
    public void HoverOver() throws InterruptedException {
        home = new HomePage(driver);
        home.MoveToDesktop();
        Thread.sleep(5000);
    }
}
