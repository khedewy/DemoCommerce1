package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends PageBase{
    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add your review")
    WebElement AddReviewBtn;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;

    @FindBy(linkText = "shopping cart")
    WebElement shopingcartbtn;

    public void goToShoppingCart(){
        clickButton(shopingcartbtn);
    }

    public void AddtoCart(){
        clickButton(addToCartBtn);
    }

    public void UserCanAddReview(){
        clickButton(AddReviewBtn);
    }
}
