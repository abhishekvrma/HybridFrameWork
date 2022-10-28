import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;

public class ErrorValidations extends BaseTest{

    @Test (groups = {"ErrorValidation"},description = "Verify proper error message is displayed if incorrect email or password is used")
    public void loginError()
    {
        landingPage.login("test@email.com","1234");
       String errorMessage= landingPage.getErrorMessage();
        System.out.println(errorMessage);
        Assert.assertTrue(errorMessage.equalsIgnoreCase("Incorrect email or password."));

    }

}
