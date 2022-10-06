package furama_resort.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer extends Person{
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, LocalDate birthday, String gender, String identityCard, String phoneNumber, String email, String customerType, String address) {
        super(id, name, birthday, gender, identityCard, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer:" +super.toString()+
                "customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                ';';
    }
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",getId(),getName(),getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),getGender(),getIdentityCard(),getPhoneNumber(),getEmail(),getCustomerType(),getAddress());
    }
}
