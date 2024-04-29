import base.PageObjectBase;
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

        // Close the cookie pop-up
        home.getCookie().click();

        // If the sidebar is invisible to user - open it
        if (home.getSidebar().getAttribute("class").contains("inactive")){
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());

        // Go to the web store
        waitForClickabilityOf(home.getTestStoreLink(), Duration.ofSeconds(10));
        home.getTestStoreLink().click();

        // Click on the first product
        PageObjectBase poBase = new StoreHomepage();
        poBase.getFirstProduct().click();

        // Add parameters
        StoreProductPage storeProd = new StoreProductPage();
        Select option = new Select(storeProd.getSizeOption());
        option.selectByVisibleText("M");

        // Increase the quantity, add the product to cart
        storeProd.getQuantityIncreaseBtn().click();
        storeProd.getAddToCartBtn().click();

        // Open the cart via proceed to checkout btn
        StoreContentPanel sPanel = new StoreContentPanel();
        waitForClickabilityOf(sPanel.getProceedToCheckoutBtn(), Duration.ofSeconds(10));
        sPanel.getProceedToCheckoutBtn().click();

        // Attempt to use the promo code, proceed to checkout
        ShoppingCart sCart = new ShoppingCart();
        sCart.getHavePromo().click();
        sCart.getPromoTextbox().sendKeys("20OFF");
        sCart.getAddPromoBtn().click();
        waitForClickabilityOf(sCart.getProceedToCheckoutBtn(), Duration.ofSeconds(10));
        sCart.getProceedToCheckoutBtn().click();

        // Enter personal info
        OrderFormPersInfo pInfo = new OrderFormPersInfo();
        pInfo.getGenderMale().click();
        pInfo.getFirstNameField().sendKeys("Patrick");
        pInfo.getLastnameField().sendKeys("Star");
        pInfo.getEmailField().sendKeys("PatrickStar@gmail.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();

        // Enter delivery info
        OrderFormDelivery dInfo = new OrderFormDelivery();
        dInfo.getAddressField().sendKeys("Non-existing street");
        dInfo.getCityField().sendKeys("Test City");
        Select state = new Select(dInfo.getStateDropdown());
        state.selectByVisibleText("Texas");
        dInfo.getPostcodeField().sendKeys("76013");
        dInfo.getContinueBtn().click();

        // Choose shipping method
        OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod();
        shippingMethod.getDeliveryMsgTextbox().sendKeys("Test comment");
        shippingMethod.getContinueBtn().click();

        // Finalize the order
        OrderFormPayment paymentForm = new OrderFormPayment();
        paymentForm.getPayByCheckRadioBtn().click();
        paymentForm.getTermsConditionsCheckbox().click();
        paymentForm.getOrderBtn().click();

        // Check whether it's confirmed
        OrderConfirm confirmPage = new OrderConfirm();
        Assert.assertEquals(confirmPage.getConfirmOrderLabel().getText(), "\uE876YOUR ORDER IS CONFIRMED");

        System.out.println("Order test has been simulated.");
        //Thread.sleep(5000);
    }
}
