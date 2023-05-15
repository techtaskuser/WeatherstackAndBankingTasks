package weatherstack.impl;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import weatherstack.service.WeatherstackService;

public class WeatherstackServiceImpl implements WeatherstackService {
    @Override
    public ValidatableResponse getResponseForRequest(String url) {
        return RestAssured.given().get(url).then().log().ifError();
    }

}
