package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userMobile")
    WebElement userMobile;

    @FindBy(xpath = "//select[@formcontrolname=\"occupation\"]")
    WebElement dropDown;

    @FindBy(xpath = "//input[@value=\"Male\"]")
    WebElement maleRadioButton;

    @FindBy(xpath = "//input[@value=\"Female\"]")
    WebElement femaleRadioButton;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    WebElement tNcCheckbox;

    @FindBy(id="login")
    WebElement registerButton;

    public void registerUser(String fName, String lName, String email, String phoneNumber, String Occupation, String gender, String passWord, String cPassWord)
    {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userEmail.sendKeys(email);
        userMobile.sendKeys(phoneNumber);
        Select select = new Select(dropDown);
        select.selectByVisibleText(Occupation);

        if ( gender.equalsIgnoreCase("male") )
        {
            maleRadioButton.click();
        }

        if ( gender.equalsIgnoreCase("female") )
        {
            femaleRadioButton.click();
        }

        userPassword.sendKeys(passWord);
        confirmPassword.sendKeys(cPassWord);
        tNcCheckbox.click();
        registerButton.click();

    }


}
