import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item item1 = new Item("Product 1", 10.99);
        Item item2 = new Item("Product 2", 5.99);

        List<Item> availableItems = new ArrayList<>();
        availableItems.add(item1);
        availableItems.add(item2);

        System.out.println("Available Items:");
        for (int i = 0; i < availableItems.size(); i++) {
            Item item = availableItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }

        ShoppingCart cart = new ShoppingCart();
        
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Enter the number of the item you want to add to the shopping cart (0 to finish shopping):");
            int selectedItemNumber = scanner.nextInt();

            if (selectedItemNumber == 0) {
                continueShopping = false;
            } else if (selectedItemNumber >= 1 && selectedItemNumber <= availableItems.size()) {
                Item selectedItem = availableItems.get(selectedItemNumber - 1);
                cart.addItem(selectedItem);
                System.out.println("Added " + selectedItem.getName() + " to the shopping cart.");
            } else {
                System.out.println("Invalid item number.");
            }
        }

        double total = cart.calculateTotal();
        System.out.println("Total amount: $" + total);

        System.out.println("Select payment method (1 for Cash, 2 for Credit Card):");
        int paymentMethod = scanner.nextInt();

        if (paymentMethod == 1) {
            Payment payment = new CashPayment();
            payment.processPayment(total);
        } else if (paymentMethod == 2) {
            System.out.println("Enter credit card number:");
            String cardNumber = scanner.next();
            Payment payment = new CreditCardPayment(cardNumber);
            payment.processPayment(total);
        } else {
            System.out.println("Invalid payment method.");
        }

        scanner.close();
    }
}
