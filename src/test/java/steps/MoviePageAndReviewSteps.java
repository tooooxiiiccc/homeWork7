package steps;

import io.qameta.allure.Step;
import pages.MoviePageAndReviewTicket;
import pages.MoviesPageAndFilters;

public class MoviePageAndReviewSteps {
    private final MoviePageAndReviewTicket moviePage = new MoviePageAndReviewTicket();
    @Step("Сценарий покупки билета")
    public void submitReview(String movieName, String textReview, int movieRate){
        MoviesPageAndFilters moviesPageAndFilters = new MoviesPageAndFilters().navigateToAllMoviesPage();
        MoviePageAndReviewTicket moviePageAndReviewTicket = moviesPageAndFilters.selectMovie(movieName);
        moviePageAndReviewTicket
            .setRate(textReview, movieRate)
            .submitReview();
    }
}
