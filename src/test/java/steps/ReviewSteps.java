package steps;

import pages.MoviePage;
import pages.MoviesPage;

public class ReviewSteps {
    public void publishReview(String movieName) {
        System.out.println("Создаем отзыв для фильма: " + movieName);

        new MoviesPage()
            .selectMovie("Во все тяжкие")
            .writeReviewAndMakeARate("Очень крутой фильм, всем советую", 5)
            .submitReview();
        }

    public boolean isReviewExist(String reviewText) {
        publishReview("Во все тяжкие");

        MoviePage moviePage = new MoviePage();
        boolean isReviewExist = moviePage.reviewIsExists(reviewText);
        System.out.println("Отзыв для фильма: " + isReviewExist);
        return isReviewExist;
    }
}
