package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerBtn;

    @FindBy(linkText = "Log in")
    WebElement loginBtn;

    @FindBy(css = "a.ico-logout")
    WebElement LogOutBtn;

    @FindBy(linkText = "Computers")
    WebElement ComputerList;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a")
    WebElement Desktop;

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(id = "ui-id-2")
    WebElement productNamelist;

    public void MoveToRegister(){
        clickButton(registerBtn);
    }
    public void MovetoLogin(){
        clickButton(loginBtn);
    }
    public void Logout(){
        clickButton(LogOutBtn);
    }

    public void MoveToDesktop(){
        actions.moveToElement(ComputerList).moveToElement(Desktop).click().build().perform();
    }

    public void UsercanSearch(String productName){
        setText(searchBox,productName);
        clickButton(searchBtn);
    }
    public void searchByAUtoComplete(String productName) throws InterruptedException {
        setText(searchBox,productName);
        Thread.sleep(2000);
        clickButton(productNamelist);
        Thread.sleep(5000);


    }
}
