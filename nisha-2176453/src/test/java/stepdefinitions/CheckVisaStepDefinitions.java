package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckVisaStepDefinitions {

    @Managed
    WebDriver driver;

   private final String url = "https://www.gov.uk/check-uk-visa/y";

    private String result;

    @Given("^I provide a nationality of \"([^\"]*)\"$")
    public void i_provide_a_nationality_of(String nationality) {
        driver.navigate().to(url);
        Select se = new Select(driver.findElement(By.xpath("//*[@id='response']")));
        se.selectByValue(nationality);
        driver.findElement(By.xpath("//*[@id=\"current-question\"]/button")).click();

    }


    @Given("^I select the reason \"([^\"]*)\"$")
    public void i_select_the_reason(String reason) {
        if (reason.equals("Study")) {
            driver.findElement(By.id("response-2")).click();
        } else if (reason.equals("Tourism")) {
            driver.findElement(By.id("response-0")).click();
        }
        driver.findElement(By.xpath("//*[@id=\"current-question\"]/button")).click();

    }

    @Given("^I state I am not travelling or visiting a partner or family \"([^\"]*)\"$")
    public void i_state_I_am_not_travelling_or_visiting_a_partner_or_family(String option) {
        if (option.equals("yes")) {
            driver.findElement(By.id("response-0")).click();
        } else if (option.equals("no")) {
            driver.findElement(By.id("response-1")).click();

        }
        driver.findElement(By.xpath("//*[@id=\"current-question\"]/button")).click();
    }

    @Given("^I state I am intending to stay for more than \"([^\"]*)\" months$")
    public void i_state_I_am_intending_to_stay_for_more_than_months(String months)  {

        if (Integer.parseInt(months) <= 6) {
            System.out.println("Inside months");
            driver.findElement(By.id("response-0")).click();
        } else {
            driver.findElement(By.id("response-1")).click();
        }
        driver.findElement(By.xpath("//*[@id=\"current-question\"]/button")).click();

    }

    @When("^I submit the form$")
    public void i_submit_the_form() {
        result = driver.findElement(By.xpath("//*[@id=\"result-info\"]/div[2]/h2")).getText();
    }

    @Then("^I will be informed \"([^\"]*)\"$")
    public void i_will_be_informed(String expectedResult) {
        Assert.assertEquals(expectedResult, result);
    }
}
