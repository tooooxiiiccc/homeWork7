package steps;
import io.qameta.allure.Step;
import pages.MoviePage;

public class MoviePageSteps {
    private final MoviePage moviePage = new MoviePage();

    @Step("Нажать на кнопку оплаты")
    public void clickBuyButton(){
        moviePage.clickBuyTicketButton();
    }

    @Step("Написать отзыв к фильму")
    public void submitReviewText(String reviewText, int rate) {
        moviePage.setRate(reviewText, rate);
        moviePage.submitReview();
        moviePage.isReviewExists(reviewText);
    }

    @Step("Удалить отзыв")
    public void deleteReview() {
        moviePage.deleteReview();
    }
}
