package web.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    UserDAO userDAO;


    public UserServiceImpl(@Qualifier("userDAOJPAImpl") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public List<User> getUserList(){
        return userDAO.listUsers();
    }

    @Override
    public User showUser(long id) {
        return userDAO.showUser(id);
    }

    @Override
    public void update(long id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}
