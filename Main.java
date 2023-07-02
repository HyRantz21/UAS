// Main.java
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Product 1", 10.99);
        Item item2 = new Item("Product 2", 5.99);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item1);
        cart.addItem(item2);

        double total = cart.calculateTotal();
        System.out.println("Total amount: $" + total);

        Payment payment = new CashPayment();
        payment.processPayment(total);

        // Atau menggunakan pembayaran kartu kredit:
        // Payment payment = new CreditCardPayment("1234567890");
        // payment.processPayment(total);
    }
}
