import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private Payment payment;

    public double calculateTotal() {
        return 0;
    }
    public boolean checkout(Payment payment) {
        this.payment = payment;
        double total = calculateTotal();
        return payment.processPayment(total);
    }
    public String displayOrder() {
        
        String result = "Order for " + customer.getName() + "\n";

        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i); 
            result += item.toString() + "\n"; 
        }
        
        result += "Total: " + calculateTotal() + " ETB \n";
        
        return result;
    }


    public void addItem(Product p, int i) {
    }
}
