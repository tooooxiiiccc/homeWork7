package steps;

import io.qameta.allure.Step;
import pages.AllMoviesPage;
import utils.FilterData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllMoviesPageSteps {
    private final AllMoviesPage allMoviesPage = new AllMoviesPage();

    @Step("Открыть страницу со всеми фильмами")
    public void openAllMoviesPage(){
        allMoviesPage.open();
    }

    @Step("Выбрать первый доступный фильм")
    public void pickFirstMovie(){
        allMoviesPage.selectFirstMovie();
    }

    @Step("Выбрать фильтры: город={city}, жанр={genre}, дата={date}")
    public void setFilters(FilterData filterData) {
        allMoviesPage
            .filterCityLocation(filterData.getCity())
            .filterGenre(filterData.getGenre())
            .filterDateOfBirth(filterData.getDate());
    }

    @Step("Проверить выбранные фильтры: город={expectedCity}, жанр={expectedGenre}, дата={expectedDate}")
    public void verifyFilters(FilterData expectedFilters) {
        String actualCity = allMoviesPage.getCityLocationText();
        String actualGenre = allMoviesPage.getGenreLocationText();
        String actualDate = allMoviesPage.getDateLocationText();

        assertThat(actualCity)
            .as("Ожидался город: %s, но получен: %s", expectedFilters.getCity(), actualCity)
            .isEqualTo(expectedFilters.getCity());

        assertThat(actualGenre)
            .as("Ожидался жанр: %s, но получен: %s", expectedFilters.getGenre(), actualGenre)
            .isEqualTo(expectedFilters.getGenre());

        assertThat(actualDate)
            .as("Ожидалась дата: %s, но получена: %s", expectedFilters.getDate(), actualDate)
            .isEqualTo(expectedFilters.getDate());
    }
}

