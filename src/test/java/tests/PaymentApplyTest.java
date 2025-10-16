package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AllMoviesPage;
import pages.MoviePage;
import steps.PaymentPageSteps;

@UITest
public class PaymentApplyTest {
    private final AllMoviesPage moviesPage = new AllMoviesPage();
    private final MoviePage moviePage = new MoviePage();
    private final PaymentPageSteps paymentPageSteps = new PaymentPageSteps();

    @Test
    @DisplayName("Проверка покупки билета")
    public void testTicketPurchase() {
        moviesPage.open();
        moviesPage.selectMovie("Няшки");
        moviePage.clickBuyTicketButton();
        paymentPageSteps.purchaseTicket("2", "4242424242424242", "John Doe", "Декабрь", "2025", "123");
        paymentPageSteps.verifyPurchase();
    }
}

