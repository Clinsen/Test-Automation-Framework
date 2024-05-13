package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreFilterPage extends BaseClass {
    public StoreFilterPage() throws IOException {
        super();
    }

    By sectionLbl = By.cssSelector(".h1");

    public WebElement getSectionLabel() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sectionLbl);
    }
}
