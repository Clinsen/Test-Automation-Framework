import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;
import pageObjects.*;
import base.Hooks;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class LoginTest extends Hooks {
    public LoginTest() throws IOException {
        super();
    }

    @Test
    public void SimulateLoginProcess() throws IOException, InterruptedException{
        BaseClass base = new BaseClass();
        base.openWebStore();

        // Click on sign in btn
        HeaderElements header = new HeaderElements();
        waitForClickabilityOf(header.getSignInBtn(), Duration.ofSeconds(10));
        header.getSignInBtn().click();
        
        // Only for demo purposes
        String login = "testing123@test.com";
        String pass = "Testing!123";

        // Enter data, submit it
        LoginPage lPage = new LoginPage();
        lPage.getEmailField().sendKeys(login);
        lPage.getPasswordField().sendKeys(pass);
        lPage.getSubmitBtn().click();

        // Assert that we're logged in
        waitForVisibilityOf(header.getSignOutBtn(), Duration.ofSeconds(10));
        Assert.assertTrue(header.getSignOutBtn().isDisplayed());

        System.out.println("Login test has been simulated.");
        //Thread.sleep(5000);
    }
}
