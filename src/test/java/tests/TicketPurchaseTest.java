package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.TicketSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
public class TicketPurchaseTest {

    @Test
    @DisplayName("Проверка покупки билета")
    public void testTicketPurchase() {
        TicketSteps ticketSteps = new TicketSteps();
        ticketSteps.purchuaseTicketForMovie("Титаник", "2", "4242424242424242", "John Doe", "Декабрь", "2025", "123");
        boolean success = ticketSteps.purhaseTicketAndVerify("Титаник");
            assertThat(success).isTrue();
    }
}
