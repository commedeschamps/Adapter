package payment.specific;

// Adaptee

public class KaspiPayment {
    public String generateQR(double sum, String currency) {
        String transactionId = "KSP-" + System.currentTimeMillis();
        System.out.println("Kaspi: Generated QR-code for payment " + sum + " " + currency);
        return transactionId;
    }

    public boolean confirmPayment(String transactionId, String currency) {
        System.out.println("Kaspi: Payment confirmation " + transactionId + " in " + currency);
        return true;
    }
}
