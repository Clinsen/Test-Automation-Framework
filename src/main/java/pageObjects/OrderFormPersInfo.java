package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFormPersInfo {
    public WebDriver driver;

    public OrderFormPersInfo(WebDriver driver) {
        this.driver = driver;
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

    public WebElement getGenderMale() {
        return driver.findElement(genderMale);
    }
    public WebElement getGenderFemale() {
        return driver.findElement(genderFemale);
    }
    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }
    public WebElement getLastnameField() {
        return driver.findElement(lastNameField);
    }
    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }
    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }
    public WebElement getBirthDateField() {
        return driver.findElement(birthDateField);
    }
    public WebElement getRecOfferCheckbox() {
        return driver.findElement(receiveOffersCheckbox);
    }
    public WebElement getNewsletterCheckbox() {
        return driver.findElement(newsletterCheckbox);
    }
    public WebElement getTermsConditionsCheckbox() {
        return driver.findElement(termsConditionsCheckbox);
    }
    public WebElement getContinueBtn() {
        return driver.findElement(continueBtn);
    }
}