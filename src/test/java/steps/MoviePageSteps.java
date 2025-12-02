package steps;
import io.qameta.allure.Step;
import pages.MoviePage;

public class MoviePageSteps {
    private final MoviePage moviePage = new MoviePage();

    @Step("Нажать на кнопку оплаты")
    public void clickBuyButton(){
        moviePage.clickBuyTicketButton();
    }

    @Step("Написать отзыв к фильму: {reviewText} с оценкой {rate}")
    public void submitReview(String reviewText, int rate) {
        moviePage.setRate(reviewText, rate);
        moviePage.submitReview();
    }

    @Step("Проверить, что отзыв существует: {reviewText}")
    public void verifyReviewExists(String reviewText) {
        moviePage.verifyReviewExists(reviewText);
    }

    @Step("Удалить отзыв")
    public void deleteReview() {
        moviePage.deleteReview();
    }
}
