package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.MoviePageSteps;

@UITest
public class ReviewPublicationTest {
    private final MoviePageSteps moviePageSteps = new MoviePageSteps();
    @Test
    @DisplayName("Проверка публикации отзыва и остается ли он на сайте")
    @Step("Сценарий проверки оставления отзыва и его отображения")
    public void reviewIsExsists(){
        moviePageSteps.openMoviePage();
        moviePageSteps.selectMovie("Няшки");
        moviePageSteps.submitReviewText();
    }
}
