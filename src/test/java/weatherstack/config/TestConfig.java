package weatherstack.config;

public class TestConfig {
    private final String WEATHER_STACK_BASIC_URL_HTTP_CURRENT = "http://api.weatherstack.com/current";
    private final String WEATHER_STACK_BASIC_URL_HTTPS_CURRENT = "https://api.weatherstack.com/current";
    private String ACCOUNT_KEY = "516722aefc9cb753a75cf2b0604516f9";
    private final String API_ACCESS_KEY = "?access_key=" + ACCOUNT_KEY;
    private final String QUERY = "&query=";

    private final String HTTP_QUERY_FOR_CITY_WEATHER = WEATHER_STACK_BASIC_URL_HTTP_CURRENT + API_ACCESS_KEY + QUERY;
    private final String HTTPS_QUERY_FOR_CITY_WEATHER = WEATHER_STACK_BASIC_URL_HTTPS_CURRENT + API_ACCESS_KEY + QUERY;

    public String getHTTP_QUERY_FOR_CITY_WEATHER() {
        return HTTP_QUERY_FOR_CITY_WEATHER;
    }

    public String getHTTPS_QUERY_FOR_CITY_WEATHER() {
        return HTTPS_QUERY_FOR_CITY_WEATHER;
    }

    public String getWEATHER_STACK_BASIC_URL_HTTP_CURRENT() {
        return WEATHER_STACK_BASIC_URL_HTTP_CURRENT;
    }
    public String getWEATHER_STACK_BASIC_URL_HTTPS_CURRENT() {
        return WEATHER_STACK_BASIC_URL_HTTPS_CURRENT;
    }

    public String getAPI_ACCESS_KEY() {
        return API_ACCESS_KEY;
    }

    public String getQUERY() {
        return QUERY;
    }

    public void setACCOUNT_KEY(String ACCOUNT_KEY) {
        this.ACCOUNT_KEY = ACCOUNT_KEY;
    }
}
