package edu.epam.taskoop.entity;

public class Publisher {
    private String name;
    private PublishCountry country;
    private int year;

    public Publisher() {}

    public Publisher(String name, PublishCountry country, int year) {
        this.name = name;
        this.country = country;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublishCountry getCountry() {
        return country;
    }

    public void setCountry(PublishCountry country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        if (!name.equals(publisher.name)) return false;
        return country == publisher.country;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publisher{");
        sb.append("name='").append(name).append('\'');
        sb.append(", country=").append(country);
        sb.append('}');
        return sb.toString();
    }
}
