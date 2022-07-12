package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "termsofservice")
    WebElement agreeServices;

    @FindBy(id = "BillingNewAddress_Company")
    WebElement CompanyName;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement SelectCountry;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement SelectState;


    @FindBy(id = "BillingNewAddress_City")
    WebElement CityName;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement AddressOne;

    @FindBy(id = "BillingNewAddress_Address2")
    WebElement AddressTow;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement ZipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    WebElement faxNumber;

    @FindBy(css = "button.button-1.new-address-next-step-button")
    WebElement ContinueBatn1;

    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement ContinueBtn2;

    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement paymentMethode;

    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement paymentInformation;

    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement ConfirmOrder;

    @FindBy(css = "button.button-1.order-completed-continue-button")
    WebElement completeOrder;




    public void Checkoutservices(){
        clickButton(agreeServices);
        clickButton(checkoutBtn);
    }

    public void completeServics(String companyname, String city,String adreesone, String adresstow,
                                String zipcode,String phonenumber,String faxnumber) throws InterruptedException {

        setText(CompanyName,companyname);
        setText(CityName,city);
        select = new Select(SelectCountry);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select = new Select(SelectState);
        select.selectByIndex(1);
        setText(AddressOne,adreesone);
        setText(AddressTow,adresstow);
        setText(ZipCode,zipcode);
        setText(phoneNumber,phonenumber);
        setText(faxNumber,faxnumber);
        Thread.sleep(2000);
        clickButton(ContinueBatn1);
    }

    public void continuecheckout(){
        clickButton(ContinueBtn2);
    }
    public void paymentmethodes(){
        clickButton(paymentMethode);
    }
    public void paymentInforamtions(){
        clickButton(paymentInformation);
    }
    public void setConfirmOrder(){
        clickButton(ConfirmOrder);
    }
    public void CompleteOrder(){
        clickButton(completeOrder);
    }


}
