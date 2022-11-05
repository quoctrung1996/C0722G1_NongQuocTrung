package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "sirius", 1000, "tốt", "yamaha"));
        productList.add(new Product(2, "AB", 2000, "tốt", "honda"));
        productList.add(new Product(3, "R15", 3000, "tốt", "yamaha"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < findAll().size(); i++) {
            if(id==findAll().get(i).getId()){
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (int i = 0; i < findAll().size(); i++) {
            if(id==findAll().get(i).getId()){
                product= productList.get(i);
                break;
            }
        }
        return product;
    }
}
