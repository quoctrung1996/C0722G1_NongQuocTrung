package ss4_oop.practice;

public class Book {
    String code;
    String name;
    int price;
    String author;
    static String source = "tiki";//có thể truy cập thông qua tên lớp

    public Book() {
    }

    public Book(String code) {
        this.code = code;
    }

    public Book(String code, String name, int price, String author) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public static void xyz(int a) {
        System.out.println(a);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
