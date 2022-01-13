package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebOrdersOrderPage {
    public WebOrdersOrderPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//a[@href='Process.aspx']")
    public WebElement orderModule;

    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productSelection;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy( id="ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement perUnitPrice;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discountRate;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement totalBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement  dropDown;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement name;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaCheckBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDate;

    @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(tagName = "strong")
    public WebElement sucessMessage;

    @FindBy(xpath="//table[@id='ctl00_MainContent_orderGrid']//tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[2]")
    public WebElement firstNameInRow;

    @FindBy(xpath="//a[@href='Default.aspx']")
    public WebElement viewAllOrdersModule;



}
