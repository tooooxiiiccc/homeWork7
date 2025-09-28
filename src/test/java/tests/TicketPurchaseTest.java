package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.TicketSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
public class TicketPurchaseTest {

    @Test
    public void testTicketPurchase() {
        TicketSteps ticketSteps = new TicketSteps();
        boolean success = ticketSteps.purcaseTicketAndVerify("Механик");
            assertThat(success).isTrue();
    }
}
