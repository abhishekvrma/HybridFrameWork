package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage extends BasePage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@class=\"input txt\"])[1]")
    WebElement cvvFiled;

    By cvv = By.xpath("(//input[@class=\"input txt\"])[1]");

    @FindBy(xpath = "(//input[@class=\"input txt\"])[2]")
    WebElement cardHolderName;

    @FindBy(xpath = "//input[@ placeholder =\"Select Country\"]")
    WebElement countryToSelect;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    private WebElement selectCountry;

    @FindBy(xpath="//a[@class=\"btnn action__submit ng-star-inserted\"]")
    WebElement placeOrderButton;


    public void selectCountry(String countryName) {
        countryToSelect.sendKeys(countryName);
        waitUntillClickabe(selectCountry);
        selectCountry.click();
    }

    public OrderConfirmationPage placeOrder(String nameOnCard, String country) {
        waitForElementToAppear(cvv);
        cvvFiled.sendKeys("123");
        cardHolderName.sendKeys(nameOnCard);
        selectCountry(country);
        placeOrderButton.click();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        return orderConfirmationPage;
    }


}
