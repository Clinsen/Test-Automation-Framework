package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CreateAccountPage extends BaseClass {
    public CreateAccountPage() throws IOException {
        super();
    }

    By socialTitleMr = By.cssSelector("[for='field-id_gender-1']");
    By socialTitleMrs = By.cssSelector("[for='field-id_gender-2']");
    By firstNameField = By.cssSelector("[name='firstname']");
    By lastNameField = By.cssSelector("[name='lastname']");
    By emailField = By.cssSelector(".register-form [name='email']");
    By pwdField = By.cssSelector("[name='password']");
    By policyCheckbox = By.cssSelector("[name='psgdpr']");
    By saveAccountInfoBtn = By.cssSelector("[data-link-action]");

    public WebElement getSocialTitleMr() throws IOException {
        this.driver = getDriver();
        return driver.findElement(socialTitleMr);
    }
    public WebElement getSocialTitleMrs() throws IOException {
        this.driver = getDriver();
        return driver.findElement(socialTitleMrs);
    }
    public WebElement getFirstNameField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(firstNameField);
    }
    public WebElement getLastNameField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(lastNameField);
    }
    public WebElement getEmailField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailField);
    }
    public WebElement getPasswordField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(pwdField);
    }
    public WebElement getPolicyCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(policyCheckbox);
    }
    public WebElement getSaveAccountInfoBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(saveAccountInfoBtn);
    }
}
