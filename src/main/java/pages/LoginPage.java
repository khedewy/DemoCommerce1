package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Password")
    WebElement passwordTxt;

    @FindBy(css = "button.button-1.login-button")
    WebElement LoginBtn;


    public void UserCanLogin(String email, String password){
        setText(emailTxt,email);
        setText(passwordTxt,password);
        clickButton(LoginBtn);
    }
}
