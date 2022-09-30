package ss17_io_binary_file.exercixe.product.model;

public class Product {
    private int id;
    private String name;
    private String productName;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String productName, double price) {
        this.id = id;
        this.name = name;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
