package pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoviePage {
    private SelenideElement buyTicketButton = $x("//button[.//p[contains(text(), 'Купить билет')]]");
    private SelenideElement textAreaInput = $x("//textarea[@data-qa-id='movie_review_input']");
    private SelenideElement movieRateButton = $x("//span[@data-qa-id='movie_rating_select']/parent::button");
    private SelenideElement submitReview = $x("//button[@data-qa-id='movie_review_submit_button']");

    public PaymentPage clickBuyTicketButton() {
        buyTicketButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        return new PaymentPage();
    }

    public MoviePage writeReviewAndMakeARate(String review, int rating) {
        textAreaInput.setValue(review);
        movieRateButton.click();
        SelenideElement dropdown = $x("//div[@role='listbox']").shouldBe(visible, Duration.ofSeconds(10));
        dropdown.$x(".//*[text()='" + rating + "']").click();
        return this;
    }

    public MoviePage submitReview() {
        submitReview.click();
        sleep(5000);
        return this;
    }

    public boolean isReviewExists(String review) {
        try {
            $x("//*[contains(text(), '" + review + "')]").shouldBe(visible, Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public MoviePage verifyReviewDisplayed(String review) {
        assertThat(isReviewExists(review))
            .as("Отзыв с текстом '%s' должен отображаться на странице", review)
            .isTrue();
        System.out.println("Отзыв соответствует оставленному ранее");
        return this;
    }

//    public MoviePage verifyRating(int rating) {
//        reviewList.shouldHave(text(String.valueOf(rating)));
//        return this;
//    }
//
//    public MoviePage verifyAuthorName(String authorName) {
//        reviewList.shouldBe(visible).shouldHave(text(authorName));
//        return this;
//    }

}
