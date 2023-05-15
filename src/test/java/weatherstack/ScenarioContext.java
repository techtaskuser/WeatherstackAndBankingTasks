package weatherstack;

import io.restassured.response.ValidatableResponse;

public class ScenarioContext {
    private ValidatableResponse response;

    public ScenarioContext(ValidatableResponse response) {
        this.response = response;
    }

    public ValidatableResponse getResponse() {
        return response;
    }

}
