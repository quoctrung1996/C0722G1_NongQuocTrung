package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository=new CustomerRepository();
    @Override
    public  List<Customer> showList() {
        return iCustomerRepository.showList();
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return iCustomerRepository.insertCustomer(customer);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return iCustomerRepository.editCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }
}
