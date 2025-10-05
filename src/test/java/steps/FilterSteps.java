package steps;

import io.qameta.allure.Step;
import pages.MoviesPageAndFilters;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FilterSteps {
    private final MoviesPageAndFilters moviesPageAndFilters = new MoviesPageAndFilters();

    @Step("Применяем фильтры: город '{city}', жанр '{genre}', дата '{date}', и проверяем отображение")
    public void applyFiltersAndVerify(String city, String genre, String date, String genreText, String cityText) {
        new MoviesPageAndFilters()
            .filterCityLocation(city)
            .filterGenre(genre)
            .filterDateOfBirth(date)
            .isFiltersDisplayed(genreText, cityText);
    }
}
