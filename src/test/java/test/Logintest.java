package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class Logintest extends TestBase{
    LoginPage log;
    RegisterPage register;
    HomePage home;

    @DataProvider(name = "UserData")
    public static Object[][] userData(){
        return  new Object[][]{
                {"Mahmoud","Ahmed","wwwwe@gmail.com","0123456"}

        };

    }

    @Test(dataProvider = "UserData")
    public void UserCanLogin(String firstname, String lastname, String email, String  password) throws InterruptedException {
        home = new HomePage(driver);
        home.MoveToRegister();
        register = new RegisterPage(driver);
        register.UserInformation(firstname,lastname,email,password);
        Assert.assertTrue(register.succesfullMessage.getText().contains("Your registration completed"));
        Thread.sleep(3000);
        home.Logout();
        Thread.sleep(3000);
        home.MovetoLogin();
        log = new LoginPage(driver);
        log.UserCanLogin(email,password);
        Thread.sleep(3000);

    }

}
