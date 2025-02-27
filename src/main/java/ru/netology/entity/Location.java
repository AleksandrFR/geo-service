package ru.netology.entity;

import java.util.Objects;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, street, builing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !o.getClass().equals(Location.class)) return false;
        Location location = (Location) o;
        return (this.city.equals(location.city)
                && this.country.equals(location.country)
                && this.street.equals(location.street)
                && this.builing == location.builing);
    }
}
