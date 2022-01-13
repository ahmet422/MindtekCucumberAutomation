package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestSheepAppPage {
    public TestSheepAppPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="number1Field")
    public WebElement firstNumber;

    @FindBy(id="number2Field")
    public WebElement secondNumber;

    @FindBy(id="selectOperationDropdown")
    public WebElement dropdownMenu;

    @FindBy(id="calculateButton")
    public WebElement calculateButton;

    @FindBy(id="numberAnswerField")
    public WebElement totalNumber;

    @FindBy(id="errorMsgField")
    public WebElement errorMsg;
}
