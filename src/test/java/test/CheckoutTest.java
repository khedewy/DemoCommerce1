package test;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDetails;
import pages.RegisterPage;

public class CheckoutTest extends TestBase{

    ProductDetails details;
    RegisterPage register;
    HomePage home;
    CheckoutPage checkoutPage;


    @Test(priority = 0)
    public void userRegistration() throws InterruptedException {
        home = new HomePage(driver);
        home.MoveToRegister();
        register = new RegisterPage(driver);
        register.UserInformation("mmm","mmm","q2aa1a2@gmail.com","m01205456797");
    }
    @Test(priority = 1,dependsOnMethods = "userRegistration")
    public void UserSearching() throws InterruptedException {
        home = new HomePage(driver);
        home.searchByAUtoComplete("Macb");
    }

    @Test(priority = 2,dependsOnMethods = "UserSearching")
    public void AddToCart() throws InterruptedException {
        details = new ProductDetails(driver);
        details.AddtoCart();
        Thread.sleep(3000);
        details.goToShoppingCart();
        Thread.sleep(3000);
    }
    @Test(priority = 3,dependsOnMethods = "AddToCart")
    public void setCheckoutPage() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.Checkoutservices();
        Thread.sleep(3000);
        checkoutPage.completeServics("nnn","sss","addd1","addde","1234","0123456","1234");
        Thread.sleep(3000);
        checkoutPage.continuecheckout();
        Thread.sleep(5000);
        checkoutPage.paymentmethodes();
        Thread.sleep(5000);
        checkoutPage.paymentInforamtions();
        Thread.sleep(5000);
        checkoutPage.setConfirmOrder();
        Thread.sleep(5000);
        checkoutPage.CompleteOrder();
        Thread.sleep(10000);



    }

}
