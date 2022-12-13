package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class S06_HomeSlidersStepDef {
    WebDriver driver;
    P03_HomePage home = new P03_HomePage();

    @When("user choose on Nokia slider")
    public void choose_nokia_slider()
    {
        Hooks.driver.findElement(home.nokiaSliderChoose()).click();
    }

    @And("user click on Nokia slider")
    public void click_nokia_slider()
    {
        home.sliderClick("1").click();
    }

    @Then("user navigate to Nokia URL")
    public void navigates_nokia_url() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020","Bug found in nokia URL");
    }

    @When("user choose on iphone slider")
    public void choose_iphone_slider()
    {
        Hooks.driver.findElement(home.iphoneSliderChoose()).click();
    }

    @And("user click on iphone slider")
    public void click_iphone_slider()
    {
        home.sliderClick("2").click();
    }

    @Then("user navigate to iphone URL")
    public void navigate_iphone_url() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6","Bug found in iphone URL");
    }

}
