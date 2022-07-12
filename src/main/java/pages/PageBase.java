package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    public Select select;
    public Actions actions;

    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void setText(WebElement text, String value){
        text.sendKeys(value);
    }

    public void clickButton(WebElement button){
        button.click();
    }

    public void clearElements(WebElement clear){
        clear.clear();
    }

}
