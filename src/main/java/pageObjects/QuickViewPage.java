package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class QuickViewPage extends BaseClass {
    public QuickViewPage() throws IOException {
        super();
    }

    By itemLbl = By.cssSelector(".h1.h1");

    public WebElement getItemLabel() throws IOException{
        this.driver = getDriver();
        return driver.findElement(itemLbl);
    }
}
