package steps;

import pages.MoviesPage;
import pages.PaymentPage;

public class TicketSteps {

    public boolean purchuaseTicketForMovie(String movieName, String ticket, String cardNumber, String cardOwner, String month, String year, String cvc) {
        System.out.println("Выбираем и покупаем фильм: " + movieName);

        new MoviesPage()
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

    public boolean purhaseTicketAndVerify(String movieName, String ticket, String cardNumber, String cardOwner, String month, String year, String cvc) {

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
