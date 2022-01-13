package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HrAppLoginPage;
import pages.HrAppNewEmployeePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class HrAppSteps {
    WebDriver driver = Driver.getDriver();
    HrAppLoginPage hrAppLoginPage = new HrAppLoginPage();
    HrAppNewEmployeePage hrAppNewEmployeePage = new HrAppNewEmployeePage();


   // final String firstName = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
  //  final String lastName = UUID.randomUUID().toString().replace("-", "").substring(0, 7);


    @Given("User navigates to HR App {string} Page")
    public void user_navigates_to_HR_App_Page(String hrAppUrl) {
        driver.get(ConfigReader.getProperty("HrAppQaURL"));

    }

    @When("user enters {string} for username and {string} for password and clicks login button")
    public void user_enters_for_username_and_for_password_and_clicks_login_button(String username, String password) {
        hrAppLoginPage.username.sendKeys(username);
        hrAppLoginPage.password.sendKeys(password);
        hrAppLoginPage.loginButton.click();

    }

    @Then("user lands on the {string} page where he sees the list of the employees")
    public void user_lands_on_the_page_where_he_sees_the_list_of_the_employees(String mainPageURL) {
       
    }


  /*  @Then("{string} message is displayed")
    public void message_is_displayed(String errorMessage) {
        String actualErrorMessage=hrAppLoginPage.errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, errorMessage);*/


    @And("User clicks on Create new employee tab")
    public void userClicksOnCreateNewEmployeeTab() throws InterruptedException {

        Thread.sleep(5000);
        hrAppNewEmployeePage.createNewEmployeeButton.click();
        hrAppNewEmployeePage.firstName.sendKeys("Lily");
        hrAppNewEmployeePage.lastName.sendKeys("Brown");
    }


    @And("User provides data for the input fields and clicks on SAVE button")
    public void userProvidesDataForTheInputFieldsAndClicksOnSAVEButton() throws InterruptedException {
        Thread.sleep(5000);


        //WebDriverWait wait=new WebDriverWait(driver, 10);
        //  wait.until(ExpectedConditions.elementToBeClickable(hrAppNewEmployeePage.jobTitle));


        // Thread.sleep(5000);


        BrowserUtils.selectDropDownByValue(hrAppNewEmployeePage.department, "Marketing");

        //  Thread.sleep(5000);
        // Select select1=new Select(hrAppNewEmployeePage.jobTitle);
        // select1.selectByVisibleText("Administration Assistant");

        // BrowserUtils.selectDropDownByValue(hrAppNewEmployeePage.department,"20");
         BrowserUtils.selectDropDownByValue(hrAppNewEmployeePage.jobTitle,"FI_ACCOUNT");
        //hrAppNewEmployeePage.salary.clear();
        hrAppNewEmployeePage.salary.sendKeys("50000");
        //Thread.sleep(3000);

        hrAppNewEmployeePage.saveButton.click();
        // Thread.sleep(3000);

    }
}


  /*  @Then("User validates new employee is created")
    public void userValidatesNewEmployeeIsCreated() {
        for(int i=hrAppNewEmployeePage.firstNames.size()-1; i>=0; i--){
            if(hrAppNewEmployeePage.firstNames.get(i).getText().equals(firstName)){
                Assert.assertEquals(lastName,hrAppNewEmployeePage.lastNames.get(i).getText());
            }
        }
    }


}
/*package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HrAppLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HrAppSteps{
    WebDriver driver = Driver.getDriver();
    HrAppLoginPage hrAppLoginPage=new HrAppLoginPage();
    @Given("User navigates to HrApp Login Page")
    public void user_navigates_to_HrApp_Login_Page() {
        driver.get(ConfigReader.getProperty("HrAppDevURL"));

    }

    @When("user enters {string} for username and user enters for password {string} and clicks on login button")
    public void user_enters_for_username_and_user_enters_for_password_and_clicks_on_login_button(String username, String password) {
        hrAppLoginPage.userName.sendKeys(username);
        hrAppLoginPage.Password.sendKeys(password);
        hrAppLoginPage.loginButton.click();

    }


    @Then("user lands on main page where he sees the list of employees")
    public void user_lands_on_main_page_where_he_sees_the_list_of_employees() {
        String actualResult= driver.getCurrentUrl();
        Assert.assertEquals("https://devenv-webhr-arslan.herokuapp.com/employees", actualResult);


    }


}
*/