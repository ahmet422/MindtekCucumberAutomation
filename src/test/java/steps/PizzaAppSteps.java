package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import javax.xml.crypto.Data;
import java.util.Map;

public class PizzaAppSteps {
    PizzaAppPage pizzaAppPage=new PizzaAppPage();
    Map<String,Object> data;
    String cost;
    WebDriver driver= Driver.getDriver();
    @Given("user navigates to pizza application")
    public void user_navigates_to_pizza_application() {
        driver.get(ConfigReader.getProperty("PizzaAppURL"));


    }

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) {
   data=dataTable.asMap(String.class, Object.class);
//        for(Object object: data.values()){
//            System.out.println(object);
//        }
        BrowserUtils.selectDropDownByValue(pizzaAppPage.pizza1Box, data.get("Pizza").toString());
        BrowserUtils.selectDropDownByValue(pizzaAppPage.toppings1Box, data.get("Toppings 1").toString());
        BrowserUtils.selectDropDownByValue(pizzaAppPage.toppings2Box, data.get("Toppings 2").toString());
        pizzaAppPage.quantityBox.sendKeys(data.get("Quantity").toString());
        pizzaAppPage.nameBox.sendKeys(data.get("Name").toString());
        pizzaAppPage.emailBox.sendKeys(data.get("Email").toString());
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone").toString());
        if(data.get("Payment Type").toString().equalsIgnoreCase("Cash on Pickup")){
            pizzaAppPage.cashPayment.click();
        }else if(data.get("Payment Type").toString().equalsIgnoreCase("Credit Card")) {
            pizzaAppPage.creditCardPayment.click();
        }
        cost=pizzaAppPage.cost.getAttribute("value");
        pizzaAppPage.placeOrderButton.click();
    }

    @Then("user validates that order is created with success message {string}")
    public void user_validates_that_order_is_created_with_success_message(String expectedMessage) {

    }


    @Then("user validates that order is created with success message {string} {string}")
    public void userValidatesThatOrderIsCreatedWithSuccessMessage(String success, String pizza) {
        String expectedSuccessMessage= success+cost +" "+pizza;
        String actualMessage=pizzaAppPage.successMessage.getText();
        Assert.assertEquals(expectedSuccessMessage, actualMessage);
    }
}
