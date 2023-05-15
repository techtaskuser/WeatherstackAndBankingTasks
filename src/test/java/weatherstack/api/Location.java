
package weatherstack.api;

public class Location {

    private String country;
    private String lat;
    private String localtime;
    private Long localtime_epoch;
    private String lon;
    private String name;
    private String region;
    private String timezone_id;
    private String utc_offset;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public Long getlocaltime_epoch() {
        return localtime_epoch;
    }

    public void setlocaltime_epoch(Long localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String gettimezone_id() {
        return timezone_id;
    }

    public void settimezone_id(String timezone_id) {
        this.timezone_id = timezone_id;
    }

    public String getutc_offset() {
        return utc_offset;
    }

    public void setutc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

}
