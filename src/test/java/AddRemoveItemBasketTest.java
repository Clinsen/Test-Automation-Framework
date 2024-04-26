import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Hooks;
import pageObjects.*;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException, InterruptedException {
        Homepage home = new Homepage();

        home.getCookie().click();

        if (home.getSidebar().getAttribute("class").contains("inactive")){
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());

        waitForClickabilityOf(home.getTestStoreLink(), Duration.ofSeconds(10));
        home.getTestStoreLink().click();

        StoreHomepage storeHome = new StoreHomepage();
        storeHome.getProduct().click();

        StoreProductPage productPage = new StoreProductPage();
        productPage.getQuantityIncreaseBtn().click();
        productPage.getAddToCartBtn().click();

        StoreContentPanel contentPanel = new StoreContentPanel();
        contentPanel.getContinueShoppingBtn().click();

        Select option = new Select(productPage.getSizeOption());
        option.selectByVisibleText("XL");
        waitForClickabilityOf(productPage.getAddToCartBtn(), Duration.ofSeconds(10));
        productPage.getAddToCartBtn().click();

        waitForStalenessOf(contentPanel.getProceedToCheckoutBtn(), Duration.ofSeconds(10));
        contentPanel.getProceedToCheckoutBtn().click();

        ShoppingCart sCart = new ShoppingCart();
        sCart.getRemoveItemBtn(2).click();
        waitForInvisibilityOf(sCart.getRemoveItemBtn(2), Duration.ofSeconds(10));

        Assert.assertEquals(sCart.getTotalAmountValue().getText(), "$45.24");

        System.out.println("Add/Remove item test has been simulated.");
        //Thread.sleep(5000);
    }
}