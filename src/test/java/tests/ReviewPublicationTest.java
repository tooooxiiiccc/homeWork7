package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.ReviewSteps;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@UITest
public class ReviewPublicationTest {
    @Test
    public void reviewPublication() {
    }

    @Test
    public void reviewIsExsists(){
        ReviewSteps steps = new ReviewSteps();
        boolean reviewSuccess = steps.isReviewExist("Очень крутой фильм, всем советую");
        assertThat(reviewSuccess).isTrue();
    }
}
