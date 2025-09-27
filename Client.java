import payment.adapters.HalykAdapter;
import payment.adapters.KaspiAdapter;
import payment.standart.PaymentSystem;
import payment.specific.HalykPayment;
import payment.specific.KaspiPayment;
import payment.standart.CashPayment;

public class Client {
    public static void clientCode(PaymentSystem paymentSystem, double amount) {
        System.out.println("Client code initiates payment...");
        try {
            paymentSystem.pay(amount);
            System.out.println("Payment via " + paymentSystem.getClass().getSimpleName() + " completed\n");
        } catch (Exception e) {
            System.out.println("Error during payment via " + paymentSystem.getClass().getSimpleName() + ": " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Adapter Pattern Demonstration --- \n");

        System.out.println("1. Cash payment:");
        PaymentSystem cash = new CashPayment();
        clientCode(cash, 1500);

        System.out.println("2. Payment via Kaspi:");
        PaymentSystem kaspiAdapter = new KaspiAdapter(new KaspiPayment(), "KZT");
        clientCode(kaspiAdapter, 45000);

        System.out.println("3. Payment via Halyk Bank:");
        PaymentSystem halykAdapter = new HalykAdapter(new HalykPayment(), "USD");
        clientCode(halykAdapter, 0);
    }
}
