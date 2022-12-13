package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Registration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefinitions.Hooks.driver;

public class S01_RegistrationStepDef {
    WebDriver driver;
    P01_Registration register = new P01_Registration();

    @Given("user go to register page")
    public void registrationPage()
    {

        register.registerlink().click();
    }

    P01_Registration female = new P01_Registration();
    @When("user select gender type")
    public void gender()
    {
        register.genderType.click();
    }

    @And("user enter firstname {string} and lastname {string}")
    public void first_last_name(String firstname, String lastname)
    {
        register.nameInput(driver,"automation","tester");
    }

//    @And("user enter date of birth")
//    public void date_of_birth()
//    {
//        WebElement birthday = Hooks.driver.findElement(By.className("DateOfBirthDay"));
//        Select select = new Select(birthday);
//        select.selectByIndex(27);
//
//        select = new Select(register.birthMonth);
//        select.selectByValue("4");
//
//        select = new Select(register.birthYear);
//        select.selectByVisibleText("1996");
//    }
//

//    @And("user fills Password fields {string}")
//    public void userFillsPasswordFields(String password)
//
//    {
//        register.password.sendKeys(password);
//    }
//
//    public void enterName()
//    {
//        register.nameInput(driver,"automation","tester");
//
//    }


    @And("user enter date of birth")
    public void date_of_brith()
    {
        Hooks.driver.findElement(register.brithDay()).click();
        Hooks.driver.findElement(register.brithMonth()).click();
        Hooks.driver.findElement(register.brithYear()).click();
    }


    @And("user enter email \"test@example.com\" field")
    public void enter_email()
    {
        register.enterEmail(driver,"automationtesting229@gmail.com");
    }


    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void fills_password()
    {
        register.enterPassword(driver,"P@ssw0rd","P@ssw0rd");

    }


    @And("user clicks on register button")
    public void register_button()
    {
        Hooks.driver.findElement(register.registerBtn()).click();
    }


    @Then("success message is displayed")
    public void success_message()
    {
        SoftAssert soft = new SoftAssert();
        String expectedResult = "Your registration completed";
        String actualResult = Hooks.driver.findElement(register.successMSG()).getText();
        soft.assertTrue(actualResult.contains(expectedResult));
        String color = Hooks.driver.findElement(By.className("result")).getCssValue("color");
        System.out.println("Color: " + color);
        soft.assertAll();
    }

}
