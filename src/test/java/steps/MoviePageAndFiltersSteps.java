package steps;

import io.qameta.allure.Step;
import pages.MoviesPageAndFilters;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoviePageAndFiltersSteps {
    @Step("Переходим на страницу со всеми фильмами и выбираем фильтры и проверяем, что фильтры отображаются")
    public void setFilters(String city, String genre, String date) {
        MoviesPageAndFilters moviesPageAndFilters = new MoviesPageAndFilters().navigateToAllMoviesPage();
        moviesPageAndFilters
            .filterCityLocation(city)
            .filterGenre(genre)
            .filterDateOfBirth(date);
        verifyFilters(city, genre, date);
    }

    @Step("Проверить выбранные фильтры")
    public void verifyFilters(String expectedCity, String expectedGenre, String expectedDateOfBirth) {
        MoviesPageAndFilters moviesPageAndFilters = new MoviesPageAndFilters();
        String actualCity = moviesPageAndFilters.getCityLocationText();
        String actualGenre = moviesPageAndFilters.getGenreLocationText();
        String actualDate = moviesPageAndFilters.getDateLocationText();

        assertThat(actualCity)
            .as(expectedCity)
            .isEqualTo(expectedCity);

        assertThat(actualGenre)
            .as(expectedGenre)
            .isEqualTo(expectedGenre);

        assertThat(actualDate)
            .as(expectedDateOfBirth)
            .isEqualTo(expectedDateOfBirth);
    }
}

