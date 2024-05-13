package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderConfirm extends BaseClass {
    public OrderConfirm() throws IOException {
        super();
    }

    By confirmOrderLbl = By.cssSelector(".card-title.h1");

    public WebElement getConfirmOrderLabel() throws IOException {
        this.driver = getDriver();
        return driver.findElement(confirmOrderLbl);
    }
}
