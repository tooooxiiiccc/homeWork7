package steps;

import pages.MoviesPage;
import pages.PaymentPage;

public class TicketSteps {

    public void purchuaseTicketForMovie(String movieName) {
        System.out.println("Выбираем и покупаем фильм: " + movieName);

        new MoviesPage()
            .selectMovie(movieName)
            .clickBuyTicketButton()
            .enterTicketInput("1")
            .enterCardInput("4242424242424242")
            .enterCardOwnerInput("John Doe")
            .enterExpiryDate("Декабрь", "2025")
            .enterCvcInput("123")
            .clickConfirmButton();
    }

    public boolean purcaseTicketAndVerify(String movieName) {
        purchuaseTicketForMovie(movieName);

        PaymentPage paymentPage = new PaymentPage();
        boolean success = paymentPage.isPaymentSuccessful();
        System.out.println("Оплата прошла успешна: " + movieName);
        return success;
    }
}
