package utils;

public class PaymentData {
    private final String ticketCount;
    private final String cardNumber;
    private final String cardHolder;
    private final String expiryMonth;
    private final String expiryYear;
    private final String cvc;

    public PaymentData(String ticketCount, String cardNumber, String cardHolder, 
                      String expiryMonth, String expiryYear, String cvc) {
        this.ticketCount = ticketCount;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvc = cvc;
    }

    public String getTicketCount() {
        return ticketCount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getCvc() {
        return cvc;
    }

    public static PaymentData defaultPaymentData() {
        return new PaymentData("2", "4242424242424242", "John Doe", "Декабрь", "2026", "123");
    }
}





