package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static junit.framework.Assert.assertEquals;

public class Products {

    public String baseURI = "https://fakestoreapi.com";
    public RequestSpecification requestSpec;
    public Response response;
    public int responseCode;

    @Given("I hit the url of get products api endpoint")
    public void I_hit_the_url_of_get_products_api_endpoint(){
        RestAssured.baseURI = baseURI;
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        requestSpec = RestAssured.given();
        response = requestSpec.get("products");
    }

    @Then("I receive a response code as {int}")
    public void i_receive_a_response_code_as(Integer int1) {
        responseCode = response.getStatusCode();
        assertEquals(200, responseCode);
    }


}
