package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PorscheHomePage {
    public PorscheHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='m-14-model-price']")
    public List<WebElement> carPrices;

    @FindBy(xpath = "//span[@class=\"close-button\"]")
    public List<WebElement> disclaimer;

    @FindBy(xpath ="//div[@class='pBox']")
    public List<WebElement> basePrice;

    @FindBy(id="s_navigation_config_end_x_s_navigation_config_end_x_showSelection")
    public WebElement overviewButton;

    @FindBy(xpath="//div[@id='m982120']")
    public WebElement carModel;

    @FindBy(xpath="//span[@id='s_interieur_x_PP06']")
    public WebElement seatTypeSelection;

    @FindBy(xpath="//div[@class='cca-price']")
    public List<WebElement> equipmentPrice;
}
