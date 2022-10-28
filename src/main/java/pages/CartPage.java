package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        super (driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    WebElement checkout;

    public PaymentPage proceedToCheckout()
    {
        waitUntillClickabe(checkout);
        checkout.click();
        PaymentPage paymentPage = new PaymentPage(driver);
        return paymentPage;
    }

}
