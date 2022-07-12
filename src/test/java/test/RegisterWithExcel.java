package test;

import data.UserExcelData;
import org.osgl.xls.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;


import java.io.IOException;

public class RegisterWithExcel extends TestBase{
    HomePage homePage;
    RegisterPage register;
    LoginPage log;

    @DataProvider(name="ExcelData")
    public Object[][] userRegisterData() throws IOException
    {
        // get data from Excel Reader class
        UserExcelData data  = new UserExcelData();
        return data.getExcelData();
    }


    @Test(dataProvider = "ExcelData")
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
