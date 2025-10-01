package steps;

import pages.MoviePageAndReviewTicket;
import pages.MoviesPageAndFilters;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoviePageSteps {
    private final MoviePageAndReviewTicket moviePage = new MoviePageAndReviewTicket();

    public MoviePageSteps publishReviewAndVerify(String movieName, String review, int rating) {
        System.out.println("Создаем отзыв для фильма: " + movieName);
        new MoviesPageAndFilters()
            .selectMovie(movieName)
            .writeReviewAndMakeARate(review, rating)
            .submitReview()
            .verifyReviewDisplayed(review);
        assertTrue(moviePage.isReviewExists(review), "Отзыв отображается на странице: ");
        return this;
    }
}
