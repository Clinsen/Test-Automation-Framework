import base.PageObjectBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;
import pageObjects.*;
import base.Hooks;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class NavBarFunctionalityTest extends Hooks {
    public NavBarFunctionalityTest() throws IOException {
        super();
    }

    @Test
    public void TestFunctionalityOfTheNavigationBar() throws IOException, InterruptedException{
        AbstractPage absPage = new AbstractPage();
        absPage.openWebStore();

        // Test clothes section
        HeaderElements header = new HeaderElements();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(header.getClothesSection()).perform();
        waitForClickabilityOf(header.getClothesMen(), Duration.ofSeconds(10));
        header.getClothesMen().click();

        StoreFilterPage fPage = new StoreFilterPage();
        Assert.assertEquals(fPage.getSectionLabel().getText(), "MEN");

        actions.moveToElement(header.getClothesSection()).perform();
        waitForClickabilityOf(header.getClothesWomen(), Duration.ofSeconds(10));
        header.getClothesWomen().click();
        Assert.assertEquals(fPage.getSectionLabel().getText(), "WOMEN");

        // Test accessories section
        actions.moveToElement(header.getAccessoriesSection()).perform();
        waitForClickabilityOf(header.getAccessoriesStationery(), Duration.ofSeconds(10));
        header.getAccessoriesStationery().click();
        Assert.assertEquals(fPage.getSectionLabel().getText(), "STATIONERY");

        actions.moveToElement(header.getAccessoriesSection()).perform();
        waitForClickabilityOf(header.getAccessoriesHome(), Duration.ofSeconds(10));
        header.getAccessoriesHome().click();
        Assert.assertEquals(fPage.getSectionLabel().getText(), "HOME ACCESSORIES");

        // Test art section
        header.getArtSection().click();
        Assert.assertEquals(fPage.getSectionLabel().getText(), "ART");

        header.getStoreBtn().click();

        // Test the search bar functionality
        String keysToSend = "hummingbird";
        header.getSearchBar().sendKeys(keysToSend.toLowerCase(), Keys.RETURN);

        actions.moveToElement(absPage.getFirstProduct()).perform();
        absPage.getQuickView().click();

        QuickViewPage qvPage = new QuickViewPage();
        waitForVisibilityOf(qvPage.getItemLabel(), Duration.ofSeconds(10));

        // Assert that whatever was found exists in our search query
        Assert.assertTrue(qvPage.getItemLabel().getText().toLowerCase().contains(keysToSend.toLowerCase()));

        System.out.println("Navigation bar functionality test has been simulated.");
        //Thread.sleep(5000);
    }
}
