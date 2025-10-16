package steps;

import io.qameta.allure.Step;
import pages.AllMoviesPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllMoviesPageSteps {
    private final AllMoviesPage allMoviesPage = new AllMoviesPage();

    @Step("Выбираем фильтры и проверяем")
    public void setFilters(String city, String genre, String date) {
        allMoviesPage
            .filterCityLocation(city)
            .filterGenre(genre)
            .filterDateOfBirth(date);
    }

    @Step("Проверить выбранные фильтры")
    public void verifyFilters(String expectedCity, String expectedGenre, String expectedDateOfBirth) {
        String actualCity = allMoviesPage.getCityLocationText();
        String actualGenre = allMoviesPage.getGenreLocationText();
        String actualDate = allMoviesPage.getDateLocationText();

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

