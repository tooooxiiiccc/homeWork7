package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import steps.MoviePageSteps;
import steps.PaymentPageSteps;

@UITest
public class PaymentApplyTest {
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();
    private final MoviePageSteps moviePageSteps = new MoviePageSteps();
    private final PaymentPageSteps paymentPageSteps = new PaymentPageSteps();

    @Test
    @DisplayName("Проверка покупки билета")
    public void testTicketPurchase() {
        allMoviesPageSteps.openAllMoviesPage();
        allMoviesPageSteps.pickMovie("Няшки");
        moviePageSteps.clickBuyButton();
        paymentPageSteps.purchaseTicket("2", "4242424242424242", "John Doe", "Декабрь", "2025", "123");
        paymentPageSteps.verifyPurchase();
    }
}

