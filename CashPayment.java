package payment.standart;

public class CashPayment implements PaymentSystem {
    @Override
    public void pay(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("You gave no money");
        }
        System.out.println("Cash payment: Payment of " + amount + " tenge completed");
    }
}
