package payment.adapters;

import payment.specific.HalykPayment;
import payment.standart.PaymentSystem;

//Adapter
public class HalykAdapter implements PaymentSystem {
    private HalykPayment halykPayment;
    private String currency;

    public HalykAdapter(HalykPayment halykPayment, String currency) {
        this.halykPayment = halykPayment;
        this.currency = currency;
    }

    @Override
    public void pay(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0. Received: " + amount);
        }
        halykPayment.initiateTransaction(amount, currency);
        halykPayment.verifyTransaction(amount);
    }
}
