package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class S03_Currency {

    WebDriver driver;
    P03_HomePage home = new P03_HomePage (Hooks.driver);
    Select select = new Select(home.currency());


    @When("user select euro option")
    public void select_euro()
    {
        //Static dropdown
//        WebElement currencyList = Hooks.driver.findElement(By.id("customerCurrency"));
//        Select select = new Select(currencyList);
//        select.selectByVisibleText("Euro");

        select.selectByVisibleText("Euro");

    }


    @Then("euro symbol is displayed on all products")
    public void euroSymbolIsDisplayedOnAllProducts()
    {
        //Find elements

        int count = home.euroPrice().size();
        for (int i=0; i<count;i++) {
            String symbol = home.euroSymbol().getText();
            Assert.assertTrue(symbol.contains("€"));

        }

    }

}
