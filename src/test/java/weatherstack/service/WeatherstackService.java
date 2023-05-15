package weatherstack.service;

import io.restassured.response.ValidatableResponse;

public interface WeatherstackService {
    ValidatableResponse getResponseForRequest(String url);
}
