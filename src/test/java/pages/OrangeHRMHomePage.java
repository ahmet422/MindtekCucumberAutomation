package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrangeHRMHomePage {
    public OrangeHRMHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="txtUsername")
    public WebElement uname;

    @FindBy(id="txtPassword")
    public WebElement pword;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy(xpath="//span[@class=\"quickLinkText\"]")
    public List<WebElement> MyTimesheetLink;

    @FindBy(id="btnAddTimesheet")
    public WebElement AddTsButton;

    @FindBy(xpath="//img[@class='ui-datepicker-trigger']")
    public WebElement calendarButton;

    @FindBy(id="time_date")
    public WebElement dateBox;

    @FindBy(id="addTimesheetBtn")
    public WebElement okButton;

    @FindBy(id="msgDiv")
    public WebElement tsExistsMsg;

    @FindBy(id="startDates")
    public WebElement selectTsMenu;

    @FindBy(id="btnEdit")
    public WebElement editButton;

    @FindBy(id="initialRows_0_projectName")
    public WebElement project;

    @FindBy(id="initialRows_0_projectActivityName")
    public WebElement activity;

    @FindBy(id="initialRows_0_0")
    public WebElement mondayBox;

    @FindBy(id="initialRows_0_1")
    public WebElement tuesdayBox;

    @FindBy(id="initialRows_0_2")
    public WebElement wednesdayBox;

    @FindBy(id="initialRows_0_3")
    public WebElement thursdayBox;

    @FindBy(id="initialRows_0_4")
    public WebElement fridayBox;

    @FindBy(id="submitSave")
    public WebElement ssaveButton;

    @FindBy(id="btnSubmit")
    public WebElement submitTsButton;

    @FindBy(id="timesheet_status")
    public WebElement tsSubmittedStatus;


}
