package steps;

import pages.MoviePage;
import pages.MoviesPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoviePageSteps {
//    private final MoviePage moviePage1 = new MoviePage();
//    moviePage.
    public MoviePage publishReviewAndVerify(String movieName, String review, int rating) {
        System.out.println("Создаем отзыв для фильма: " + movieName);
        MoviePage moviePage = new MoviesPage()
            .selectMovie(movieName)
            .writeReviewAndMakeARate(review, rating)
            .submitReview()
            .verifyReviewDisplayed(review);
        assertTrue(moviePage.isReviewExists(review), "Отзыв отображается на странице: ");
        return moviePage;
    }
}
