
package weatherstack.api;

import java.util.List;
public class CurrentWeather {

    private Long cloudcover;
    private Long feelslike;
    private Long humidity;
    private String is_day;
    private String observation_time;
    private Double precip;
    private Long pressure;
    private Long temperature;
    private Long uv_index;
    private Long visibility;
    private Long weather_code;
    private List<String> weather_descriptions;
    private List<String> weather_icons;
    private Long wind_degree;
    private String wind_dir;
    private Long wind_speed;

    public Long getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(Long cloudcover) {
        this.cloudcover = cloudcover;
    }

    public Long getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Long feelslike) {
        this.feelslike = feelslike;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public String getis_day() {
        return is_day;
    }

    public void setis_day(String is_day) {
        this.is_day = is_day;
    }

    public String getobservation_time() {
        return observation_time;
    }

    public void setobservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public Double getPrecip() {
        return precip;
    }

    public void setPrecip(Double precip) {
        this.precip = precip;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Long getuv_index() {
        return uv_index;
    }

    public void setuv_index(Long uv_index) {
        this.uv_index = uv_index;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Long getweather_code() {
        return weather_code;
    }

    public void setweather_code(Long weather_code) {
        this.weather_code = weather_code;
    }

    public List<String> getweather_descriptions() {
        return weather_descriptions;
    }

    public void setweather_descriptions(List<String> weather_descriptions) {
        this.weather_descriptions = weather_descriptions;
    }

    public List<String> getweather_icons() {
        return weather_icons;
    }

    public void setweather_icons(List<String> weather_icons) {
        this.weather_icons = weather_icons;
    }

    public Long getwind_degree() {
        return wind_degree;
    }

    public void setwind_degree(Long wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getwind_dir() {
        return wind_dir;
    }

    public void setwind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Long getwind_speed() {
        return wind_speed;
    }

    public void setwind_speed(Long wind_speed) {
        this.wind_speed = wind_speed;
    }

}
