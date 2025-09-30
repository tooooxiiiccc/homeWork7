package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MoviePage {
    private SelenideElement buyTicketButton = $x("//button[.//p[contains(text(), 'Купить билет')]]");
    private SelenideElement textAreaInput = $x("//textarea[@data-qa-id='movie_review_input']");
    private SelenideElement movieRateButton = $x("//span[@data-qa-id='movie_rating_select']/parent::button");
    private SelenideElement submitReview = $x("//button[@data-qa-id='movie_review_submit_button']");
    private SelenideElement reviewList = $x("//ul[@class='mt-10 flex flex-col gap-5']");

    public PaymentPage clickBuyTicketButton() {
        buyTicketButton.click();
        sleep(1000);
        return new PaymentPage();
    }

    public MoviePage writeReviewAndMakeARate(String review, int rating) {
        textAreaInput.setValue(review);
        movieRateButton.click();
        SelenideElement dropdown = $x("//div[@role='listbox']").shouldBe(visible);
        dropdown.$x(".//*[text()='" + rating + "']").click();
        sleep(5000);
        return this;
    }

    public MoviePage submitReview() {
        submitReview.click();
        sleep(5000);
        return this;
    }

    public MoviePage verifyReview(String reviewText) {
        reviewList.shouldBe(visible).shouldHave(text(reviewText));
        return this;
    }

    public MoviePage verifyRating(int rating) {
        reviewList.shouldHave(text(String.valueOf(rating)));
        return this;
    }

    public MoviePage verifyAuthorName(String authorName) {
        reviewList.shouldBe(visible).shouldHave(text(authorName));
        return this;
    }

    public boolean reviewIsExists(String reviewText) {
        reviewList.shouldBe(visible).shouldHave(text(reviewText));
        return true;
    }

}
