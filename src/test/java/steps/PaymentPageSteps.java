package steps;

import io.qameta.allure.Step;
import pages.MoviePage;
import pages.AllMoviesPage;
import pages.PaymentPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaymentPageSteps {
    private final AllMoviesPage moviesPage = new AllMoviesPage();
    private final MoviePage moviePage = new MoviePage();
    private final PaymentPage paymentPage = new PaymentPage();

    @Step("Открыть страницу со всеми фильмами")
    public void openAllMoviesPage(){
        moviesPage.open();
    }

    @Step("Выбрать фильм и нажать кнопку оплаты")
    public void selectMovie(String movieName){
        moviesPage.selectMovie(movieName);
        moviePage.clickBuyTicketButton();
    }

    @Step("Выбрать кол-во билетов и заполнить форму страницы с оплатой")
    public void purchaseTicket(String ticket, String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvc) {
        paymentPage
            .setTicket(ticket)
            .setCard(cardNumber)
            .setCardHolder(cardHolder)
            .setExpiryDate(expiryMonth, expiryYear)
            .setCvc(cvc)
            .clickConfirmButton();
    }

    @Step("Проверить, что оплата прошла успешно")
    public void verifyPurchase() {
        assertThat(paymentPage.isPaymentSuccessful()).isTrue();
    }
}
