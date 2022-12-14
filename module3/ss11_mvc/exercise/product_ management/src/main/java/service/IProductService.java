package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    void remove(int id);
    Product findById(int id);
    Product search(String name);

}
