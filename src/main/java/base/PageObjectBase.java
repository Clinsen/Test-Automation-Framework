package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class PageObjectBase extends BasePage {
    public WebDriver driver;

    public PageObjectBase() throws IOException {
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
}