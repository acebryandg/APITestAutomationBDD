package stepDefinitions;

import dto.TestContext;
import io.cucumber.java.en.Then;

import static junit.framework.Assert.assertEquals;

public class CommonStepDefinitions {
    private final TestContext testContext;

    public CommonStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("I receive a response code as {int}")
    public void i_receive_a_response_code_as(int expectedResponseCode) {
        int actualResponseCode = testContext.getResponse().getStatusCode();
        assertEquals(expectedResponseCode, actualResponseCode);
    }
}
