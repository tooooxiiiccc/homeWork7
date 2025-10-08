package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PaymentPage;
import steps.PaymentPageSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
public class PaymentApplyTest {

    @Test
    @DisplayName("Проверка покупки билета")
    public void testTicketPurchase() {
        new PaymentPageSteps().quickPayment("Титаник");
        PaymentPage paymentPage = new PaymentPage();
        assertThat(paymentPage.isPaymentSuccessful()).isTrue();
    }
}

