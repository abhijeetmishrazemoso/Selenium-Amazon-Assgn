package com.zemoso.tests;

import com.zemoso.pageObjects.*;
import com.zemoso.pageObjects.mainPages.LoggedInMainPagePO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddNewPaymentTest {

    @Test
    public void tc0006_addAPaymentMethod(){
        WebDriver driver = SeleniumAmazonTest.driver;
        driver.get("http://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoggedInMainPagePO mainPagePO = new LoggedInMainPagePO(driver);
        CartPO cartPO = mainPagePO.navigateToCart();
        AddAddressPO addressPO = cartPO.clickOnProceedToBuy();
        ChooseDeliveryOptionsPO deliveryOptionsPO = addressPO.clickonMostRecentlyUsedAddress();
        assert deliveryOptionsPO != null;
        assert deliveryOptionsPO.getFirstDeliveredItemDate() != null;
        PaymentOptionsPO paymentOptionsPO = deliveryOptionsPO.clickContinue();
        paymentOptionsPO.addPaymentMethod();
        //very unfortunately, uncomment below if you wish to see result
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        assert true;
    }
}
