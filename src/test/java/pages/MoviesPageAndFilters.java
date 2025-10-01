package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MoviesPageAndFilters {
    private SelenideElement moviesFilterLocationSelect = $x("//span[@data-qa-id='movies_filter_location_select']");
    private SelenideElement moviesFilterGenreSelect = $x("(//span[text()='Все']/parent::button)[2]");
    private SelenideElement moviesFilterCreateDateSelect = $x("(//span[text()='Все']/parent::button)[2]");

    public MoviesPageAndFilters filterCityLocation(String city) {
        moviesFilterLocationSelect.click();
        $x("//span[contains(text(), '" + city + "')]").click();
        return this;
    }

    public MoviesPageAndFilters filterGenre(String genre) {
        moviesFilterGenreSelect.click();
        $x("//span[contains(text(), '" + genre + "')]").click();
        return this;
    }

    public MoviesPageAndFilters filterDateOfBirth(String createDate) {
        moviesFilterCreateDateSelect.click();
        $x("//span[contains(text(), '" + createDate + "')]").click();
        return this;
    }

//    public boolean isUrlContainsFilters(String city, String genre, String createDate) {
//        String currentUrl = WebDriverRunner.url();
//        return currentUrl.contains("location=")
//
//    }

    public MoviesPageAndFilters navigateToAllMoviesPage() {
        $x("//a[contains(text(), 'Все фильмы')]").click();
        return this;
    }

    public MoviePageAndReviewTicket selectMovie(String movieName) {
        $x("//h3[contains(text(), '" + movieName + "')]").click();
        Selenide.sleep(2000);
        return new MoviePageAndReviewTicket();
    }
}
