package org.example;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;

public class cityBikesApi {

    @Before
    public void initialize() {
        RestAssured.baseURI = "http://api.citybik.es/v2/networks/";
    }

    @Then("I should be able to see that Frankfurt is in DE")
    public void i_should_be_able_to_see_that_frankfurt_is_in_de() {
        Response response = given()
                .basePath("visa-frankfurt")
                .and()
                .when()
                .get();
        Assert.assertEquals(response.jsonPath().getString("network.location.country"), "DE", "Frankfurt is not in Germany");
    }

    @Then("I should be able to see the correct longitude {double} and latitude {double}")
    public void i_should_be_able_to_see_the_correct_longitude_and_latitude(Double longitude, Double latitude) {
        Response response = given()
                .basePath("visa-frankfurt")
                .and()
                .when()
                .get();
        System.out.println("Longitude: " + Double.parseDouble(response.jsonPath().getString("network.location.longitude")));
        Assert.assertEquals(Double.parseDouble(response.jsonPath().getString("network.location.longitude")), longitude, "Longitude is incorrect");
        System.out.println("Latitude: " + Double.parseDouble(response.jsonPath().getString("network.location.latitude")));
        Assert.assertEquals(Double.parseDouble(response.jsonPath().getString("network.location.latitude")), latitude, "Latitude is incorrect");
    }
}
