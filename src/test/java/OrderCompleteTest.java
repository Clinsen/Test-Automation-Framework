import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.*;
import base.Hooks;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends Hooks {
    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void SimulateOrderingProcess() throws IOException, InterruptedException {
        Homepage home = new Homepage();

        home.getCookie().click();

        if (home.getSidebar().getAttribute("class").contains("inactive")){
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());

        waitForClickabilityOf(home.getTestStoreLink(), Duration.ofSeconds(10));
        home.getTestStoreLink().click();

        StoreHomepage store = new StoreHomepage();
        store.getProduct().click();

        StoreProductPage storeProd = new StoreProductPage();
        Select option = new Select(storeProd.getSizeOption());
        option.selectByVisibleText("M");

        storeProd.getQuantityIncreaseBtn().click();
        storeProd.getAddToCartBtn().click();

        StoreContentPanel sPanel = new StoreContentPanel();
        waitForClickabilityOf(sPanel.getProceedToCheckoutBtn(), Duration.ofSeconds(10));
        sPanel.getProceedToCheckoutBtn().click();

        ShoppingCart sCart = new ShoppingCart();
        sCart.getHavePromo().click();
        sCart.getPromoTextbox().sendKeys("20OFF");
        sCart.getAddPromoBtn().click();
        waitForClickabilityOf(sCart.getProceedToCheckoutBtn(), Duration.ofSeconds(10));
        sCart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo pInfo = new OrderFormPersInfo();
        pInfo.getGenderMale().click();
        pInfo.getFirstNameField().sendKeys("Patrick");
        pInfo.getLastnameField().sendKeys("Star");
        pInfo.getEmailField().sendKeys("PatrickStar@gmail.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();

        OrderFormDelivery dInfo = new OrderFormDelivery();
        dInfo.getAddressField().sendKeys("Non-existing street");
        dInfo.getCityField().sendKeys("Test City");
        Select state = new Select(dInfo.getStateDropdown());
        state.selectByVisibleText("Texas");
        dInfo.getPostcodeField().sendKeys("76013");
        dInfo.getContinueBtn().click();

        OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod();
        shippingMethod.getDeliveryMsgTextbox().sendKeys("Test comment");
        shippingMethod.getContinueBtn().click();

        OrderFormPayment paymentForm = new OrderFormPayment();
        paymentForm.getPayByCheckRadioBtn().click();
        paymentForm.getTermsConditionsCheckbox().click();
        paymentForm.getOrderBtn().click();

        OrderConfirm confirmPage = new OrderConfirm();
        Assert.assertEquals(sCart.getTotalAmountValue().getText(), confirmPage.getPaymentAmount().getText());

        System.out.println("Order test has been simulated.");
        //Thread.sleep(5000);
    }
}
