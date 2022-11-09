package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IRepositoryUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUser implements IRepositoryUser {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SELECT_USER_BY_COUNTRY = "select * from users where country =?;";
    private static final String SORT_BY_NAME = "SELECT * FROM users order by name;";


    @Override
    public boolean insertUser(User user) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User selectUser(int id) {
        Connection connection=BaseRepository.getConnectDB();
        User user = null;
        try {
            PreparedStatement ps= connection.prepareStatement(SELECT_USER_BY_ID);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
           while (resultSet.next()){
               String name = resultSet.getString("name");
               String email = resultSet.getString("email");
               String country = resultSet.getString("country");
               user = new User(id, name, email, country);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps = connection.prepareStatement(DELETE_USERS_SQL);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getId());
        return  ps.executeUpdate()>0;
    }

    @Override
    public List<User> selectUser(String country1) {
        List<User> userList = new ArrayList<>();
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            ps.setString(1,country1);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public  List<User> sort() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
