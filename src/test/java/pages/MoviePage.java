package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Timeouts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MoviePage {
    private SelenideElement buyTicketButton = $x("//button[.//p[contains(text(), 'Купить билет')]]");
    private SelenideElement textAreaInput = $("textarea[data-qa-id='movie_review_input']");
    private SelenideElement movieRateButton = $x("//span[@data-qa-id='movie_rating_select']/parent::button");
    private SelenideElement submitReview = $x("//button[@data-qa-id='movie_review_submit_button']");
    private SelenideElement btnReviewMenu = $(".lucide-ellipsis-vertical");
    private SelenideElement reviewDeleteOption = $("div[data-qa-id*='delete']");

    @Step("Нажать на кнопку оплаты")
    public PaymentPage clickBuyTicketButton() {
        buyTicketButton.shouldBe(visible, Timeouts.DEFAULT).click();
        return new PaymentPage();
    }

    @Step("Написать отзыв: {review} и выбрать оценку: {rating}")
    public MoviePage setRate(String review, int rating) {
        textAreaInput.setValue(review);
        movieRateButton.click();
        SelenideElement dropdown = $x("//div[@role='listbox']").shouldBe(visible, Timeouts.DEFAULT);
        dropdown.$x(".//*[text()='" + rating + "']").click();
        return this;
    }

    @Step("Нажать на кнопку отправить отзыв")
    public MoviePage submitReview() {
        submitReview.shouldBe(visible, Timeouts.DEFAULT).click();
        return this;
    }

    @Step("Проверить, что отзыв существует на странице: {review}")
    public void verifyReviewExists(String review) {
        $x("//*[contains(text(), '" + review + "')]").shouldBe(visible, Timeouts.DEFAULT);
    }

    @Step("Удалить отзыв")
    public MoviePage deleteReview() {
        btnReviewMenu.click();
        reviewDeleteOption.click();
        return this;
    }
}
