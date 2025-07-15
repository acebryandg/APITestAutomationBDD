package hooks;

import configs.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario){
        scenario.log("Running Scenario: " + scenario.getName());
    }


    @After
    public void afterTest(Scenario scenario){
        scenario.log("Scenario: " + scenario.getName() + "; Status: " + scenario.getStatus());
    }
}
