package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S04_SearchStepDef {
    P03_HomePage home = new P03_HomePage();
    SoftAssert soft = new SoftAssert();

    @When("user click on search field")
    public void search_field(){
        home.searchField.click();
    }

    @And("user search with {string}")
    public void userSearchWith(String text)
    {
            home.searchField.sendKeys(text);
            home.searchField.sendKeys(Keys.ENTER);
        }

    @Then("user could find {string} relative results")
    public void userCouldFindRelativeResults(String word)
    {
        String text = null;
        for (int i=0; i < home.productData().size();i++){
            text=home.productData().get(i).getText().toLowerCase();
        }
        soft.assertTrue(text.contains(word));
        String expected = "https://demo.nopcommerce.com/search?q=";
        String actual = Hooks.driver.getCurrentUrl();
        soft.assertTrue(actual.contains(expected));
        soft.assertAll();
    }


    @Then("user could find {string} inside product details page")
    public void userCouldFindInsideProductDetailPage(String serial) {
           home.selectProduct().click();
            String productSerial = home.product_serial().getText();
            Assert.assertTrue(serial.contains(productSerial));
    }


}
