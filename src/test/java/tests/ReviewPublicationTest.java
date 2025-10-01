package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.MoviePageSteps;


@UITest
public class ReviewPublicationTest {
    @Test
    @DisplayName("Проверка публикации отзыва и остается ли он на сайте")
    public void reviewIsExsists(){
        MoviePageSteps steps = new MoviePageSteps();
        steps.publishReviewAndVerify("Титаник", "Фильм супер, ставлю ",5);
    }
}
