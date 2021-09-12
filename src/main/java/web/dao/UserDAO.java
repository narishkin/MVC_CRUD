package web.dao;

import web.model.User;

import java.util.List;


public interface UserDAO {

    List<User> listUsers();

    void saveUser(User user);

    User showUser(long id);

    public void update(Long id, User updatedUser);

    public void deleteUser(Long id);
}
