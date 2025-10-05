package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MoviesPageAndFilters {
    private SelenideElement moviesFilterLocationSelect = $x("//button[.//span[@data-qa-id='movies_filter_location_select']]");
    private SelenideElement moviesFilterGenreSelect = $x("(//button[@role='combobox'])[2]");
    private SelenideElement moviesFilterDateAnounce = $x("(//button[@role='combobox'])[3]");

    @Step("Переходим на странице со всеми фильмами")
    public MoviesPageAndFilters navigateToAllMoviesPage() {
        $x("//a[contains(text(), 'Все фильмы')]").shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Выбираем город: ")
    public MoviesPageAndFilters filterCityLocation(String city) {
        moviesFilterLocationSelect
            .shouldBe(visible, Duration.ofSeconds(10)).click();
        $x("//div[@role='listbox']//span[contains(text(), '" + city + "')]")
            .shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Выбираем фильтр: ")
    public MoviesPageAndFilters filterGenre(String genre) {
        moviesFilterGenreSelect
            .shouldBe(visible, Duration.ofSeconds(5)).click();
        $x("//div[@role='listbox']//span[contains(text(), '" + genre + "')]")
            .shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Выбираем дату выхода: ")
    public MoviesPageAndFilters filterDateOfBirth(String createDate) {
        moviesFilterDateAnounce
            .shouldBe(visible, Duration.ofSeconds(5)).click();
        $x("//div[@role='listbox']//span[contains(text(), '" + createDate + "')]")
            .shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Выбираем фильм: ")
    public MoviePageAndReviewTicket selectMovie(String movieName) {
        $x("//h3[contains(text(), '" + movieName + "')]").shouldBe(visible, Duration.ofSeconds(5)).click();
        return new MoviePageAndReviewTicket();
    }

    @Step("Проверяем отображение выбранных фильтров на странице: жанр '{genreText}', город '{cityText}'")
    public MoviesPageAndFilters isFiltersDisplayed(String genreText, String cityText) {
            moviesFilterGenreSelect.shouldHave(text(genreText));
            moviesFilterLocationSelect.shouldHave(text(cityText));
         return this;
    }
}
