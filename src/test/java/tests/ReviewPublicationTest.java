package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MoviePageAndReviewTicket;
import steps.MoviePageAndReviewSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@UITest
public class ReviewPublicationTest {
    @Test
    @DisplayName("Проверка публикации отзыва и остается ли он на сайте")
    @Step("Сценарий проверки оставления отзыва и его отображения")
    public void reviewIsExsists(){
        MoviePageAndReviewSteps steps = new MoviePageAndReviewSteps();
        steps.submitReview("Няшки", "Фильм шикарный, всем советую", 5);
        MoviePageAndReviewTicket ticket = new MoviePageAndReviewTicket();
        assertThat(ticket.isReviewExists("Фильм шикарный, всем советую")).isTrue();
    }
}
