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
        Homepage home = new Homepage();

        home.getCookie().click();

        if (home.getSidebar().getAttribute("class").contains("inactive")){
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());

        waitForClickabilityOf(home.getTestStoreLink(), Duration.ofSeconds(10));
        home.getTestStoreLink().click();

        HeaderElements header = new HeaderElements();
        waitForClickabilityOf(header.getSignInBtn(), Duration.ofSeconds(10));
        header.getSignInBtn().click();

        // Only for demo purposes
        String login = "testing123@test.com";
        String pass = "Testing!123";

        LoginPage lPage = new LoginPage();
        lPage.getEmailField().sendKeys(login);
        lPage.getPasswordField().sendKeys(pass);
        lPage.getSubmitBtn().click();

        Assert.assertTrue(header.getSignOutBtn().isDisplayed());
    }
}
