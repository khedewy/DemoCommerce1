package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends TestBase{
    HomePage homePage;
    RegisterPage register;
    LoginPage log;

    @DataProvider(name = "UserData")

    public static Object[][] userData(){

        return new Object[][]{
                {"maaa","mzzz","Ahmeed@gmail.com","12345678"},
                {"maaa","mzzz","mohameed@gmail.com","12345678"},
                {"maaa","mzzz","ali@gmail.com","12345678"}

        };
    }

    @Test(dataProvider = "UserData")
    public void UserCanRegister(String firstname, String lastname, String email, String password) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.MoveToRegister();
        Thread.sleep(5000);
        register = new RegisterPage(driver);
        register.UserInformation(firstname,lastname,email,password);
        Assert.assertTrue(register.succesfullMessage.getText().contains("Your registration completed"));
        Thread.sleep(3000);
        register.continueregister();
        Thread.sleep(3000);
        homePage = new HomePage(driver);
        homePage.Logout();
        homePage.MovetoLogin();
        log = new LoginPage(driver);
        log.UserCanLogin(email,password);
        Thread.sleep(3000);
        homePage.Logout();

    }

}
