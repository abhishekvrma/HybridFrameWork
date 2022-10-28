package pages;

import base.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    WebDriver driver;
    public OrderPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


       By orderTable= By.xpath("//tr[@class=\"ng-star-inserted\"]/th[1]");



    public Boolean checkIfOrderExist(String orderId)
    {
        Boolean isOrderExist=false;
        orderId= StringUtils.substringBetween(orderId," ");
        waitForElementToAppear(orderTable);
        List<WebElement> orders = driver.findElements(orderTable);

        for (WebElement oid:orders)
        {
          String actualOrderId= oid.getText();
          if ((actualOrderId.equalsIgnoreCase(orderId)))
              isOrderExist=true;
        }
        return isOrderExist;
    }
}
