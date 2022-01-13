package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Locale;

public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();

    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("user navigates to Etsy application")
    public void user_navigates_to_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));


    }


    @When("user searches for {string}")
    public void user_searches_for(String item) {
        etsyHomePage.searchBar.sendKeys(item);
        etsyHomePage.searchButton.click();

    }

    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer int1) {
        etsyHomePage.allFiltersButton.click();
        etsyHomePage.itemPriceButton.click();
        etsyHomePage.applyButton.click();

    }

    @Then("user validates that item prices are over {int}")
    public void user_validates_that_item_prices_are_over(Integer price) throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement e : etsyHomePage.itemPricesOver1000
        ) {
            System.out.println(e.getText());
            String intPrices = e.getText().replace(",", "");
            System.out.println(intPrices);

            double doublePrice = Double.parseDouble(intPrices);
            Assert.assertTrue(doublePrice >= price);

        }


    }

    @Then("user validates search result items contain keyword {string}")
    public void user_searches_for_and(String item) throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement element : etsyHomePage.itemNames){
            System.out.println(element.getText());
            Assert.assertTrue(element.getText().toLowerCase().contains(item) || element.getText().toLowerCase().contains("rug"));
        }


    }


    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {

        if(section.equalsIgnoreCase("End of Year Sales Event")){
            etsyHomePage.endOfYearSpecialsLink.click();
        }else if(section.equalsIgnoreCase("Jewelry & Accessories")){
            etsyHomePage.accessoriesLink.click();
        }else if(section.equalsIgnoreCase("Clothing and Shoes")){
            etsyHomePage.clothingLink.click();
        }else if(section.equalsIgnoreCase("Wedding and Party")){
            etsyHomePage.weddingAndPartLink.click();
        }else if(section.equalsIgnoreCase("Toys and Entertainment")){
            etsyHomePage.toysLink.click();
        }else if(section.equalsIgnoreCase("Art and Collectibles")){
            etsyHomePage.artCollectionsLink.click();
        }else if(section.equalsIgnoreCase("Craft Supplies & Tools")){
            etsyHomePage.craftSuppliesLink.click();
        }else if(section.equalsIgnoreCase("Gifts and GiftCards")){
            etsyHomePage.giftsLink.click();
        }
        
    }

    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}


