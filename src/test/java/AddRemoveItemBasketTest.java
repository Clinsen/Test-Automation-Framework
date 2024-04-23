import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.*;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends BasePage{

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }

    @Test
    public void addRemoveItem() throws IOException, InterruptedException {
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

        StoreHomepage storeHome = new StoreHomepage(driver);
        storeHome.getProduct().click();

        StoreProductPage productPage = new StoreProductPage(driver);
        productPage.getQuantityIncreaseBtn().click();
        productPage.getAddToCartBtn().click();

        StoreContentPanel contentPanel = new StoreContentPanel(driver);
        wait.until(ExpectedConditions.elementToBeClickable(contentPanel.getContinueShoppingBtn()));
        contentPanel.getContinueShoppingBtn().click();

        Select option = new Select(productPage.getSizeOption());
        option.selectByVisibleText("XL");
        wait.until(ExpectedConditions.elementToBeClickable(productPage.getAddToCartBtn()));
        productPage.getAddToCartBtn().click();

        wait.until(ExpectedConditions.stalenessOf(contentPanel.getProceedToCheckoutBtn()));
        contentPanel.getProceedToCheckoutBtn().click();

        ShoppingCart sCart = new ShoppingCart(driver);
        sCart.getRemoveItemBtn(2).click();
        wait.until(ExpectedConditions.invisibilityOf(sCart.getRemoveItemBtn(2)));

        Assert.assertEquals(sCart.getTotalAmountValue().getText(), "$45.24");

        System.out.println("AddRemoveItemBasket test has been simulated successfully.");
        //Thread.sleep(5000);
    }
}