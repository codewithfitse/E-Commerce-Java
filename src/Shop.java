import javax.swing.*;
import java.awt.*;

public  class Shop {
    private static Inventory inventory = new Inventory();
    private static ShoppingCart cart = new ShoppingCart();
    private static Customer customer = new Customer("Kaleb", "kaleb@example.com");

    public static void main(String[] args) {

        inventory.addProduct(new Product("P100", "HP Victus", 280000, 10));
        inventory.addProduct(new Product("P101", "iphone 17 pro", 300000, 20));
        inventory.addProduct(new Product("P102", "Galaxy earbuds ", 6000, 50));

        JFrame frame = new JFrame("Online Shopping System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        JButton searchBtn = new JButton("Search Products");
        JButton addBtn = new JButton("Add to Cart");
        JButton cartBtn = new JButton("View Cart");
        JButton checkoutBtn = new JButton("Checkout");

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(searchBtn);
        panel.add(addBtn);
        panel.add(cartBtn);
        panel.add(checkoutBtn);

        frame.add(panel, BorderLayout.WEST);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        searchBtn.addActionListener(e -> {
            displayArea.setText("Product Catalog:\n");
            for (Product p : inventory.getProducts()) {
                displayArea.append(p.toString() + "\n");
            }
        });
        addBtn.addActionListener(e -> {
            String productName = JOptionPane.showInputDialog("Enter product name to add:");
            for (Product p : inventory.getProducts()) {
                if (p.getName().equalsIgnoreCase(productName)) {
                    cart.addProduct(p);
                    displayArea.setText("Added " + p.getName() + " to cart.\n");
                    return;
                }
            }
            displayArea.setText("Product not found.\n");
        });

        cartBtn.addActionListener(e -> {
            displayArea.setText("Shopping Cart:\n" + cart.displayCart());
        });

        checkoutBtn.addActionListener(e -> {
            Order order = new Order();
            for (Product p : cart.getItems()) {
                order.addItem(p, 1); // default quantity = 1
            }
            displayArea.setText(order.displayOrder());

            String[] options = {"Credit Card", "Cash"};
            int choice = JOptionPane.showOptionDialog(frame, "Choose payment method:",
                    "Payment", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            Payment payment = (choice == 0) ? new CreditCardPayment() : new CashPayment();
            boolean success = order.checkout(payment);

            displayArea.append(success ? "Payment successful!\n" : "Payment failed.\n");
        });

        frame.setVisible(true);
    }

    }


