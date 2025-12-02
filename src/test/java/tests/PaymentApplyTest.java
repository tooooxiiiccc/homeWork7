package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import steps.MoviePageSteps;
import steps.PaymentPageSteps;
import utils.PaymentData;
import utils.TestData;

@UITest
public class PaymentApplyTest {
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();
    private final MoviePageSteps moviePageSteps = new MoviePageSteps();
    private final PaymentPageSteps paymentPageSteps = new PaymentPageSteps();

    @Test
    @DisplayName("Проверка покупки билета")
    public void testTicketPurchase() {
        PaymentData paymentData = PaymentData.defaultPaymentData();
        allMoviesPageSteps.openAllMoviesPage();
        allMoviesPageSteps.pickMovie(TestData.MOVIE_NAME);
        moviePageSteps.clickBuyButton();
        paymentPageSteps.purchaseTicket(paymentData);
        paymentPageSteps.verifyPurchase();
    }
}

