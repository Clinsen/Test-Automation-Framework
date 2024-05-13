package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreContentPanel extends AbstractPage {
    public StoreContentPanel() throws IOException {
        super();
    }

    By continueShoppingBtn = By.cssSelector(".cart-content-btn [data-dismiss]");
    By proceedToCheckoutBtn = By.cssSelector(".modal-body .btn.btn-primary");

    public WebElement getContinueShoppingBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueShoppingBtn);
    }
    public WebElement getProceedToCheckoutBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(proceedToCheckoutBtn);
    }
}
