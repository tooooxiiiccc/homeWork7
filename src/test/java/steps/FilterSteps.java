package steps;

import pages.MoviesPageAndFilters;

public class FilterSteps {
    private final MoviesPageAndFilters moviesPageAndFilters = new MoviesPageAndFilters();

    public MoviesPageAndFilters getMoviesPageAndFilters(String city, String genre, String dateofborn) {
        System.out.println("Выбираем фильтры по городу, жанру и новизне");
        new MoviesPageAndFilters()
            .filterCityLocation(city)
            .filterGenre(genre)
            .filterDateOfBirth(dateofborn);
    }
}
