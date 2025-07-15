package runner;

import configs.Constants;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utility.TestListener;

@Listeners(TestListener.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "hooks"},
        //tags = "@SmokeTest",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"})

public class FakeStoreAPITestRunner extends AbstractTestNGCucumberTests{
    //This runner configures the suite you would like to run
    //you cant add a Before annotation here
    @BeforeSuite
    public void setUp(){
        RestAssured.reset();

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Constants.baseURI)
                .setContentType("application/json")
                .build();

        System.out.println("finished beforeSuite");
    }

}
