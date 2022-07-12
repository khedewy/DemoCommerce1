package test;

import org.testng.annotations.Test;
import pages.CartDetails;
import pages.HomePage;
import pages.ProductDetails;
import pages.RegisterPage;

public class UpdateShoppingCartTest extends TestBase{
    ProductDetails details;
    RegisterPage register;
    HomePage home;
    CartDetails cartDetails;


    @Test(priority = 0)
    public void userRegistration() throws InterruptedException {
        home = new HomePage(driver);
        home.MoveToRegister();
        register = new RegisterPage(driver);
        register.UserInformation("mmm","mmm","qsaqsz112@gmail.com","m01205456797");
    }
    @Test(priority = 1,dependsOnMethods = "userRegistration")
    public void UserSearching() throws InterruptedException {
        home = new HomePage(driver);
        home.searchByAUtoComplete("Macb");
    }

    @Test(priority = 2,dependsOnMethods = "UserSearching")
    public void Addtocart() throws InterruptedException {
        details = new ProductDetails(driver);
        details.AddtoCart();
        Thread.sleep(3000);
        details.goToShoppingCart();
        Thread.sleep(3000);

    }

    @Test(priority = 3,dependsOnMethods = "Addtocart")
    public void UpdateCart() throws InterruptedException {
        cartDetails = new CartDetails(driver);
        cartDetails.chooseQuantity("5");
        Thread.sleep(3000);


    }
}
