package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MoviePage {
    private SelenideElement buyTicketButton = $x("//button[.//p[contains(text(), 'Купить билет')]]");

    public PaymentPage clickBuyTicketButton() {
        buyTicketButton.click();
        sleep(1000);
        return new PaymentPage();
    }
}
