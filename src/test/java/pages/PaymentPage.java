package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class PaymentPage {
    private SelenideElement ticketInput = $x("//input[@data-qa-id='payment_amount_input']");
    private SelenideElement cardInput = $x("//input[@data-qa-id='payment_card_number_input']");
    private SelenideElement cardOwnerInput = $x("//input[@data-qa-id='payment_card_holder_input']");
    private SelenideElement expiryMonthSelect = $x("//button[@data-qa-id='payment_card_month_select']");
    private SelenideElement expiryYearSelect = $x("//button[@data-qa-id='payment_card_year_select']");
    private SelenideElement cvcInput = $x("//input[@id='cvc']");
    private SelenideElement confirmButton = $x("//button[@data-qa-id='payment_submit_button']");
    private SelenideElement successMessage = $x("//p[contains(text(), 'Спасибо за покупку')]");

    public PaymentPage enterTicketInput(String ticket) {
        System.out.println("Вводим кол-во билетов" + ticket);
        ticketInput.setValue(ticket);
        return this;
    }

    public PaymentPage enterCardInput(String cardNumber) {
        System.out.println("Вводим номер карты" + cardNumber);
        cardInput.setValue(cardNumber);
        return this;
    }

    public PaymentPage enterCardOwnerInput(String cardOwner) {
        System.out.println("Вводим данные владельца карты" + cardOwner);
        cardOwnerInput.setValue(cardOwner);
        return this;
    }

    public PaymentPage enterExpiryDate(String month, String year) {
        System.out.println("Вводим срок годности карты" + month + "/" + year);
        expiryMonthSelect.click();
        $x("//span[contains(text(), '" + month + "')]").click();
        expiryYearSelect.click();
        $x("//span[contains(text(), '" + year + "')]").click();
        return this;
    }

    public PaymentPage enterCvcInput(String cvc) {
        System.out.println("Вводим CVC код:" + cvc);
        cvcInput.setValue(cvc);
        return this;
    }

    public PaymentPage clickConfirmButton() {
        confirmButton.click();
        sleep(10000);
        return this;
    }

    public PaymentPage enterAllPaymentFields(String ticket, String cardNumber, String cardOwner, String month, String year, String cvc) {
        return enterTicketInput(ticket)
            .enterCardInput(cardNumber)
            .enterCardOwnerInput(cardOwner)
            .enterExpiryDate(month, year)
            .enterCvcInput(cvc);
    }

    public boolean isPaymentSuccessful() {
        boolean success = successMessage.exists();
        System.out.println("Оплата проведена успешно" + success);
        return success;
    }
}
