package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showList();
    boolean insertCustomer(Customer customer);
    boolean editCustomer(Customer customer);
    boolean deleteCustomer(int id);
    Customer findById(int id);
}
