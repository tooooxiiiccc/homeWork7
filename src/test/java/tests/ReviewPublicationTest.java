package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AllMoviesPage;
import pages.MoviePage;
import steps.MoviePageSteps;

@UITest
public class ReviewPublicationTest {
    private final MoviePageSteps moviePageSteps = new MoviePageSteps();
    private final AllMoviesPage allMoviesPage = new AllMoviesPage();
    private final MoviePage moviePage = new MoviePage();

    @Test
    @DisplayName("Проверка публикации отзыва и остается ли он на сайте")
    @Step("Сценарий проверки оставления отзыва и его отображения и удаление")
    public void reviewIsExsists() {
        allMoviesPage.open();
        allMoviesPage.selectMovie("Няшки");
        moviePageSteps.submitReviewText("Супер фильм, всем советую, братва", 5);
        moviePage.deleteReview();
    }




}
