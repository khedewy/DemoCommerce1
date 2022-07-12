package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartDetails extends PageBase{
    public CartDetails(WebDriver driver) {
        super(driver);

    }
    @FindBy(id = "updatecart")
    WebElement updateCart;

    @FindBy(name = "continueshopping")
    WebElement continueShoppingbtn;

    @FindBy(id = "open-estimate-shipping-popup")
    WebElement estimateShipping;

    @FindBy(css = "button.remove-btn")
    WebElement removeBtn;


    @FindBy(css = "input.qty-input")
    WebElement quantityBox;

    @FindBy(id = "product_attribute_2")
    WebElement RAMchoice;

    @FindBy(id = "product_attribute_3_6")
    WebElement HddChoice;
    @FindBy(id = "add-to-cart-button-1")
    WebElement AddTocartBTn;

    public void Usercancompleteinf(){
        clickButton(HddChoice);
        select = new Select(RAMchoice);
        select.selectByIndex(1);
        clickButton(AddTocartBTn);

    }

    public void chooseQuantity(String value){
        clearElements(quantityBox);
        setText(quantityBox,value);
        clickButton(updateCart);
    }


    public void usercandeleteitems(){
        clickButton(removeBtn);
    }

    public void UserCanestimate(){
        clickButton(estimateShipping);
    }

    public void userCanContinueShopping(){
        clickButton(continueShoppingbtn);
    }

}
