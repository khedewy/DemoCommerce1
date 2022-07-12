package test;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetails;
import pages.RegisterPage;
import pages.ReviewPage;

public class AddReviewTest extends TestBase{
    ProductDetails details;
    RegisterPage register;
    HomePage home;
    ReviewPage reviewPage;

    @Test(priority = 0)
    public void userRegistration() throws InterruptedException {
        home = new HomePage(driver);
        home.MoveToRegister();
        register = new RegisterPage(driver);
        register.UserInformation("mmm","mmm","assazs12@gmail.com","m01205456797");
    }
    @Test(priority = 1,dependsOnMethods = "userRegistration")
    public void UserSearching() throws InterruptedException {
        home = new HomePage(driver);
        home.searchByAUtoComplete("Macb");
    }

    @Test(priority = 2,dependsOnMethods = "UserSearching")
    public void AddingReview() throws InterruptedException {
        details = new ProductDetails(driver);
        details.UserCanAddReview();
        Thread.sleep(4000);
        reviewPage = new ReviewPage(driver);
        reviewPage.UserReview("sss","this a very good product");
    }
}
