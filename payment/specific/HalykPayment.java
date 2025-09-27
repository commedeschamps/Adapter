package payment.specific;

// Adaptee

public class HalykPayment {
    public void initiateTransaction(double amount, String currency) {
        System.out.println("Halyk Bank: Transaction initiated for amount " +
                          amount + " " + currency);
    }

    public boolean verifyTransaction(double amount) {
        System.out.println("Halyk Bank: Transaction verification for amount " + amount);
        return true;
    }
}
