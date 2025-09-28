package pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;

public class MoviesPage {
    public MoviesPage navigateToAllMoviesPage() {
        $x("//a[contains(text(), 'Все фильмы')]").click();
        return this;
    }

    public MoviePage selectMovie(String movieName) {
        $x("//h3[contains(text(), '" + movieName + "')]").click();
        Selenide.sleep(2000);
        return new MoviePage();
    }
}
