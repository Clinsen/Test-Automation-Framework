package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HeaderElements extends BasePage {
    public WebDriver driver;

    public HeaderElements() throws IOException {
        super();
    }

    By signInBtn = By.cssSelector(".user-info .hidden-sm-down");
    By signOutBtn = By.cssSelector(".hidden-sm-down.logout");

    public WebElement getSignInBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(signInBtn);
    }
    public WebElement getSignOutBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(signOutBtn);
    }
}
