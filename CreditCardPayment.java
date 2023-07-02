// CreditCardPayment.java
public class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " with card number " + cardNumber);
        // Logika untuk pemrosesan pembayaran kartu kredit
    }
}
