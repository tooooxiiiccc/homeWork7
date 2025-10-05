package steps;

import io.qameta.allure.Step;
import pages.MoviesPageAndFilters;
import pages.PaymentPage;

public class TicketSteps {
    
    @Step("Выбираем и покупаем фильм: {movieName}")
    public boolean purchuaseTicketForMovie(String movieName, String ticket, String cardNumber, String cardOwner, String month, String year, String cvc) {
        new MoviesPageAndFilters()
            .selectMovie(movieName)
            .clickBuyTicketButton()
            .setTicketInput(ticket)
            .enterCardInput(cardNumber)
            .enterCardOwnerInput(cardOwner)
            .enterExpiryDate(month, year)
            .enterCvcInput(cvc)
            .clickConfirmButton();
        return false;
    }
    
    @Step("Подтвердить, что оплата прошла успешно")
    public boolean purhaseTicketAndVerify(String movieName) {
        PaymentPage paymentPage = new PaymentPage();
        boolean success = paymentPage.isPaymentSuccessful();
        if (success) {
            System.out.println("Оплата прошла успешно для фильма: " + movieName);
        } else {
            System.out.println("Оплата не прошла, повторите попытку!");
        }
        return success;
    }
}
