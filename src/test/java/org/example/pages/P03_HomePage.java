package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefinitions.Hooks.driver;

public class P03_HomePage {

    public P03_HomePage()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    WebDriver driver;
    public P03_HomePage(WebDriver driver)
    {
        this.driver = driver;
    }



    public WebElement currency()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[1]/div/select"));
    }

    public WebElement euroSymbol()
    {
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    public List euroPrice()
    {
        return driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[1]/div[1]/div/select/option[2]"));
    }

//    public List<WebElement> prices()
//    {
//        List<WebElement> prices = driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
//        return prices;
//
//    }



    //04) SEARCH
    @FindBy(id="small-searchterms")
    public WebElement searchField;
    @FindBy(className="button-1")
    public WebElement searchBtn;

    public List<WebElement> productName()
    {
        List<WebElement> product=driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/h2"));
        return product;
    }
    public List<WebElement> productData()
    {
        List<WebElement> data=Hooks.driver.findElements(By.className("item-box"));
        return data;
    }
    public WebElement selectProduct()
    {
        WebElement element=Hooks.driver.findElement(By.className("picture"));
        return element;
    }
    public WebElement product_serial()
    {
        WebElement element=Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"]>span[class=\"value\"]"));
        return element;
    }


    //05)Hover Categories
    public WebElement computerHover(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
    }
    public WebElement electronicsHover(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
    }
    public WebElement apparelHover()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
    }
    public By desktopSub()
    {
        return By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a");
    }
    public By pageTitle()
    {
        return By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1");
    }


    //06) HomeSliders
    public By nokiaSliderChoose()
    {
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[1]");
    }
    public By iphoneSliderChoose()
    {
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]");
    }
    public WebElement sliderClick(String num)
    {
        return Hooks.driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])["+num+"]"));
    }


    //07) FOLLOW US
    public WebElement facbookLink()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a"));
    }
    public WebElement twitterLink()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[2]/a"));
    }
    public WebElement rssLink()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[3]/a"));
    }
    public WebElement youtubeLink()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[4]/a"));
    }


    //08) WISHLIST
    public WebElement htcWishlist()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement qtyValue()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]"));
    }


}
