import java.util.ArrayList;
import java.util.List;

class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product); // put the product into the list
    }

    public List<Product> getItems() {
        return items;
    }


    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            Product p = items.get(i);
            total += p.getPrice();
        }
        return total;
    }

    public String displayCart() {
        String result = "Your Shopping Cart:\n";
        for (int i = 0; i < items.size(); i++) {
            Product p = items.get(i);
            result += p.toString() + "\n";
        }
        result += "Total: " + calculateTotal() + " ETB \n";
        return result;
    }
}
