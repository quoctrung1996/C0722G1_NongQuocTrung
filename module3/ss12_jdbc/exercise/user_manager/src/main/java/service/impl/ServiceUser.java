package service.impl;

import model.User;
import repository.IRepositoryUser;
import repository.impl.RepositoryUser;
import service.IServiceUser;

import java.sql.SQLException;
import java.util.List;

public class ServiceUser implements IServiceUser {
    private IRepositoryUser iRepositoryUser = new RepositoryUser();

    @Override
    public boolean insertUser(User user) throws SQLException {
        return iRepositoryUser.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iRepositoryUser.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iRepositoryUser.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iRepositoryUser.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return iRepositoryUser.updateUser(user);
    }

    @Override
    public  List<User>  selectUser(String country) {
        return iRepositoryUser.selectUser(country);
    }

    @Override
    public  List<User> sort() {
        return iRepositoryUser.sort();
    }
}
