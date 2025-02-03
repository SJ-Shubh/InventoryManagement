import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryOperations {
    private Connection connection;

    public InventoryOperations() {
        this.connection = DatabaseConnection.getConnection();

        // try {
        // // Database URL, username, and password
        // String url = "jdbc:mysql://localhost:3306/inventory";
        // String user = "db_username";
        // String password = "db_password";

        // // Establishing the connection
        // connection = DriverManager.getConnection(url, user, password);
        // } catch (SQLException e) {
        // System.out.println("Error establishing database connection: " +
        // e.getMessage());
        // }
    }

    public void addProduct(Product product) {
        try {
            String query = "INSERT INTO Products (name, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM Products";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                products.add(new Product(id, name, quantity, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void updateProduct(Product product) {
        try {
            String query = "UPDATE Products SET name = ?, quantity = ?, price = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {
            String query = "DELETE FROM Products WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
