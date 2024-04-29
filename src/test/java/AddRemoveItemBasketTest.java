import java.io.IOException;
import java.time.Duration;

import base.PageObjectBase;
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
        PageObjectBase poBase = new PageObjectBase();
        poBase.getFirstProduct().click();

        // Increase the quantity, add it to the cart
        StoreProductPage productPage = new StoreProductPage();
        productPage.getQuantityIncreaseBtn().click();
        productPage.getAddToCartBtn().click();

        // Click on continue shopping btn
        StoreContentPanel contentPanel = new StoreContentPanel();
        contentPanel.getContinueShoppingBtn().click();

        // Change parameters of the product, add it to the cart
        Select option = new Select(productPage.getSizeOption());
        option.selectByVisibleText("XL");
        waitForClickabilityOf(productPage.getAddToCartBtn(), Duration.ofSeconds(10));
        productPage.getAddToCartBtn().click();

        // Proceed to checkout page (cart)
        waitForStalenessOf(contentPanel.getProceedToCheckoutBtn(), Duration.ofSeconds(10));
        contentPanel.getProceedToCheckoutBtn().click();

        // Remove an item from the cart
        ShoppingCart sCart = new ShoppingCart();
        sCart.getRemoveItemBtn(2).click();
        waitForInvisibilityOf(sCart.getRemoveItemBtn(2), Duration.ofSeconds(10));

        // Assert that the item was removed by comparing how much we should pay overall
        Assert.assertEquals(sCart.getTotalAmountValue().getText(), "$45.24");

        System.out.println("Add/Remove item test has been simulated.");
        //Thread.sleep(5000);
    }
}