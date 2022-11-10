package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_ALL_CUSTOMER="select * from customer;";
    private final String INSERT_CUSTOMER="insert into customer values (?,?,?,?,?,?,?,?,?);";
    @Override
    public List<Customer> showList() {
        List<Customer> customerList=new ArrayList<>();
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String birthday=resultSet.getString("day_of_birth");
                boolean gender= resultSet.getBoolean("gender");
                String identityCard=resultSet.getString("id_card");
                String phoneNumber=resultSet.getString("phone_number");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                int customerType=resultSet.getInt("customer_type_id");
                Customer customer=new Customer(id,name,birthday,gender,identityCard,phoneNumber,email,address,customerType);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
    public boolean add(Customer customer){
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
            ps.setInt(1,customer.getId());
            ps.setString(2,customer.getName());
            ps.setDate(3, Date.valueOf(customer.getBirthday()));
            ps.setBoolean(4,customer.getGender());
            ps.setString(5,customer.getIdentityCard());
            ps.setString(6,customer.getPhoneNumber());
            ps.setString(7,customer.getEmail());
            ps.setString(8,customer.getAddress());
            ps.setInt(9,customer.getCustomerType());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
