package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.TestSheepAppPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class TestSheepCalculatorAppSteps {
    WebDriver driver=Driver.getDriver();
    TestSheepAppPage testSheepApp=new TestSheepAppPage();

    @Given("user navigates to TestSheep application")
    public void user_navigates_to_TestSheep_application() {
        driver.get(ConfigReader.getProperty("TestSheepApp"));


    }

    @When("user enters {string} as first number")
    public void user_enters_as_first_number(String firstNum) {
        testSheepApp.firstNumber.sendKeys(firstNum);



    }

    @When("user enters {string} as second number")
    public void user_enters_as_second_number(String secondNum) {
        testSheepApp.secondNumber.sendKeys(secondNum);

    }

    @When("user selects {string}  operator")
    public void userSelectsOperator(String operation) {
     BrowserUtils.selectByText(testSheepApp.dropdownMenu, operation);

    }

    @When("user clicks Calculate button")
    public void user_clicks_Calculate_button() {
        testSheepApp.calculateButton.click();

    }

    @Then("user validates output is {int}.")
    public void user_validates_output_is(Integer int1) {
        Assert.assertEquals(int1.toString(), testSheepApp.totalNumber.getAttribute("value"));

    }


    @Then("user validates {string} error message")
    public void userValidatesErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, testSheepApp.errorMsg.getText());

    }
}

