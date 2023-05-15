package weatherstack.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import weatherstack.ScenarioContext;
import weatherstack.api.Error;
import weatherstack.config.TestConfig;
import weatherstack.impl.WeatherstackServiceImpl;
import weatherstack.service.WeatherstackService;

import java.util.*;

public class RestCallSteps {
    private ScenarioContext scenario;
    private TestConfig config = new TestConfig();
    private WeatherstackService weatherstackService = new WeatherstackServiceImpl();

    @Given("^user calls weatherStack service via (HTTP|HTTPS) for (\\w+) city$")
    public void user_calls_weatherStack_service_for_city(String requestType, String cityName) {
        String url = "";
        if (requestType.equals("HTTP")) {
            url = config.getWEATHER_STACK_BASIC_URL_HTTP_CURRENT() + config.getAPI_ACCESS_KEY() + config.getQUERY() + cityName;
        } else if (requestType.equals("HTTPS")) {
            url = config.getWEATHER_STACK_BASIC_URL_HTTPS_CURRENT() + config.getAPI_ACCESS_KEY() + config.getQUERY() + cityName;
        }

        ValidatableResponse response = weatherstackService.getResponseForRequest(url);

        scenario = new ScenarioContext(response);
    }

    @Given("^user calls weatherStack service via HTTP with no (access key|query)$")
    public void user_calls_incorrect_weatherStack_service_for_city(String absentParam) {
        String url = "";

        switch (absentParam) {
            case ("access key"):
                url = config.getWEATHER_STACK_BASIC_URL_HTTP_CURRENT() + config.getQUERY();
                break;
            case ("query"):
                url = config.getWEATHER_STACK_BASIC_URL_HTTP_CURRENT() + config.getAPI_ACCESS_KEY();
                break;
        }

        ValidatableResponse response = weatherstackService.getResponseForRequest(url);
        scenario = new ScenarioContext(response);
    }

    @Then("^response status code is (\\d+)")
    public void response_status_is_success_with_status_code(int statusCode) {
        scenario.getResponse().statusCode(statusCode);
    }

    @Then("^request fails with error code (\\d+)")
    public void request_fails_with_error_code(int errorCode) {
        boolean isSuccess = scenario.getResponse().extract().jsonPath().get("success");
        Assert.assertFalse("Operation parameter success = true while false expected", isSuccess);
        ObjectMapper mapper = new ObjectMapper();
        Error error = mapper.convertValue(scenario.getResponse().extract().jsonPath().get("error"), Error.class);
        Assert.assertEquals("Incorrect error code", errorCode, error.getCode().intValue());
    }

    @Then("^error message is (\\w.*)")
    public void error_message_is(String errorMessage) {
        Error error = scenario.getResponse().extract().jsonPath().getObject("error", Error.class);
        Assert.assertEquals(errorMessage, error.getInfo());
    }

    @Then("^(location|current weather) data is:$")
    public void response_data_is(String str, Map<String, String> expectedResult) {
        Map<String, String> actualResult = new HashMap<>();
        if (str.equals("location")) {
            actualResult = scenario.getResponse().extract().jsonPath().getMap("location", String.class, String.class);
        } else if (str.equals("current weather")) {
            actualResult = scenario.getResponse().extract().jsonPath().getMap("current", String.class, String.class);
        }

        Set<String> errors = new TreeSet<>();
        if (actualResult != null) {
            for (Map.Entry<String, String> expectedEntry : expectedResult.entrySet()) {
                if (!actualResult.containsKey(expectedEntry.getKey())) {
                    errors.add(String.format("Field \"%s\" is expected but is absent in actual response", expectedEntry.getKey()));
                    continue;
                }
                String actualValue = actualResult.get(expectedEntry.getKey());
                if (!actualValue.equals(expectedEntry.getValue())) {
                    errors.add(String.format("\n%s\n - expected: %s, actual: %s", expectedEntry.getKey(), expectedEntry.getValue(), actualValue));
                }
            }
        } else {
            errors.add(str + " data is empty");
        }

        if (errors.size() > 0) {
            Assert.fail("Difference in next parameters:" + String.join("\n", errors));
        }
    }

}
