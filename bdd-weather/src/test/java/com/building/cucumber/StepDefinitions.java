package com.building.cucumber;

import com.building.cities.City;
import com.building.cities.Condition;
import com.building.cities.Current;
import com.building.cities.Location;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.HttpHeader;
import com.github.tomakehurst.wiremock.http.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    WireMockServer wireMockServer;
    HttpResponse<String> response = null;
    private static final String KEYINCORRECT = "421a6ef068304e708ab174041250907";
    private static final String KEYCORRECT = "421a6ef068304e708ab174041250906";

    private static final Logger LOG = LogManager.getLogger(StepDefinitions.class);
    @Before
    public void beforeScenario() {
        wireMockServer = new WireMockServer(8082);
        wireMockServer.start();
        WireMock.configureFor("localhost", 8082);
    }

    @After
    public void afterScenario() {
        wireMockServer.stop();
    }

    @Given("Prepare stub for API for {string}")
    public void prepare_stub_for_api_for(String city) {
        // Setup the WireMock mapping stub for the test
        HttpHeaders headers = new com.github.tomakehurst.wiremock.http.HttpHeaders(
                new HttpHeader("Transfer-Encoding", "chunked"),
                new HttpHeader("Connection", "keep-alive"),
                new HttpHeader("Vary", "Accept-Encoding"),
                new HttpHeader("CDN-PullZone", "93447"),
                new HttpHeader("CDN-Uid", "8fa3a04a-75d9-4707-8056-b7b33c8ac7fe"),
                new HttpHeader("CDN-RequestCountryCode", "GB"),
                new HttpHeader("x-weatherapi-qpm-left", "4999994"),
                new HttpHeader("CDN-ProxyVer", "1.28"),
                new HttpHeader("CDN-RequestPullSuccess", "True"),
                new HttpHeader("CDN-RequestPullCode", "200"),
                new HttpHeader("CDN-CachedAt", "06/10/2025 13:30:48"),
                new HttpHeader("CDN-EdgeStorageId", "722"),
                new HttpHeader("CDN-RequestId", "f9e920de73725a8b52ba2dc79dd692a8"),
                new HttpHeader("CDN-Cache", "MISS"),
                new HttpHeader("CDN-Status", "200"),
                new HttpHeader("CDN-RequestTime", "0"),
                new HttpHeader("Cache-Control", "public, max-age=180"),
                new HttpHeader("Content-Type", "application/json"),
                new HttpHeader("Date", "Tue, 10 Jun 2025 13:30:48 GMT"),
                new HttpHeader("Server", "BunnyCDN-DE1-1075")
        );

        WireMock.stubFor(WireMock.get("/current.json?key=421a6ef068304e708ab174041250906&q=" + city + "&aqi=no")
                .withHeader("Content-Type", WireMock.containing("application/json"))
                .willReturn(WireMock.aResponse().withStatus(200)
                        .withHeaders(headers)
                        .withBodyFile(city + ".json")));
    }

    @When("I get current weather for a city {string}")
    public void i_get_current_weather_for_a_city(String city) {
        // Setup HTTP POST request (with HTTP Client embedded in Java 11+)
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.url("/current.json?key=421a6ef068304e708ab174041250906&q="+ city + "&aqi=no")))
                .header("Content-Type", "application/json")
                .build();

        // Send the request and receive the response
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Parsed result and save in Log for {string}")
    public void parsed_result_and_save_in_log_for(String city) {
        // Verify the response
        assertThat(response.statusCode()).isEqualTo(200);
        City cityjson = new Gson().fromJson(response.body(), City.class);
        City expectedcity = expectedCity(city);
        try {
            assertThat(cityjson).usingRecursiveComparison().isEqualTo(expectedcity);
        } catch(AssertionError e) {
            LOG.error("The objects differ: ", e);
        }
    }

    private City expectedCity(String city) {
        Map<String, String> mapCity = new HashMap<>();
        mapCity.put("Paris", "Ile-de-France");
        mapCity.put("Amsterdam", "North Holland");
        mapCity.put("Belgrade", "Central Serbia");
        mapCity.put("London", "City of London, Greater London");

        Location location = new Location(city, mapCity.get(city), "USA", 0, 0, null, null, null);
        Condition condition = new Condition(null, null, 0);
        Current current = new Current(0, null, 0.0, 0.0, 1, 0.0, 0.0,
                0, null, 0.0, 0.0, 0.0, 0.0,
                88, 18,0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, condition);
        City expected =  new City(location, current);
        expected.setLocation(location);
        expected.setCurrent(current);
        return expected;
    }

    @Given("Prepare stub for incorrect API with status {int} and message {string} with code {int} for {string}")
    public void prepare_stub_for_incorrect_api_with_status_and_message_with_code_for(Integer status, String message, Integer code, String city) {
        HttpHeaders headers = new com.github.tomakehurst.wiremock.http.HttpHeaders(
                new HttpHeader("Transfer-Encoding", "chunked"),
                new HttpHeader("Connection", "keep-alive"),
                new HttpHeader("x-weatherapi-qpm-left", "4999994"),
                new HttpHeader("Cache-Control", "no-cache"),
                new HttpHeader("Content-Type", "application/json"),
                new HttpHeader("Date", "Tue, 10 Jun 2025 13:30:48 GMT")
        );

        String URL = (status == 401 ? "/current.json?key=" + KEYINCORRECT + "&q=" + city + "&aqi=no" : "/current.json?key=" + KEYCORRECT + "&q=" + city + "&aqi=no");
        WireMock.stubFor(WireMock.get(URL)
                .withHeader("Content-Type", WireMock.containing("application/json"))
                .willReturn(WireMock.aResponse().withStatus(status)
                        .withHeaders(headers)
                        .withBody("{\"error\": {\"code\": " + code + ",\"message\": \"" + message + "\"}}")));
    }

    @When("Send incorrect request for {string} and get a response with {int}")
    public void send_incorrect_request_for_and_get_a_response_with(String city, Integer status) {
        String URL = (status == 401 ? "/current.json?key=" + KEYINCORRECT + "&q=" + city + "&aqi=no" : "/current.json?key=" + KEYCORRECT + "&q=" + city + "&aqi=no");

        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.url(URL)))
                .header("Content-Type", "application/json")
                .build();

        // Send the request and receive the response
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Check {int}, {int} and {string}")
    public void check_and(Integer status, Integer errorCode, String errorMessage) {
        Assertions.assertEquals(status, response.statusCode(), "Wrong response status code");
        JsonObject body = new Gson().fromJson(response.body(), JsonObject.class);
        Assertions.assertTrue(body.has("error"), "Wrong response body");
        Assertions.assertEquals(errorCode, body.getAsJsonObject("error").getAsJsonObject().get("code").getAsInt(), "Wrong response body");
        Assertions.assertEquals(errorMessage, body.getAsJsonObject("error").getAsJsonObject().get("message").getAsString(), "Wrong response body");
    }
}
