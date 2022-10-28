import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.List;

public class ShoppingPageTest1 extends BaseTest {
    private  HashMap<String,String> map;

    @Factory(dataProvider = "getData")
    public ShoppingPageTest1(HashMap<String,String> map, HashMap<String,String> map1) {
        this.map=map;
    }
    String orderid;

    @Test(description = "Verify user is able to place successfull order")
    public void addToCard() throws InterruptedException {
        DashBoradPage dashBoradPage = landingPage.login(map.get("email"), map.get("password"));
        dashBoradPage.addToCart(map.get("product"));
        CartPage cartPage = dashBoradPage.goToCart();
        PaymentPage paymentPage = cartPage.proceedToCheckout();
        OrderConfirmationPage orderConfirmationPage = paymentPage.placeOrder("Abhishek", "India");
        String cnfrmMesg = orderConfirmationPage.getConfirmationMessage();
        System.out.println(cnfrmMesg);
        Assert.assertTrue(cnfrmMesg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        orderid = orderConfirmationPage.getOrderId();
    }

    @Test(dependsOnMethods = {"addToCard"})
    public void confrimOrderisPlacedSuccessfully(HashMap<String, String> input) {
        DashBoradPage dashBoradPage = landingPage.login(map.get("emial"), map.get("password"));
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


