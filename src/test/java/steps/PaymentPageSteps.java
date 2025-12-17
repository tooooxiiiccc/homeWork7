package steps;

import io.qameta.allure.Step;
import pages.PaymentPage;
import utils.PaymentData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaymentPageSteps {
    private final PaymentPage paymentPage = new PaymentPage();

    @Step("Заполнить форму оплаты и подтвердить покупку")
    public void purchaseTicket(PaymentData paymentData) {
        paymentPage
            .setTicket(paymentData.getTicketCount())
            .setCard(paymentData.getCardNumber())
            .setCardHolder(paymentData.getCardHolder())
            .setExpiryDate(paymentData.getExpiryMonth(), paymentData.getExpiryYear())
            .setCvc(paymentData.getCvc())
            .clickConfirmButton();
    }

    @Step("Проверить, что оплата прошла успешно")
    public void verifyPurchase() {
        assertThat(paymentPage.isPaymentSuccessful())
            .as("Оплата должна быть успешной")
            .isTrue();
    }
}
