import java.util.List;

public class Inventory {
    private InventoryOperations inventoryOperations;

    public Inventory() {
        this.inventoryOperations = new InventoryOperations();
    }

    public void addProduct(String name, int quantity, double price) {
        Product product = new Product(0, name, quantity, price);
        inventoryOperations.addProduct(product);
    }

    public void viewProducts() {
        List<Product> products = inventoryOperations.getAllProducts();
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                               ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
        }
    }

    public void updateProduct(int id, String name, int quantity, double price) {
        Product product = new Product(id, name, quantity, price);
        inventoryOperations.updateProduct(product);
    }

    public void deleteProduct(int id) {
        inventoryOperations.deleteProduct(id);
    }
}
