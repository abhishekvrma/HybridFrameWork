package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoradPage extends BasePage {

    WebDriver driver;

    public DashBoradPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(xpath = "//button[@routerlink=\"/dashboard/cart\"]")
    WebElement goToCartButton;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    @FindBy(xpath = "//button[@routerlink=\"/dashboard/myorders\"]")
            WebElement goToOrderButton;

    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.xpath("//div[@class=\"toast-bottom-right toast-container\"]");


    public WebElement getProduct(String name) {
        waitForElementToAppear(By.cssSelector(".mb-3"));
        WebElement prod = products.stream()
                .filter(product -> name.equals(product.findElement(By.cssSelector("b")).getText()))
                .findFirst()
                .orElse(null);
        return prod;
    }

    public void addToCart(String productName) throws InterruptedException {
        WebElement product = getProduct(productName);
        product.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }

    public CartPage goToCart(){
        waitUntillClickabe(goToCartButton);
        goToCartButton.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;

    }

    public OrderPage GoToOrderPage()
    {
       waitForElementToAppear(goToOrderButton);
        goToOrderButton.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }

}
