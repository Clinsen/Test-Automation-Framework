package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Homepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class BaseClass {
    public WebDriver driver;
    private String url;
    private final Properties prop;

    public BaseClass() throws IOException{
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
        prop.load(data);
    }

    public static WebDriver getDriver() throws IOException{
        return WebDriverInstance.getDriver();
    }

    public String getUrl() throws IOException{
        url = prop.getProperty("url");
        return url;
    }

    public void takeScreenShot(String name) throws IOException{
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);
    }

    public String timestamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }


    /**
     *
     * FOLLOWING FIELDS AND METHODS
     * ARE MUTUAL TO THE PAGE OBJECT MODEL
     *
     */

    // Both selectors return first found element
    By firstProduct = By.cssSelector("[data-id-product]");
    By quickViewFirstItem = By.cssSelector(".js-quick-view.quick-view");

    public WebElement getQuickView() throws IOException{
        this.driver = getDriver();
        return driver.findElement(quickViewFirstItem);
    }
    public WebElement getFirstProduct() throws IOException{
        this.driver = getDriver();
        return driver.findElement(firstProduct);
    }

    public void openWebStore() throws IOException {
        Homepage home = new Homepage();

        // Close the cookie pop-up
        home.getCookie().click();

        // If the sidebar is invisible to user - open it
        if (home.getSidebar().getAttribute("class").contains("inactive")){
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());

        // Go to the web store
        waitForClickabilityOf(home.getTestStoreLink(), Duration.ofSeconds(10));
        home.getTestStoreLink().click();
    }

    public String generateEmail(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int strLength = 10;
        Random random = new Random();

        String email = random.ints(leftLimit, rightLimit + 1)
                .limit(strLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        email += "@test.com"; // Appending domain to make it a valid email address

        return email;
    }

    // Waits
    protected static void waitForClickabilityOf(WebElement element, Duration timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected static void waitForInvisibilityOf(WebElement element, Duration timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    protected static void waitForStalenessOf(WebElement element, Duration timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.stalenessOf(element));
    }
    protected static void waitForVisibilityOf(WebElement element, Duration timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
