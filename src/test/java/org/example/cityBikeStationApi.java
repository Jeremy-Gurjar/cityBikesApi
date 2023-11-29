package org.example;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class cityBikeStationApi {
    @Before
    public void initialize() {
        RestAssured.baseURI = "http://api.citybik.es/v2/networks/";
    }

    @Given("there is a bike station at River Street , Clerkenwell")
    public void there_is_a_bike_station_at_river_street_clerkenwell() {
        Response response = given()
                .basePath("santander-cycles")
                .and()
                .when()
                .get();
        System.out.println();
        Assert.assertTrue(response.jsonPath().getString("network.stations.extra.name").contains("River Street , Clerkenwell"));
    }

    @Then("I should be able to return the correct install date {long}")
    public void i_should_be_able_to_return_the_correct_install_date(Long installDate) {
        Response response = given()
                .basePath("santander-cycles")
                .and()
                .when()
                .get();
        long responseInstallDate = response.jsonPath().getLong("network.stations.extra.installDate[0]");
        Assert.assertEquals(responseInstallDate, installDate.longValue(), "Install date is not correct");
    }

    @Then("I should be able to return the correct number of empty slots {int}")
    public void i_should_be_able_to_return_the_correct_number_of_empty_slots(Integer emptySlots) {
        Response response = given()
                .basePath("santander-cycles")
                .and()
                .when()
                .get();
        Assert.assertEquals(Integer.parseInt(response.jsonPath().getString("network.stations.empty_slots[0]")), emptySlots, "Number of empty slots is incorrect");
    }
}
