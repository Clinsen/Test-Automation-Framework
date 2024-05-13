package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreProductPage extends AbstractPage {
    public StoreProductPage() throws IOException {
        super();
    }

    By sizeOption = By.cssSelector("[aria-label='Size']");
    By quantityIncreaseBtn = By.cssSelector(".touchspin-up");
    By quantityDecreaseBtn = By.cssSelector(".touchspin-down");
    By addToCartBtn = By.cssSelector("[data-button-action]");
    By homepageLink = By.cssSelector("ol li:nth-of-type(1) span");

    public WebElement getSizeOption() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sizeOption);
    }
    public WebElement getQuantityIncreaseBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(quantityIncreaseBtn);
    }
    public WebElement getQuantityDecreaseBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(quantityDecreaseBtn);
    }
    public WebElement getAddToCartBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(addToCartBtn);
    }
    public WebElement getHomepageLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(homepageLink);
    }
}
