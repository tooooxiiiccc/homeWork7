package pages;

import com.codeborne.selenide.SelenideElement;
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

    public PaymentPage setTicketInput(String ticket) {
        paymentAmountInput.setValue(ticket);
        return this;
    }

    public PaymentPage enterCardInput(String cardNumber) {
        paymentCardNumberInput.setValue(cardNumber);
        return this;
    }

    public PaymentPage enterCardOwnerInput(String cardOwner) {
        paymentCardHolderInput.setValue(cardOwner);
        return this;
    }

    public PaymentPage enterExpiryDate(String month, String year) {
        paymentCardMonthSelect.click();
        $x("//span[contains(text(), '" + month + "')]").click();
        paymentCardYearSelect.click();
        $x("//span[contains(text(), '" + year + "')]").click();
        return this;
    }

    public PaymentPage enterCvcInput(String cvc) {
        cvcInput.setValue(cvc);
        return this;
    }

    public PaymentPage clickConfirmButton() {
        paymentSubmitButton.click();
        sleep(10000);
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
        boolean success = successMessage.exists();
        return success;
    }
}
