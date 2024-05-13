package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Homepage extends AbstractPage {
    public Homepage() throws IOException {
        super();
    }

    By toggle = By.cssSelector(".toggle");
    By testStoreLink = By.linkText("TEST STORE");
    By cookie = By.cssSelector(".close-cookie-warning > span");
    By sidebar = By.xpath("//div[@id='sidebar']");

    public WebElement getToggle() throws IOException {
        this.driver = getDriver();
        return driver.findElement(toggle);
    }
    public WebElement getTestStoreLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(testStoreLink);
    }
    public WebElement getCookie() throws IOException {
        this.driver = getDriver();
        return driver.findElement(cookie);
    }
    public WebElement getSidebar() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sidebar);
    }
}
