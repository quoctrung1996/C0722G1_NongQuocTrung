package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showList();
    boolean add(Customer customer);

}
