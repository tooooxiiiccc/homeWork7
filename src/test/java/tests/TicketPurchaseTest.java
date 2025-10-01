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
        boolean success = ticketSteps.purhaseTicketAndVerify("Механик");
            assertThat(success).isTrue();
    }
}
