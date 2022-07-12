package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends PageBase{
    public ReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitle;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewText;

    @FindBy(css = "button.button-1.write-product-review-button")
    WebElement submitBtn;

    @FindBy(id = "addproductrating_5")
    WebElement Ratingbtn;


    public void UserReview(String title, String text) throws InterruptedException {
        setText(reviewTitle,title);
        setText(reviewText,text);
        clickButton(Ratingbtn);
        Thread.sleep(2000);
        clickButton(submitBtn);

    }
}
