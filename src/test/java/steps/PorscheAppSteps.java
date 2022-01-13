package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PorscheHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Locale;

public class PorscheAppSteps {
    WebDriver driver = Driver.getDriver();
    PorscheHomePage porscheHomePage = new PorscheHomePage();

    @Given("user navigates to porsche application")
    public void user_navigates_to_porsche_application() {
        driver.get(ConfigReader.getProperty("PorscheSite"));
    }

    @When("user stores the price and selects the model {string}")
    public void userStoresThePriceAndSelectsTheModel(String carType) throws InterruptedException {
        porscheHomePage.carModel.click();
        Thread.sleep(3000);
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        porscheHomePage.disclaimer.get(1).click();
    }

    @Then("user validates {string} is matched with listed {string}")
    public void userValidatesIsMatchedWithListed(String expectedPrice, String actualPrice) {
        porscheHomePage.overviewButton.click();
          expectedPrice="$60,500";
       actualPrice=porscheHomePage.basePrice.get(187).getText();
        System.out.println(actualPrice);
        Assert.assertEquals(expectedPrice, actualPrice);
           }

    @And("user adds Power Sport Seats {int}-way with Memory Package")
    public void userAddsPowerSportSeatsWayWithMemoryPackage(int arg0) {
        BrowserUtils.waitElementToClickable(porscheHomePage.seatTypeSelection);
        porscheHomePage.seatTypeSelection.click();

    }

    @Then("user validates that Price For Equipment is added and price matches")
    public void userValidatesThatPriceForEquipmentIsAddedAndPriceMatches() {
        String act=porscheHomePage.basePrice.get(7).getText();
        Assert.assertEquals(act, "$2,330");
    }


    }







