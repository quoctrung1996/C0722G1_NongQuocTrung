package ss12_tree_map.exercise.service.impl;

import ss12_tree_map.exercise.model.Product;
import ss12_tree_map.exercise.service.IProductService;

import java.util.*;

public class ProductService implements IProductService {
    private static List<Product> list = new ArrayList<>();
    //list thì nên dùng static vì nó dùng chung
    Scanner sc = new Scanner(System.in);

    @Override
    public void addProduct() {
        Product product = this.inforProduct();
        list.add(product);
        System.out.println("Thêm thành công");
    }

    @Override
    public void editProduct() {
        System.out.println("Nhập id sản phẩm cần sửa");
        String id = sc.nextLine();
        boolean isEdit = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("Nhâp tên mới");
                String name = sc.nextLine();
                list.get(i).setName(name);
                System.out.println("Nhâp giá mới");
                double price = Double.parseDouble(sc.nextLine());
                list.get(i).setPrice(price);
                System.out.println("Sửa thành công");
                isEdit = true;
                break;
            }
        }
        if (!isEdit) {
            System.out.println("Không tìm thấy id hợp lệ");
        }

    }

    @Override
    public void deleteProduct() {
        System.out.println("Nhập id sản phẩm cần xóa");
        String id = sc.nextLine();
        boolean isDelete = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("Bạn chắc chắn muốn xóa:\n Nhập Y:Yes\n Nhập N:No");
                String choise = sc.nextLine();
                if (choise.equals("Y")) {
                    list.remove(i);
                    System.out.println("Xóa thành công");
                    isDelete = true;
                    break;
                }
            }
        }
        if (!isDelete) {
            System.out.println("Không tìm thấy id hợp lệ");
        }
    }

    @Override
    public void displayProduct() {
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        boolean isSeach = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(name)) {
                System.out.println(list.get(i).toString());
                isSeach = true;
            }
        }
        if (!isSeach) {
            System.out.println("Không có sản phẩm này");
        }

    }

    //
    @Override
    public void upDownPrice() {
        System.out.println("Chọn chức năng:");
        System.out.println("1.Sắp xếp tăng dần");
        System.out.println("2.Sắp xếp giảm dần");
        int choise = Integer.parseInt(sc.nextLine());
        switch (choise) {
            case 1:
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() > o2.getPrice()) {
                            return 1;
                        } else if (o1.getPrice() < o2.getPrice()) {
                            return -1;
                        } else {
                            return o1.getName().compareTo(o2.getName());

                        }
                    }
                });
                for (Product product : list) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() > o2.getPrice()) {
                            return -1;
                        } else if (o1.getPrice() < o2.getPrice()) {
                            return 1;
                        } else {
                            return -o1.getName().compareTo(o2.getName());
                        }
                    }
                });
                for (Product product : list) {
                    System.out.println(product.toString());
                }
                break;
        }
    }

    public Product inforProduct() {
        System.out.println("Nhập id sản phẩm");
        String id = sc.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = Double.parseDouble(sc.nextLine());
        Product product = new Product(id, name, price);
        return product;
    }
}
