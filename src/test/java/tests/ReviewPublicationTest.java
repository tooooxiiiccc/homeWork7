package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import steps.MoviePageSteps;

@UITest
public class ReviewPublicationTest {
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();
    private final MoviePageSteps moviePageSteps = new MoviePageSteps();

    @Test
    @DisplayName("Проверка публикации отзыва и остается ли он на сайте")
    @Step("Сценарий проверки оставления отзыва и его отображения и удаление")
    public void reviewIsExsists() {
        allMoviesPageSteps.openAllMoviesPage();
        allMoviesPageSteps.pickMovie("Няшки");
        moviePageSteps.submitReviewText("Супер фильм, всем советую, братва", 5);
        moviePageSteps.deleteReview();
    }
}
