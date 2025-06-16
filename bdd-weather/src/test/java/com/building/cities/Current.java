package com.building.cities;

import java.util.Objects;

public class Current {
    private int last_updated_epoch;
    private String last_updated;
    private Double temp_c;
    private Double temp_f;
    private int is_day;
    private Double wind_mph;
    private Double wind_kph;
    private Integer wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private Double pressure_in;
    private Double precip_mm;
    private Double precip_in;
    private int humidity;
    private int cloud;
    private Double feelslike_c;
    private Double feelslike_f;
    private Double windchill_c;
    private Double windchill_f;
    private Double heatindex_c;
    private Double heatindex_f;
    private Double dewpoint_c;
    private Double dewpoint_f;
    private Double vis_km;
    private Double vis_miles;
    private Double uv;
    private Double gust_mph;
    private Double gust_kph;
    private Condition condition;

    public Current(int last_updated_epoch, String last_updated, Double temp_c, Double temp_f, int is_day, Double wind_mph, Double wind_kph,
                   Integer wind_degree, String wind_dir, Double pressure_mb, Double pressure_in, Double precip_mm, Double precip_in,
                   int humidity, int cloud, Double feelslike_c, Double feelslike_f, Double windchill_c, Double windchill_f,
                   Double heatindex_c, Double heatindex_f, Double dewpoint_c, Double dewpoint_f, Double vis_km, Double vis_miles,
                   Double uv, Double gust_mph, Double gust_kph, Condition condition) {
        this.last_updated_epoch = last_updated_epoch;
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.is_day = is_day;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure_mb = pressure_mb;
        this.pressure_in = pressure_in;
        this.precip_mm = precip_mm;
        this.precip_in = precip_in;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.windchill_c = windchill_c;
        this.windchill_f = windchill_f;
        this.heatindex_c = heatindex_c;
        this.heatindex_f = heatindex_f;
        this.dewpoint_c = dewpoint_c;
        this.dewpoint_f = dewpoint_f;
        this.vis_km = vis_km;
        this.vis_miles = vis_miles;
        this.uv = uv;
        this.gust_mph = gust_mph;
        this.gust_kph = gust_kph;
        this.condition = condition;
    }

    public int getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(int last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public Double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(Double temp_f) {
        this.temp_f = temp_f;
    }

    public int getIs_day() {
        return is_day;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }

    public Double getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(Double wind_mph) {
        this.wind_mph = wind_mph;
    }

    public Double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Integer getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(Integer wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public Double getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(Double pressure_in) {
        this.pressure_in = pressure_in;
    }

    public Double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public Double getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(Double precip_in) {
        this.precip_in = precip_in;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(byte humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(byte cloud) {
        this.cloud = cloud;
    }

    public Double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(Double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public Double getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(Double feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public Double getWindchill_c() {
        return windchill_c;
    }

    public void setWindchill_c(Double windchill_c) {
        this.windchill_c = windchill_c;
    }

    public Double getWindchill_f() {
        return windchill_f;
    }

    public void setWindchill_f(Double windchill_f) {
        this.windchill_f = windchill_f;
    }

    public Double getHeatindex_c() {
        return heatindex_c;
    }

    public void setHeatindex_c(Double heatindex_c) {
        this.heatindex_c = heatindex_c;
    }

    public Double getHeatindex_f() {
        return heatindex_f;
    }

    public void setHeatindex_f(Double heatindex_f) {
        this.heatindex_f = heatindex_f;
    }

    public Double getDewpoint_c() {
        return dewpoint_c;
    }

    public void setDewpoint_c(Double dewpoint_c) {
        this.dewpoint_c = dewpoint_c;
    }

    public Double getDewpoint_f() {
        return dewpoint_f;
    }

    public void setDewpoint_f(Double dewpoint_f) {
        this.dewpoint_f = dewpoint_f;
    }

    public Double getVis_km() {
        return vis_km;
    }

    public void setVis_km(Double vis_km) {
        this.vis_km = vis_km;
    }

    public Double getVis_miles() {
        return vis_miles;
    }

    public void setVis_miles(Double vis_miles) {
        this.vis_miles = vis_miles;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Double getGust_mph() {
        return gust_mph;
    }

    public void setGust_mph(Double gust_mph) {
        this.gust_mph = gust_mph;
    }

    public Double getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(Double gust_kph) {
        this.gust_kph = gust_kph;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Current)) return false;
        Current current = (Current) o;
        return getLast_updated_epoch() == current.getLast_updated_epoch() && getIs_day() == current.getIs_day()
                && getHumidity() == current.getHumidity() && getCloud() == current.getCloud()
                && getLast_updated().equals(current.getLast_updated()) && getTemp_c().equals(current.getTemp_c())
                && getTemp_f().equals(current.getTemp_f()) && getWind_mph().equals(current.getWind_mph())
                && getWind_kph().equals(current.getWind_kph()) && getWind_degree().equals(current.getWind_degree())
                && getWind_dir().equals(current.getWind_dir()) && getPressure_mb().equals(current.getPressure_mb())
                && getPressure_in().equals(current.getPressure_in()) && getPrecip_mm().equals(current.getPrecip_mm())
                && getPrecip_in().equals(current.getPrecip_in()) && getFeelslike_c().equals(current.getFeelslike_c())
                && getFeelslike_f().equals(current.getFeelslike_f()) && getWindchill_c().equals(current.getWindchill_c())
                && getWindchill_f().equals(current.getWindchill_f()) && getHeatindex_c().equals(current.getHeatindex_c())
                && getHeatindex_f().equals(current.getHeatindex_f()) && getDewpoint_c().equals(current.getDewpoint_c())
                && getDewpoint_f().equals(current.getDewpoint_f()) && getVis_km().equals(current.getVis_km())
                && getVis_miles().equals(current.getVis_miles()) && getUv().equals(current.getUv())
                && getGust_mph().equals(current.getGust_mph()) && getGust_kph().equals(current.getGust_kph())
                && getCondition().equals(current.getCondition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLast_updated_epoch(), getLast_updated(), getTemp_c(), getTemp_f(), getIs_day(), getWind_mph(), getWind_kph(), getWind_degree(), getWind_dir(), getPressure_mb(), getPressure_in(), getPrecip_mm(), getPrecip_in(), getHumidity(), getCloud(), getFeelslike_c(), getFeelslike_f(), getWindchill_c(), getWindchill_f(), getHeatindex_c(), getHeatindex_f(), getDewpoint_c(), getDewpoint_f(), getVis_km(), getVis_miles(), getUv(), getGust_mph(), getGust_kph(), getCondition());
    }
}
