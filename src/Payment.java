public interface Payment {
    boolean processPayment(double amount);
}
class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment: " + amount+" ETB");
        return true;
    }
}

class CashPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing cash payment: " + amount+" ETB");
        return true;
    }
}

