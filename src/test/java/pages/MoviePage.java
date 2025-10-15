package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MoviePage {
    private SelenideElement buyTicketButton = $x("//button[.//p[contains(text(), 'Купить билет')]]");
    private SelenideElement textAreaInput = $x("//textarea[@data-qa-id='movie_review_input']");
    private SelenideElement movieRateButton = $x("//span[@data-qa-id='movie_rating_select']/parent::button");
    private SelenideElement submitReview = $x("//button[@data-qa-id='movie_review_submit_button']");

    @Step("Нажать на кнопку оплаты: ")
    public PaymentPage clickBuyTicketButton() {
        buyTicketButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        return new PaymentPage();
    }

    @Step("Написать отзыв и выбрать оценку для фильма: {'movieName'} ")
    public MoviePage setRate(String review, int rating) {
        textAreaInput.setValue(review);
        movieRateButton.click();
        SelenideElement dropdown = $x("//div[@role='listbox']").shouldBe(visible, Duration.ofSeconds(10));
        dropdown.$x(".//*[text()='" + rating + "']").click();
        return this;
    }

    @Step("Нажать на кнопку отправить отзыв ")
    public MoviePage submitReview() {
        submitReview.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Проверить, что отзыв оставлен на странице: '{review}'")
    public boolean isReviewExists(String review) {
        $x("//*[contains(text(), '" + review + "')]").shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }
}
