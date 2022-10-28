import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class RegistartionTest {

    String email = "test" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()) + "@email.com";

    WebDriver driver;

    @BeforeMethod
    public void launnchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
        driver.manage().window().maximize();
    }

    @Test (description = "Verify user is able to register successfully")
    public void register() {
        System.out.println("email is "+email);
//
//        LandingPage landingPage = new LandingPage(driver);
//        RegistrationPage registrationPage = landingPage.register();
//        registrationPage.registerUser("abhishek", "verma", email, "9281738478", "Engineer", "Male", "Test12345678", "Test12345678");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.textToBe(By.xpath("//h1[text()=\"Account Created Successfully\"]"), "Account Created Successfully"));
//
//        WebElement successMessage = driver.findElement(By.xpath("//h1[text()=\"Account Created Successfully\"]"));
//
//        String successText = successMessage.getText();
//        Assert.assertEquals(successText, "Account Created Successfully");

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
