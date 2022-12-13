package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class S07_FollowUsStepDef {
    WebDriver driver;
    P03_HomePage home = new P03_HomePage();

    @When("user opens facebook link")
    public void facebook_link()
    {
        home.facbookLink().click();
    }


    @Then("Facebook URL is opened in new tab")
    public void facebook_tab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
    }


    @When("user opens twitter link")
    public void twitterlink() throws InterruptedException {
        home.twitterLink().click();
    }


    @Then("Twitter URL is opened in new tab")
    public void twitter_tab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }


    @When("user opens rss link")
    public void rss_link()
    {
        home.rssLink().click();
    }


    @Then("RSS URL is opened in new tab")
    public void rss_tab() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open","Bug found in rss url navigation");
        Thread.sleep(3000);
    }


    @When("user opens youtube link")
    public void youtube_link()
    {
        home.youtubeLink().click();
    }


    @Then("YouTube URL is opened in new tab")
    public void youtube_tab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }

}
