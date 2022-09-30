package ss17_io_binary_file.exercixe.product.service.impl;

import ss17_io_binary_file.exercixe.product.model.Product;
import ss17_io_binary_file.exercixe.product.service.IproductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IproductService {
    List<Product> productList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addProduct() {
        Product product = this.info();
        productList.add(product);
        System.out.println("Thêm thành công");
        output();
    }

    @Override
    public void displayProduct() {
        productList=this.input();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void searchName() {
        System.out.println("Nhập tên sản phẩm cần tìm kiếm:");
        String name = sc.nextLine();
        boolean isName = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                System.out.println(productList.get(i).toString());
                isName = true;
            }
        }
        if (!isName) {
            System.out.println("Không tìm thấy tên cần tìm");
        }
    }

    @Override
    public void searchId() {
        System.out.println("Nhập mẫ cần tìm kiếm:");
        int id = Integer.parseInt(sc.nextLine());
        boolean isId = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                System.out.println(productList.get(i).toString());
                isId = true;
                break;
            }
        }
        if (!isId) {
            System.out.println("Không tìm thấy mã cần tìm");
        }
    }

    public Product info() {
        System.out.println("Nhập id sảm phẩm");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("Nhập hãng sản xuất");
        String productName = sc.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = Double.parseDouble(sc.nextLine());
        Product product = new Product(id, name, productName, price);
        return product;
    }

    public List<Product> input() {
        try {
            FileInputStream fis=new FileInputStream("src/ss17_io_binary_file/exercixe/product/data/product.dat");
            ObjectInputStream ois=new ObjectInputStream(fis);
            productList=(List<Product>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            productList = new ArrayList<>();
        }
        return productList;
    }

    public void output() {
        try {
            FileOutputStream fos = new FileOutputStream("src/ss17_io_binary_file/exercixe/product/data/product.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getInfo(Product product) {
        System.out.println(product.getId() + "," + product.getName() + "," + product.getProductName() + "," + product.getPrice());
    }
}
