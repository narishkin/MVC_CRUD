package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserDAO userDAO;


    public UserServiceImpl(UserDAO userDAO) {
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
    public void update(Long id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
