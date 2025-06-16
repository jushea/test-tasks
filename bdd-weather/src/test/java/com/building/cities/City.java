package com.building.cities;

import java.util.Objects;

public class City {
    private Location location;
    private Current current;

    public City(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getLocation().equals(city.getLocation()) && getCurrent().equals(city.getCurrent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), getCurrent());
    }
}