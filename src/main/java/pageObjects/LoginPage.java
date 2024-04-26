package pageObjects;

import base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends PageObjectBase {
    public LoginPage() throws IOException {
        super();
    }

    By emailField = By.cssSelector("input#field-email");
    By pwdField = By.cssSelector("input#field-password");
    By submitBtn = By.cssSelector("button#submit-login");

    public WebElement getEmailField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailField);
    }
    public WebElement getPasswordField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(pwdField);
    }
    public WebElement getSubmitBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(submitBtn);
    }
}
