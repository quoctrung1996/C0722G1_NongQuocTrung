package model;
import java.time.format.DateTimeFormatter;

public class Customer extends Person{
    private int customerType;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String birthday, boolean gender, String identityCard, String phoneNumber, String email, String address, int customerType) {
        super(id, name, birthday, gender, identityCard, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
