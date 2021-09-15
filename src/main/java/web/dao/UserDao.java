package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {

    List<User> getAll();

    User getById(long id);

    void save(User user);

    public void update(Long id, User updatedUser);

    public void delete(Long id);
}
