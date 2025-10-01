package steps;

import pages.MoviePage;
import pages.MoviesPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoviePageSteps {
    private final MoviePage moviePage = new MoviePage();

    public MoviePageSteps publishReviewAndVerify(String movieName, String review, int rating) {
        System.out.println("Создаем отзыв для фильма: " + movieName);
        new MoviesPage()
            .selectMovie(movieName)
            .writeReviewAndMakeARate(review, rating)
            .submitReview()
            .verifyReviewDisplayed(review);
        assertTrue(moviePage.isReviewExists(review), "Отзыв отображается на странице: ");
        return this;
    }
}
