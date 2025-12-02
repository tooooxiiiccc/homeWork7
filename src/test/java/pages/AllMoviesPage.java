package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Timeouts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AllMoviesPage {
    private SelenideElement moviesFilterLocationSelect = $x("//button[.//span[@data-qa-id='movies_filter_location_select']]");
    private SelenideElement moviesFilterGenreSelect = $x("(//button[@role='combobox'])[2]");
    private SelenideElement moviesFilterDateAnounce = $x("(//button[@role='combobox'])[3]");
    private SelenideElement selectedLocationText = $x("//span[@data-qa-id='movies_filter_location_select']");
    private SelenideElement selectedGenreText = $x("(//button[@role='combobox'])[2]//span");
    private SelenideElement selectedDateText = $x("(//button[@role='combobox'])[3]//span");

    @Step("Перейти на страницу со всеми фильмами")
    public AllMoviesPage open() {
        $x("//a[contains(text(), 'Все фильмы')]").shouldBe(visible, Timeouts.DEFAULT).click();
        return this;
    }

    @Step("Выбрать город: {city}")
    public AllMoviesPage filterCityLocation(String city) {
        moviesFilterLocationSelect
            .shouldBe(visible, Timeouts.DEFAULT).click();
        $x("//div[@role='listbox']//span[contains(text(), '" + city + "')]")
            .shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Выбрать жанр: {genre}")
    public AllMoviesPage filterGenre(String genre) {
        moviesFilterGenreSelect
            .shouldBe(visible, Timeouts.DEFAULT).click();
        $x("//div[@role='listbox']//span[contains(text(), '" + genre + "')]")
            .shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Выбрать дату выхода: {createDate}")
    public AllMoviesPage filterDateOfBirth(String createDate) {
        moviesFilterDateAnounce
            .shouldBe(visible, Timeouts.DEFAULT).click();
        $x("//div[@role='listbox']//span[contains(text(), '" + createDate + "')]")
            .shouldBe(visible, Timeouts.DEFAULT).click();
        return this;
    }

    @Step("Выбрать фильм: {movieName}")
    public MoviePage selectMovie(String movieName) {
        $x("//h3[contains(text(), '" + movieName + "')]").shouldBe(visible, Timeouts.DEFAULT).click();
        return new MoviePage();
    }

    @Step("Получить текст выбранного города")
    public String getCityLocationText(){
        return selectedLocationText.getText();
    }

    @Step("Получить текст выбранного жанра")
    public String getGenreLocationText(){
        return selectedGenreText.getText();
    }

    @Step("Получить текст выбранной даты выхода")
    public String getDateLocationText(){
        return selectedDateText.getText();
    }
}
