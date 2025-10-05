package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class PaymentPage {
    private SelenideElement paymentAmountInput = $x("//input[@data-qa-id='payment_amount_input']");
    private SelenideElement paymentCardNumberInput = $x("//input[@data-qa-id='payment_card_number_input']");
    private SelenideElement paymentCardHolderInput = $x("//input[@data-qa-id='payment_card_holder_input']");
    private SelenideElement paymentCardMonthSelect = $x("//button[@data-qa-id='payment_card_month_select']");
    private SelenideElement paymentCardYearSelect = $x("//button[@data-qa-id='payment_card_year_select']");
    private SelenideElement cvcInput = $x("//input[@id='cvc']");
    private SelenideElement paymentSubmitButton = $x("//button[@data-qa-id='payment_submit_button']");
    private SelenideElement successMessage = $x("//p[contains(text(), 'Спасибо за покупку')]");

    @Step("Ввести кол-во билетов")
    public PaymentPage setTicketInput(String ticket) {
        paymentAmountInput.setValue(ticket);
        return this;
    }

    @Step("Ввести номер карты")
    public PaymentPage enterCardInput(String cardNumber) {
        paymentCardNumberInput.setValue(cardNumber);
        return this;
    }

    @Step("Ввести имя владельца карты")
    public PaymentPage enterCardOwnerInput(String cardOwner) {
        paymentCardHolderInput.setValue(cardOwner);
        return this;
    }

    @Step("Выбрать дату окончания действия карты")
    public PaymentPage enterExpiryDate(String month, String year) {
        paymentCardMonthSelect.click();
        $x("//span[contains(text(), '" + month + "')]").click();
        paymentCardYearSelect.click();
        $x("//span[contains(text(), '" + year + "')]").click();
        return this;
    }

    @Step("Ввести CVC-код от карты")
    public PaymentPage enterCvcInput(String cvc) {
        cvcInput.setValue(cvc);
        return this;
    }

    @Step("Нажать на кнопку Оплатить")
    public PaymentPage clickConfirmButton() {
        paymentSubmitButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }

//    public PaymentPage enterAllPaymentFields(String ticket, String cardNumber, String cardOwner, String month, String year, String cvc) {
//        return enterTicketInput(ticket)
//            .enterCardInput(cardNumber)
//            .enterCardOwnerInput(cardOwner)
//            .enterExpiryDate(month, year)
//            .enterCvcInput(cvc);
//    }

    public boolean isPaymentSuccessful() {
        boolean success = successMessage.shouldBe(visible, Duration.ofSeconds(10)).exists();
        return success;
    }
}
