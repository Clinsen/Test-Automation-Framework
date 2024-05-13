package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class StoreHomepage extends AbstractPage {
    public StoreHomepage() throws IOException {
        super();
    }

    By carouselItems = By.xpath("//div[@id='carousel']/ul[@class='carousel-inner']/li");
    By carouselActiveItem = By.xpath("//div[@id='carousel']/ul[@class='carousel-inner']/li[@class='carousel-item active']");
    By carouselGoLeftBtn = By.cssSelector("div#carousel > div > a:nth-of-type(1)");
    By carouselGoRightBtn = By.cssSelector("div#carousel > div > a:nth-of-type(2)");
    By popularProducts = By.xpath("//section[@class='featured-products clearfix']/div[@class='products row']");
    By onSaleProducts = By.xpath("(//section[@class='featured-products clearfix mt-3']/div[@class='products'])[1]");
    By newProducts = By.xpath("(//section[@class='featured-products clearfix mt-3']/div[@class='products'])[2]");
    By emailField = By.xpath("//input[@name='email']");
    By subscribeBtn = By.xpath("//input[@value='Subscribe']");
    By subscriptionAlert = By.cssSelector(".block_newsletter_alert");

    public List<WebElement> getCarouselItems() throws IOException {
        this.driver = getDriver();
        return driver.findElements(carouselItems);
    }
    public int getCarouselItemCount() throws IOException {
        this.driver = getDriver();
        List<WebElement> carouselItemList = this.driver.findElements(carouselItems);
        return carouselItemList.size();
    }
    public WebElement getCarouselActiveItem() throws IOException {
        this.driver = getDriver();
        return driver.findElement(carouselActiveItem);
    }
    public WebElement getCarouselGoLeftBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(carouselGoLeftBtn);
    }
    public WebElement getCarouselGoRightBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(carouselGoRightBtn);
    }
    public List<WebElement> getPopularProducts() throws IOException {
        this.driver = getDriver();
        return driver.findElements(popularProducts);
    }
    public List<WebElement> getOnSaleProducts() throws IOException {
        this.driver = getDriver();
        return driver.findElements(onSaleProducts);
    }
    public List<WebElement> getNewProducts() throws IOException {
        this.driver = getDriver();
        return driver.findElements(newProducts);
    }
    public WebElement getEmailField() throws IOException {
        this.driver = getDriver();
        return driver.findElement(emailField);
    }
    public WebElement getSubscribeBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(subscribeBtn);
    }
    public List<WebElement> getSubscriptionAlert() throws IOException {
        this.driver = getDriver();
        // Using list to check whether the element is present in DOM
        return driver.findElements(subscriptionAlert);
    }
}
