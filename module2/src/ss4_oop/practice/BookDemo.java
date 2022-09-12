package ss4_oop.practice;

public class BookDemo {
    public static void main(String[] args) {
        Book book1 = new Book("1", "trung", 1, "1");
        Book book2 = new Book("1", "trung", 2, "1");
        Book book3 = new Book("1", "trung", 3, "1");
        Book[] list = {book1, book2, book3};
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i].getPrice();
        }
        System.out.println(sum);
        System.out.println(Book.source);
        System.out.println(book1.source);
        Book.xyz(1);
        book1.xyz(1);
    }
}
