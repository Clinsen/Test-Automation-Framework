package pageObjects;

import base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShoppingCart extends PageObjectBase {
    public ShoppingCart() throws IOException {
        super();
    }

    By havePromo = By.linkText("Have a promo code?");
    By promoTextbox = By.cssSelector("input[name='discount_name']");
    By addPromoBtn = By.cssSelector("form[method='post']  span");
    By closePromo = By.linkText("Close");
    By proceedToCheckoutBtn = By.linkText("PROCEED TO CHECKOUT");
    By quantityIncreaseBtn = By.cssSelector(".touchspin-up");
    By quantityDecreaseBtn = By.cssSelector(".touchspin-down");
    By totalAmountVal = By.cssSelector(".cart-total .value");
    String removeItemBtn = "(//a[@class='remove-from-cart'])[%d]";

    public WebElement getHavePromo() throws IOException {
        this.driver = getDriver();
        return driver.findElement(havePromo);
    }
    public WebElement getPromoTextbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(promoTextbox);
    }
    public WebElement getAddPromoBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(addPromoBtn);
    }
    public WebElement getClosePromo() throws IOException {
        this.driver = getDriver();
        return driver.findElement(closePromo);
    }
    public WebElement getProceedToCheckoutBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(proceedToCheckoutBtn);
    }
    public WebElement getQuantityIncreaseBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(quantityIncreaseBtn);
    }
    public WebElement getQuantityDecreaseBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(quantityDecreaseBtn);
    }
    public WebElement getTotalAmountValue() throws IOException {
        this.driver = getDriver();
        return driver.findElement(totalAmountVal);
    }
    public WebElement getRemoveItemBtn(int itemNumber) throws IOException {
        this.driver = getDriver();
        String xpathExpression = String.format(removeItemBtn, itemNumber);
        return driver.findElement(By.xpath(xpathExpression));
    }
}
