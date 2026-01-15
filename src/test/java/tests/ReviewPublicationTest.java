package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import steps.MoviePageSteps;
import utils.TestData;

@UITest
@Tag("regress")
public class ReviewPublicationTest {
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();
    private final MoviePageSteps moviePageSteps = new MoviePageSteps();

    @Test
    @DisplayName("Проверка публикации отзыва и остается ли он на сайте")
    @Step("Сценарий проверки оставления отзыва и его отображения и удаление")
    public void reviewExists() {
        allMoviesPageSteps.openAllMoviesPage();
        allMoviesPageSteps.pickFirstMovie();
        moviePageSteps.submitReview(TestData.REVIEW_TEXT, TestData.REVIEW_RATING);
        moviePageSteps.verifyReviewExists(TestData.REVIEW_TEXT);
        moviePageSteps.deleteReview();
    }
}
