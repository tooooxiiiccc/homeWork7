package steps;

import io.qameta.allure.Step;
import pages.MoviePage;
import pages.AllMoviesPage;

public class MoviePageSteps {
    private final AllMoviesPage moviesPage = new AllMoviesPage();
    private final MoviePage moviePage = new MoviePage();


    @Step("Открыть страницу с фильмами")
    public void openMoviePage() {
        moviesPage.open();
    }

    @Step("Выбрать фильм")
    public void selectMovie(String movie) {
        moviesPage.selectMovie(movie);
    }

    @Step("Написать отзыв к фильму")
    public void submitReviewText(){
        String textReview = "Супер фильм, всем советую, братва";
        int rateReview = 5;
        moviePage.setRate(textReview, rateReview);
        moviePage.submitReview();
        moviePage.isReviewExists(textReview);
    }
}
