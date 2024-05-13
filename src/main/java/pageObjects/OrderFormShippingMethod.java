package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormShippingMethod extends BaseClass {
    public WebDriver driver;

    public OrderFormShippingMethod() throws IOException {
        super();
    }

    By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");
    By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

    public WebElement getDeliveryMsgTextbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(deliveryMsgTextbox);
    }
    public WebElement getContinueBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }
}
