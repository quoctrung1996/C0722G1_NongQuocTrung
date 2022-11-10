package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where id=?;";
    private static final String INSERT_CUSTOMER = "INSERT INTO `furama_resort_web`.`customer` (`id`, `name`, `day_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`, `customer_type_id`) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_USERS_SQL = "update customer set name = ?,day_of_birth= ?, gender =?,id_card= ?,phone_number=?,email=?,address=?,customer_type_id=? where id=?";
    private static final String DELETE_CUSTOMER = "delete from customer where id=?;";
    private static final String SHOW_LIST="select * from customer where name like ?;";

    @Override
    public List<Customer> showList() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String birthday = result.getString("day_of_birth");
                Boolean gender = result.getBoolean("gender");
                String identityCard = result.getString("id_card");
                String phoneNumber = result.getString("phone_number");
                String email = result.getString("email");
                String address = result.getString("address");
                int customerType = result.getInt("customer_type_id");
                Customer customer = new Customer(id, name, birthday, gender, identityCard, phoneNumber, email, address, customerType);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setDate(3, Date.valueOf(customer.getBirthday()));
            ps.setBoolean(4, customer.getGender());
            ps.setString(5, customer.getIdentityCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            ps.setInt(9, customer.getCustomerType());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);
            ps.setInt(9, customer.getId());
            ps.setString(1, customer.getName());
            ps.setDate(2, Date.valueOf(customer.getBirthday()));
            ps.setBoolean(3, customer.getGender());
            ps.setString(4, customer.getIdentityCard());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getAddress());
            ps.setInt(8, customer.getCustomerType());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Customer findById(int id) {
        Connection connection = BaseRepository.getConnectDB();
        Customer customer = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                String birthday = result.getString("day_of_birth");
                Boolean gender = result.getBoolean("gender");
                String identityCard = result.getString("id_card");
                String phoneNumber = result.getString("phone_number");
                String email = result.getString("email");
                String address = result.getString("address");
                int customerType = result.getInt("customer_type_id");
                customer = new Customer(id, name, birthday, gender, identityCard, phoneNumber, email, address, customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
