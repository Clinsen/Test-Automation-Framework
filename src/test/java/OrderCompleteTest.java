import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends BasePage {
    public OrderCompleteTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void finishExecution(){
        driver.close();
        driver = null;
    }

    @Test
    public void SimulateOrderingProcess() throws IOException, InterruptedException {
        Homepage home = new Homepage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        home.getCookie().click();

        if(home.getSidebarInactive().isEnabled()){
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());

        wait.until(ExpectedConditions.elementToBeClickable(home.getTestStoreLink()));
        home.getTestStoreLink().click();

        StoreHomepage store = new StoreHomepage(driver);
        store.getProduct().click();

        StoreProductPage storeProd = new StoreProductPage(driver);
        Select option = new Select(storeProd.getSizeOption());
        option.selectByVisibleText("M");

        storeProd.getQuantityIncreaseBtn().click();
        storeProd.getAddToCartBtn().click();

        StoreContentPanel sPanel = new StoreContentPanel(driver);
        sPanel.getProceedToCheckoutBtn().click();

        ShoppingCart sCart = new ShoppingCart(driver);
        sCart.getHavePromo().click();
        sCart.getPromoTextbox().sendKeys("20OFF");
        sCart.getAddPromoBtn().click();
        sCart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo pInfo = new OrderFormPersInfo(driver);
        pInfo.getGenderMale().click();
        pInfo.getFirstNameField().sendKeys("Patrick");
        pInfo.getLastnameField().sendKeys("Star");
        pInfo.getEmailField().sendKeys("PatrickStar@gmail.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();

        OrderFormDelivery dInfo = new OrderFormDelivery(driver);
        dInfo.getAddressField().sendKeys("Non-existing street");
        dInfo.getCityField().sendKeys("Test City");
        Select state = new Select(dInfo.getStateDropdown());
        state.selectByVisibleText("Texas");
        dInfo.getPostcodeField().sendKeys("76013");
        dInfo.getContinueBtn().click();

        OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod(driver);
        shippingMethod.getDeliveryMsgTextbox().sendKeys("Test comment");
        shippingMethod.getContinueBtn().click();

        OrderFormPayment paymentForm = new OrderFormPayment(driver);
        paymentForm.getPayByCheckRadioBtn().click();
        paymentForm.getTermsConditionsCheckbox().click();
        paymentForm.getOrderBtn().click();

        OrderConfirm confirmPage = new OrderConfirm(driver);
        Assert.assertEquals(sCart.getTotalAmountValue().getText(), confirmPage.getPaymentAmount().getText());

        System.out.println("OrderComplete test has been simulated successfully.");
        //Thread.sleep(5000);
    }
}
