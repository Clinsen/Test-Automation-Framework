package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormPersInfo extends BaseClass {
    public OrderFormPersInfo() throws IOException {
        super();
    }

    By genderMale = By.cssSelector("[for='field-id_gender-1'] [type]");
    By genderFemale = By.cssSelector("[for='field-id_gender-2'] [type]");
    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By emailField = By.cssSelector("input#field-email");
    By passwordField = By.cssSelector("form#customer-form > section input[name='password']");
    By birthDateField = By.cssSelector("input[name='birthday']");
    By receiveOffersCheckbox = By.cssSelector("div:nth-of-type(7)  span > label > span");
    By newsletterCheckbox = By.cssSelector("div:nth-of-type(8)  span > label > span");
    By termsConditionsCheckbox = By.cssSelector("input[name='psgdpr']");
    By continueBtn = By.cssSelector("form#customer-form  button[name='continue']");

    public WebElement getGenderMale() throws IOException {
        this.driver = getDriver();
        return driver.findElement(genderMale);
    }
    public WebElement getGenderFemale() throws IOException {
        this.driver = getDriver();
        return driver.findElement(genderFemale);
    }
    public WebElement getFirstNameField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(firstNameField);
    }
    public WebElement getLastnameField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(lastNameField);
    }
    public WebElement getEmailField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailField);
    }
    public WebElement getPasswordField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(passwordField);
    }
    public WebElement getBirthDateField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(birthDateField);
    }
    public WebElement getRecOfferCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(receiveOffersCheckbox);
    }
    public WebElement getNewsletterCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(newsletterCheckbox);
    }
    public WebElement getTermsConditionsCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(termsConditionsCheckbox);
    }
    public WebElement getContinueBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }
}
