package stepDefinitions;


import configs.Constants;
import dto.AddProductRequest;
import dto.TestContext;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static junit.framework.Assert.assertEquals;

public class Products {


    public Response response;
    public TestContext testContext;

    public Products(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I hit the url of get products api endpoint")
    public void I_hit_the_url_of_get_products_api_endpoint(){
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        response = RestAssured
                .given().log().all()
                .when().get("/products");

        response.then().log().all();
        testContext.setResponse(response);
    }

    @When("I create a new product with {string}, {double}, {string}, {string}, {string}")
    public void iCreateANewProductWith(String title, Double price, String description, String category, String image) {
        //Create the pojo
        AddProductRequest requestBody = new AddProductRequest(12345, title, price, description, category, image);

        //send the request
        response = RestAssured
                .given().body(requestBody).log().all()
                .when().post("/products");

        response.then().log().all();
        testContext.setResponse(response);
    }

    @Then("that the count of the {int} is {int}")
    public void iVerifyThatTheCountOfTheFirstProductIs(int productNumber, int productCount) {
        JsonPath jsonPath = response.jsonPath();
        int index = productNumber - 1;
        int target = jsonPath.getJsonObject("rating[" + index + "].count");
        assertEquals(productCount, target);
    }

    @Then("I verify that the title of {int} is {string}")
    public void iVerifyThatTheTitleOfIs(int productNumber, String title) {
        JsonPath jsonPath = response.jsonPath();
        int index = productNumber - 1;
        String target  = jsonPath.get("title[" + index + "]");
        assertEquals(title, target);
    }
}
