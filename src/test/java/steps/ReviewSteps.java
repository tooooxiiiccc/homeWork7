package steps;

import pages.MoviePage;
import pages.MoviesPage;

public class ReviewSteps {
    public void publishReview(String movieName) {
        System.out.println("Создаем отзыв для фильма: " + movieName);

        new MoviesPage()
            .selectMovie("Титаник")
            .writeReviewAndMakeARate("Очень крутой фильм, всем советую", 5)
            .submitReview();
        }

    public boolean isReviewExist(String reviewText) {
        publishReview("Титаник");

        MoviePage moviePage = new MoviePage();
        boolean isReviewExist = moviePage.reviewIsExists(reviewText);
        System.out.println("Отзыв для фильма: " + isReviewExist);
        return isReviewExist;
    }
}
