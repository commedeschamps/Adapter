package payment.standart;

// Target interface

public interface PaymentSystem {
    void pay(double amount) throws IllegalArgumentException;
}
