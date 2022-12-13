package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class S05_HoverCategoriesStepDef {
    WebDriver driver;
    P03_HomePage home = new P03_HomePage();

    @Given("user hover categories")
    public void hover()
    {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(home.apparelHover()).perform();
        action.moveToElement(home.electronicsHover()).perform();
        action.moveToElement(home.computerHover()).perform();


    }


    @When("user click on subcategory")
    public void click_subcategory()
    {
        Hooks.driver.findElement(home.desktopSub()).click();
    }


    @And("user go to product page")
    public void product_page()
    {
        String expected="Desktops";
        String actual=Hooks.driver.findElement(home.pageTitle()).getText();
        Assert.assertTrue(actual.contains(expected));
    }

}
