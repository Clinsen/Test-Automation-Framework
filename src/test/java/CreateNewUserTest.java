import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;
import pageObjects.*;
import base.Hooks;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class CreateNewUserTest extends Hooks {
    public CreateNewUserTest() throws IOException {
        super();
    }

    @Test
    public void SimulateUserCreation() throws IOException, InterruptedException{
        BaseClass base = new BaseClass();
        base.openWebStore();

        String email = generateEmail();

        // Click on sign in btn
        HeaderElements header = new HeaderElements();
        waitForClickabilityOf(header.getSignInBtn(), Duration.ofSeconds(10));
        header.getSignInBtn().click();

        // Click on create account btn
        LoginPage lPage = new LoginPage();
        lPage.getAccountCreateBtn().click();

        // Fill in the necessary info
        CreateAccountPage caPage = new CreateAccountPage();
        waitForVisibilityOf(caPage.getSocialTitleMr(), Duration.ofSeconds(10));
        caPage.getSocialTitleMr().click();
        caPage.getFirstNameField().sendKeys("NameTest");
        caPage.getLastNameField().sendKeys("LastNameTest");
        caPage.getEmailField().sendKeys(email);
        caPage.getPasswordField().sendKeys("pwdTest");
        caPage.getPolicyCheckbox().click();
        caPage.getSaveAccountInfoBtn().click();

        // Check if we're logged in
        waitForVisibilityOf(header.getSignOutBtn(), Duration.ofSeconds(10));
        Assert.assertTrue(header.getSignOutBtn().isDisplayed());
        //Thread.sleep(5000);
    }
}
