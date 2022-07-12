package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends  PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(id = "gender-male")
    WebElement genderBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxt;

    @FindBy(id = "LastName")
    WebElement lastNameTxt;
    
    @FindBy(name = "DateOfBirthDay")
    WebElement dayList;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthList;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearList;

    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Password")
    WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPasswordTxt;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement succesfullMessage;

    @FindBy(css = "a.button-1.register-continue-button")
    WebElement ContinueBtn;


    public void UserInformation(String firstName, String lastName, String email, String password) throws InterruptedException {

        clickButton(genderBtn);
        setText(firstNameTxt,firstName);
        setText(lastNameTxt,lastName);
        setText(emailTxt,email);
        select = new Select(dayList);
        select.selectByIndex(3);
        select = new Select(monthList);
        select.selectByIndex(3);
        select = new Select(yearList);
        select.selectByIndex(3);
        setText(passwordTxt,password);
        setText(ConfirmPasswordTxt,password);
        Thread.sleep(3000);
        clickButton(registerBtn);
        Thread.sleep(3000);
    }

    public void continueregister(){
        clickButton(ContinueBtn);
    }
    

}
