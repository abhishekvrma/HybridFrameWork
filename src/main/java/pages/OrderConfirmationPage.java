package pages;

import base.BasePage;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BasePage {

    WebDriver driver;
    public OrderConfirmationPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[text()=' Thankyou for the order. ']")
    WebElement confirmationMessage;

    @FindBy(xpath = "//label[@class=\"ng-star-inserted\"]")
    WebElement orderid;

    public String getConfirmationMessage()
    {
        String cnfrmMsg=confirmationMessage.getText();
        return cnfrmMsg;
    }

    public String getOrderId()
    {
        String orderId= orderid.getText();
        return orderId;
    }
}
