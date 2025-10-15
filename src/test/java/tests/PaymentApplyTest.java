package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.PaymentPageSteps;

@UITest
public class PaymentApplyTest {
    PaymentPageSteps paymentPageSteps = new PaymentPageSteps();
    @Test
    @DisplayName("Проверка покупки билета")
    public void testTicketPurchase() {
        paymentPageSteps.openAllMoviesPage();
        paymentPageSteps.selectMovie("Механик");
        paymentPageSteps.purchaseTicket("2", "4242424242424242", "John Doe", "Декабрь", "2025", "123");
        paymentPageSteps.verifyPurchase();
    }
}

