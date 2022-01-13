package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.OrangeHRMHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class OrangeHRMSteps {
    WebDriver driver = Driver.getDriver();
    OrangeHRMHomePage orangeHRMHomePage=new OrangeHRMHomePage();


    @Given("user navigates to OrangeHR application")
    public void user_navigates_to_OrangeHR_application() {
        driver.get(ConfigReader.getProperty("OrangeHRMAppURL"));

    }

    @When("user enters {string} for username and {string} for password and clicks on login button")
    public void user_enters_for_username_and_for_password_and_clicks_on_login_button(String username, String password) {
        orangeHRMHomePage.uname.sendKeys(username);
        orangeHRMHomePage.pword.sendKeys(password);
        orangeHRMHomePage.loginButton.click();


    }

    @When("user clicks on MyTimesheet")
    public void user_clicks_on_MyTimesheet() {
        orangeHRMHomePage.MyTimesheetLink.get(5).click();

    }

    @When("user clicks on Add Timesheet button and chooses date {string}")
    public void userClicksOnAddTimesheetButtonAndChoosesDate(String tsDate) throws InterruptedException {
        orangeHRMHomePage.AddTsButton.click();
        orangeHRMHomePage.dateBox.clear();
        orangeHRMHomePage.dateBox.sendKeys(tsDate);
        orangeHRMHomePage.okButton.click();

    }

    @Then("user validates the timesheet message {string}")
    public void user_validates_the_timesheet_message(String string) {
        Assert.assertEquals(string, orangeHRMHomePage.tsExistsMsg.getText());
    }

    @When("user clicks on dropdown menu and selects {string}")
    public void userClicksOnDropdownMenuAndSelects(String tsPeriod) {
        BrowserUtils.selectByText(orangeHRMHomePage.selectTsMenu, tsPeriod);;

    }
    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        orangeHRMHomePage.editButton.click();


    }
    @When("user chooses project name as {string} and activity name as {string}")
    public void user_chooses_project_name_as_and_activity_name_as(String projectName, String activityName)  {
       orangeHRMHomePage.project.clear();
        orangeHRMHomePage.project.sendKeys("Internal");
        orangeHRMHomePage.project.sendKeys(Keys.ENTER);
        orangeHRMHomePage.activity.click();
        BrowserUtils.selectByText(orangeHRMHomePage.activity,activityName);


    }
    @When("user enters hours on each day using data")
    public void user_enters_hours_on_each_day_using_data(DataTable dataTable) {
        List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);
        orangeHRMHomePage.mondayBox.clear();
        orangeHRMHomePage.mondayBox.sendKeys(data.get(0).get("Mon 10").toString());
        orangeHRMHomePage.tuesdayBox.clear();
        orangeHRMHomePage.tuesdayBox.sendKeys(data.get(0).get("Tue 11").toString());
        orangeHRMHomePage.wednesdayBox.clear();
        orangeHRMHomePage.wednesdayBox.sendKeys(data.get(0).get("Wed 12").toString());
        orangeHRMHomePage.thursdayBox.clear();
        orangeHRMHomePage.thursdayBox.sendKeys(data.get(0).get("Thu 13").toString());
        orangeHRMHomePage.fridayBox.clear();
        orangeHRMHomePage.fridayBox.sendKeys(data.get(0).get("Fri 14").toString());


    }
    @When("user clicks on save button and submits timesheet")
    public void user_clicks_on_save_button_and_submits_timesheet() {
        orangeHRMHomePage.ssaveButton.click();


    }
    @Then("user validates submitted timesheet status by message {string}")
    public void user_validates_submitted_timesheet_status_by_message(String string) {
        String actual=orangeHRMHomePage.tsSubmittedStatus.getText();
        System.out.println(actual);
        Assert.assertEquals(string, orangeHRMHomePage.tsSubmittedStatus.getText());

    }



    }



