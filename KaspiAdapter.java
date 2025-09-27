package payment.adapters;

import payment.standart.PaymentSystem;
import payment.specific.KaspiPayment;

/**
 * Adapter for KaspiPayment to PaymentSystem interface
 */
public class KaspiAdapter implements PaymentSystem {
    private KaspiPayment kaspiPayment;
    private String currency;

    public KaspiAdapter(KaspiPayment kaspiPayment, String currency) {
        this.kaspiPayment = kaspiPayment;
        this.currency = currency;
    }

    @Override
    public void pay(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be a positive value. Received: " + amount);
        }
        String transactionId = kaspiPayment.generateQR(amount, currency);
        kaspiPayment.confirmPayment(transactionId, currency);
    }
}
