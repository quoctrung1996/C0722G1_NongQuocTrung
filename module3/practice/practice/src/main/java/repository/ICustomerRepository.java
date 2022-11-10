package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> showList();
    boolean add(Customer customer);
}
