package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository=new CustomerRepository();
    @Override
    public List<Customer> showList() {
        return iCustomerRepository.showList();
    }

    @Override
    public boolean add(Customer customer) {
        return iCustomerRepository.add(customer);
    }
}
