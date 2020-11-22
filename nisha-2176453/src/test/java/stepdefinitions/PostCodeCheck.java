package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;

public class PostCodeCheck {

    private final String url = "http://api.postcodes.io/postcodes/";
    private Integer responseCode;

    @When("^I send a get request to url with post code \"([^\"]*)\"$")
    public void i_send_a_get_request_to_url_with_post_code(String postcode) {
        responseCode =
                RestAssured.get(url + postcode).getStatusCode();

        System.out.println(responseCode);
    }


    @Then("^I get a \"([^\"]*)\" response$")
    public void i_get_a_response(Integer response) {

        Assert.assertEquals(response, responseCode);

    }

}
