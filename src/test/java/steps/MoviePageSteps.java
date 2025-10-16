package steps;
import io.qameta.allure.Step;
import pages.MoviePage;

public class MoviePageSteps {
    private final MoviePage moviePage = new MoviePage();

    @Step("Написать отзыв к фильму")
    public void submitReviewText(String reviewText, int rate) {
        moviePage.setRate(reviewText, rate);
        moviePage.submitReview();
        moviePage.isReviewExists(reviewText);
    }
}
