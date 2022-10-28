import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.List;

public class ShoppingPageTest extends BaseTest {

    String orderid;

    @Test(description = "Verify user is able to place successfull order", dataProvider = "getData")
    public void addToCard(HashMap<String, String> input) throws InterruptedException {
//        DashBoradPage dashBoradPage = landingPage.login(input.get("email"), input.get("password"));
//        dashBoradPage.addToCart(input.get("product"));
//        CartPage cartPage = dashBoradPage.goToCart();
//        PaymentPage paymentPage = cartPage.proceedToCheckout();
//        OrderConfirmationPage orderConfirmationPage = paymentPage.placeOrder("Abhishek", "India");
//        String cnfrmMesg = orderConfirmationPage.getConfirmationMessage();
//        Assert.assertTrue(cnfrmMesg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//        orderid = orderConfirmationPage.getOrderId();
    }

    @Test(dependsOnMethods = {"addToCard"}, dataProvider = "getData",enabled = false)
    public void confrimOrderisPlacedSuccessfully(HashMap<String, String> input) {
        DashBoradPage dashBoradPage = landingPage.login(input.get("emial"), input.get("password"));
        OrderPage orderPage = dashBoradPage.GoToOrderPage();
        Boolean isOrderExist = orderPage.checkIfOrderExist(orderid);
        Assert.assertTrue(isOrderExist);
    }

    @DataProvider
    public Object[][] getData() {
        List<HashMap<String, String>> jasonData = DataReader.getJsonDataToMap(System.getProperty("user.dir") + "/src/data/ShoppingData.json");
        HashMap<String, String> map = jasonData.get(0);
        HashMap<String, String> map1 = jasonData.get(1);
        return new Object[][]{{map}, {map1}};
    }

}


