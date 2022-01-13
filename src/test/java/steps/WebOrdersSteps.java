package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class WebOrdersSteps {
    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();
    int numberOfRows;
    List<Map<String, Object>> data;

    @Given("user navigates to the weborders application")
    public void user_navigates_to_the_weborders_application() {
        driver.get(ConfigReader.getProperty("WebOrdersURL"));
    }

    @When("user provides username {string} and password {string} clicks on login button")
    public void user_provides_username_and_password_clicks_on_login_button(String username, String password) {

        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();
    }

    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders";

        Assert.assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }

    @Then("user validates failed login error message {string}")
    public void user_validates_failed_login_error_message(String errorMessage) {
        System.out.println(webOrdersLoginPage.errorMsg.getText());
        Assert.assertEquals(webOrdersLoginPage.errorMsg.getText(), errorMessage);
    }


    @When("user provides username {string} and password {string}clicks on login button")
    public void userProvidesUsernameAndPasswordClicksOnLoginButton(String username, String password) {
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();
    }

    @And("user clicks on Order module")
    public void userClicksOnOrderModule() {
        webOrdersOrderPage.orderModule.click();

    }

    @And("user selects {string} product with {int} quantity")
    public void userSelectsProductWithQuantityQuantity(String product, int quantity) {
        BrowserUtils.selectDropDownByValue(webOrdersOrderPage.productSelection, product);
        webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderPage.quantityBox.sendKeys(quantity + "" + Keys.ENTER);
    }

    @Then("validates total is calculated correctly for quantity {int}")
    public void validatesTotalIsCalculatedCorrectlyForQuantityQuantity(int quantity) {
        String pricePerUnit = webOrdersOrderPage.perUnitPrice.getAttribute("value");
        int expectedTotal = 0;
        String discountAmount = webOrdersOrderPage.discountRate.getAttribute("value");
        int discountAmountInt = Integer.parseInt(discountAmount);
        int pricePerUnitInt = Integer.parseInt(pricePerUnit);
        if (discountAmountInt == 0) {
            expectedTotal = quantity * pricePerUnitInt;
        } else {
            expectedTotal = quantity * pricePerUnitInt;
            expectedTotal = expectedTotal - expectedTotal * discountAmountInt / 100;
        }
        String actualTotal = webOrdersOrderPage.totalBox.getAttribute("value");
        int actualTotalInt = Integer.parseInt(actualTotal);
        Assert.assertEquals(expectedTotal, actualTotalInt);

    }

    @When("user creates Order module")
    public void user_creates_Order_module() {

    }


    @When("user creates order with date")
    public void user_creates_order_with_date(DataTable dataTable) {
        List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);
        BrowserUtils.selectDropDownByValue(webOrdersOrderPage.dropDown, data.get(0).get("order").toString());
        webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderPage.quantityBox.sendKeys(data.get(0).get("quantity").toString());
        webOrdersOrderPage.name.sendKeys(data.get(0).get("name").toString());
        webOrdersOrderPage.street.sendKeys(data.get(0).get("street").toString());
        webOrdersOrderPage.city.sendKeys(data.get(0).get("city").toString());
        webOrdersOrderPage.state.sendKeys(data.get(0).get("state").toString());
        webOrdersOrderPage.zip.sendKeys(data.get(0).get("zip").toString());
        webOrdersOrderPage.visaCheckBox.click();
        webOrdersOrderPage.cardNumber.sendKeys(data.get(0).get("cc").toString());
        webOrdersOrderPage.expDate.sendKeys(data.get(0).get("expire date").toString());
        webOrdersOrderPage.processButton.click();

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }

    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
        String actualMessage = webOrdersOrderPage.sucessMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        // Write code here that turns the phrase above into concrete actions


    }


    @Then("user validates order added to list of orders")
    public void userValidatesOrderAddedToListOfOrders() {

        webOrdersOrderPage.viewAllOrdersModule.click();
        int numberOfRowsAfterorderCreation = webOrdersOrderPage.rows.size();
        Assert.assertEquals(numberOfRowsAfterorderCreation - numberOfRows, 1);

        String actualName = webOrdersOrderPage.firstNameInRow.getText();
        Assert.assertEquals(data.get(0).get("name").toString(),actualName);

    }

    @When("user counts number of orders in table")
    public void user_counts_number_of_orders_in_table() {
        numberOfRows = webOrdersOrderPage.rows.size();


    }


}

