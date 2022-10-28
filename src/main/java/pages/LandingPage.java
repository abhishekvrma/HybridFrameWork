package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(id="userEmail")
    WebElement email;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement loginBtn;


    @FindBy(xpath="//a[@class=\"forgot-password-link\"]")
    WebElement forgotPasswordLink;

    @FindBy(xpath="//a[@class=\"text-reset\"]")
    WebElement registerLink;

    @FindBy(xpath="//a[@class=\"btn1\"]")
    WebElement registerButton;

    @FindBy(xpath = "//div[@aria-label=\"Incorrect email or password.\"]")
    WebElement errorMessage;

    public RegistrationPage register()
    {
        waitUntillClickabe(registerButton);
        registerButton.click();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage;
    }

    public DashBoradPage login(String userEmail, String userPassword)
    {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginBtn.click();
        DashBoradPage listingPage = new DashBoradPage(driver);
        return listingPage;
    }

    public String getErrorMessage()
    {
        waitForElementToAppear(errorMessage);
        String error = errorMessage.getText();
        return error;
    }


}
