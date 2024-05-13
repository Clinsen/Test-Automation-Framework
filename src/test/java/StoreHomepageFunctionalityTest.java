import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;
import pageObjects.*;
import base.Hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashSet;

@Listeners(resources.Listeners.class)

public class StoreHomepageFunctionalityTest extends Hooks {
    public StoreHomepageFunctionalityTest() throws IOException {
        super();
    }

    @Test
    public void TestFunctionalityOfHomepage() throws IOException, InterruptedException{
        AbstractPage absPage = new AbstractPage();
        absPage.openWebStore();

        // Test the carousel
        StoreHomepage shPage = new StoreHomepage();
        Assert.assertFalse(shPage.getCarouselItems().isEmpty());
        waitForClickabilityOf(shPage.getCarouselGoRightBtn(), Duration.ofSeconds(10));

        LinkedHashSet<WebElement> visitedElements = new LinkedHashSet<>();
        waitForClickabilityOf(shPage.getCarouselGoRightBtn(), Duration.ofSeconds(10));
        shPage.getCarouselGoRightBtn().click();

        while(!visitedElements.contains(shPage.getCarouselActiveItem())){
            waitForVisibilityOf(shPage.getCarouselActiveItem(), Duration.ofSeconds(10));
            visitedElements.add(shPage.getCarouselActiveItem());
            waitForClickabilityOf(shPage.getCarouselGoRightBtn(), Duration.ofSeconds(10));
            shPage.getCarouselGoRightBtn().click();
        }

        Assert.assertEquals(visitedElements.size(), shPage.getCarouselItemCount());

        // Assure that popular products list is not empty
        shPage.getPopularProducts();
        Assert.assertFalse(shPage.getPopularProducts().isEmpty());

        // Assure that popular on sale products list is not empty
        shPage.getOnSaleProducts();
        Assert.assertFalse(shPage.getOnSaleProducts().isEmpty());

        // Assure that new products list is not empty
        shPage.getNewProducts();
        Assert.assertFalse(shPage.getNewProducts().isEmpty());

        // Scroll to the email field, enter false data
        // Assure that no subscription alerts are displayed
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", shPage.getEmailField());
        shPage.getEmailField().sendKeys("wrong data");
        shPage.getSubscribeBtn().click();
        Assert.assertTrue(shPage.getSubscriptionAlert().isEmpty());

        // Refresh the page, enter valid data and do another assertion
        getDriver().navigate().refresh();
        jse.executeScript("arguments[0].scrollIntoView()", shPage.getEmailField());
        shPage.getEmailField().sendKeys("validData@gmail.com");
        shPage.getSubscribeBtn().click();
        Assert.assertFalse(shPage.getSubscriptionAlert().isEmpty());

        System.out.println("Store homepage functionality test has been simulated.");
        //Thread.sleep(5000);
    }
}
