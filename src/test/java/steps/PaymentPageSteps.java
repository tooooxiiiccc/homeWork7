package steps;

import io.qameta.allure.Step;
import pages.PaymentPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaymentPageSteps {
    private final PaymentPage paymentPage = new PaymentPage();

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
