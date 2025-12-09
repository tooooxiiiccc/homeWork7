package utils;

public class FilterData {
    private final String city;
    private final String genre;
    private final String date;

    public FilterData(String city, String genre, String date) {
        this.city = city;
        this.genre = genre;
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public String getGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }
}