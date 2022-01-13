package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyHomePage {
    public EtsyHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="global-enhancements-search-query")
    public WebElement searchBar;

    @FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement allFiltersButton;

    @FindBy(xpath = "//label[@for='price-input-4']")
    public WebElement itemPriceButton;

    @FindBy(xpath="//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")
    public WebElement applyButton;

    @FindBy(xpath="//span[@class='wt-icon wt-nudge-b-1']")
    public WebElement searchButton;

    @FindBy(xpath="//span[@class='currency-value']")
    public List<WebElement> itemPricesOver1000;

    @FindBy(xpath="//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//div//h3")
    public List<WebElement> itemNames;

    @FindBy(id="catnav-primary-link-10855")
    public WebElement accessoriesLink;

    @FindBy(xpath="//span[@class='wt-display-table-cell wt-text-left-xs']")
    public WebElement endOfYearSpecialsLink;

    @FindBy(xpath="//span[@id='catnav-primary-link-10923']")
    public WebElement clothingLink;

    @FindBy(id="catnav-primary-link-891")
    public WebElement homeAndLivingLink;

    @FindBy(id="catnav-primary-link-10983")
    public  WebElement weddingAndPartLink;

    @FindBy(id="catnav-primary-link-11049")
    public WebElement toysLink;

    @FindBy(id="catnav-primary-link-66")
    public WebElement artCollectionsLink;

    @FindBy(id="catnav-primary-link-562")
    public WebElement craftSuppliesLink;

    @FindBy(id="catnav-primary-link--10")
    public WebElement giftsLink;


}
