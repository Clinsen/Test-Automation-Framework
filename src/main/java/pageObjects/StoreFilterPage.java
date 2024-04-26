package pageObjects;

import base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreFilterPage extends PageObjectBase {
    public StoreFilterPage() throws IOException {
        super();
    }

    By sectionLbl = By.cssSelector(".h1");

    public WebElement getSectionLabel() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sectionLbl);
    }
}
