package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BaseClass {
    public LoginPage() throws IOException {
        super();
    }

    By emailField = By.cssSelector("input#field-email");
    By pwdField = By.cssSelector("input#field-password");
    By submitBtn = By.cssSelector("button#submit-login");
    By accountCreateBtn = By.cssSelector("[data-link-action='display-register-form']");

    public WebElement getEmailField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailField);
    }
    public WebElement getPasswordField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(pwdField);
    }
    public WebElement getSubmitBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(submitBtn);
    }
    public WebElement getAccountCreateBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(accountCreateBtn);
    }
}
