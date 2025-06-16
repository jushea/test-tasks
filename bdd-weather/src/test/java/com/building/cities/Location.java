package com.building.cities;

import java.util.Objects;

public class Location {
    private String name;
    private String region;
    private String country;
    private float lat;
    private float lon;
    private String tz_id;
    private Integer localtime_epoch;
    private String localtime;

    public Location(String name, String region, String country, float lat, float lon, String tz_id, Integer localtime_epoch, String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tz_id = tz_id;
        this.localtime_epoch = localtime_epoch;
        this.localtime = localtime;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getTz_id() {
        return tz_id;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public Integer getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(Integer localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Float.compare(location.getLat(), getLat()) == 0 && Float.compare(location.getLon(), getLon()) == 0 && getName().equals(location.getName()) && getRegion().equals(location.getRegion()) && getCountry().equals(location.getCountry()) && getTz_id().equals(location.getTz_id()) && getLocaltime_epoch().equals(location.getLocaltime_epoch()) && getLocaltime().equals(location.getLocaltime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRegion(), getCountry(), getLat(), getLon(), getTz_id(), getLocaltime_epoch(), getLocaltime());
    }
}
