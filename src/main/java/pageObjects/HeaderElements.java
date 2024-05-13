package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HeaderElements extends AbstractPage {
    public HeaderElements() throws IOException {
        super();
    }

    By signInBtn = By.cssSelector(".user-info .hidden-sm-down");
    By signOutBtn = By.cssSelector(".hidden-sm-down.logout");
    By storeBtn = By.cssSelector("[alt='Test Store']");
    By searchBar = By.cssSelector("input[name='s']");
    By clothesSection = By.linkText("CLOTHES");
    By clothesMen = By.xpath("//a[@class='dropdown-item dropdown-submenu' and contains(text(), 'Men')]");
    By clothesWomen = By.xpath("//a[@class='dropdown-item dropdown-submenu' and contains(text(), 'Women')]");
    By accessoriesSection = By.linkText("ACCESSORIES");
    By accessoriesStationery = By.xpath("//a[@class='dropdown-item dropdown-submenu' and contains(text(), 'Stationery')]");
    By accessoriesHome = By.xpath("//a[@class='dropdown-item dropdown-submenu' and contains(text(), 'Home Accessories')]");
    By artSection = By.linkText("ART");

    public WebElement getSignInBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(signInBtn);
    }
    public WebElement getSignOutBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(signOutBtn);
    }
    public WebElement getStoreBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(storeBtn);
    }
    public WebElement getSearchBar() throws IOException{
        this.driver = getDriver();
        return driver.findElement(searchBar);
    }
    public WebElement getClothesSection() throws IOException{
        this.driver = getDriver();
        return driver.findElement(clothesSection);
    }
    public WebElement getClothesMen() throws IOException{
        this.driver = getDriver();
        return driver.findElement(clothesMen);
    }
    public WebElement getClothesWomen() throws IOException{
        this.driver = getDriver();
        return driver.findElement(clothesWomen);
    }
    public WebElement getAccessoriesSection() throws IOException{
        this.driver = getDriver();
        return driver.findElement(accessoriesSection);
    }
    public WebElement getAccessoriesStationery() throws IOException{
        this.driver = getDriver();
        return driver.findElement(accessoriesStationery);
    }
    public WebElement getAccessoriesHome() throws IOException{
        this.driver = getDriver();
        return driver.findElement(accessoriesHome);
    }
    public WebElement getArtSection() throws IOException{
        this.driver = getDriver();
        return driver.findElement(artSection);
    }
}
