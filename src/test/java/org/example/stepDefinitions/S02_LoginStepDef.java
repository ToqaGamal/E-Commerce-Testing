package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class S02_LoginStepDef {

    WebDriver driver;
    P02_Login login = new P02_Login();
    SoftAssert soft = new SoftAssert();

    @Given("user go to login page")
    public void login_page()
    {
        login.loginlink().click();
    }


    @When("user login with \"valid\" \"fast@gmail.com\" and \"P@ssw0rd\"")
    public void valid_login_data()
    {
        login.loginData(driver,"automationtesting229@gmail.com","P@ssw0rd");
    }


    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void invalid_login_data()
    {
        login.loginData(driver,"wrong@gmail.com","P@ssw0rd");
    }


    @And("user press on login button")
    public void login_button()
    {
        Hooks.driver.findElement(login.loginBtn()).click();
    }


    @Then("user login to the system successfully")
    public void success_login()
    {
        soft.assertTrue(Hooks.driver.findElement(login.tab()).isDisplayed());
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        soft.assertAll();
    }


    @Then("user could not login to the system")
    public void failed_login()
    {
        String expectedResult="Login was unsuccessful";
        String actualResult=Hooks.driver.findElement(login.failedMSG()).getText();
        soft.assertTrue(actualResult.contains(expectedResult));
        String color=Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getCssValue("color");
        System.out.println("Color: "+color);
        soft.assertAll();
    }

}
