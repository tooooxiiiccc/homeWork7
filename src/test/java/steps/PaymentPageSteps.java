package steps;

import io.qameta.allure.Step;
import pages.MoviePageAndReviewTicket;
import pages.MoviesPageAndFilters;
import pages.PaymentPage;

public class PaymentPageSteps {

    @Step("Сценарий покупки билета")
    public void purchuaseTicket(String movieName, String ticket, String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvc) {
        MoviesPageAndFilters moviesPageAndFilters = new MoviesPageAndFilters().navigateToAllMoviesPage();
        MoviePageAndReviewTicket moviePageAndReviewTicket = moviesPageAndFilters.selectMovie(movieName);
        PaymentPage paymentPage = moviePageAndReviewTicket.clickBuyTicketButton();
        paymentPage
            .setTicket(ticket)
            .setCard(cardNumber)
            .setCardHolder(cardHolder)
            .setExpiryDate(expiryMonth, expiryYear)
            .setCvc(cvc)
            .clickConfirmButton();
    }

    @Step("Быстрая покупка билета")
    public void quickPayment(String movieName) {
        purchuaseTicket(
            movieName,
            "2",
            "4242424242424242",
            "John Doe",
            "Декабрь", "2025",
            "123"
        );
    }
}
