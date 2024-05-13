package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;

public class AbstractPage extends BasePage {
    public WebDriver driver;
    public AbstractPage() throws IOException {
        super();
    }

    // Both selectors return first found element
    By firstProduct = By.cssSelector("[data-id-product]");
    By quickViewFirstItem = By.cssSelector(".js-quick-view.quick-view");

    public WebElement getQuickView() throws IOException{
        this.driver = getDriver();
        return driver.findElement(quickViewFirstItem);
    }
    public WebElement getFirstProduct() throws IOException{
        this.driver = getDriver();
        return driver.findElement(firstProduct);
    }

    public void openWebStore() throws IOException {
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
    }
}
