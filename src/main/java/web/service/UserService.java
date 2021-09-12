package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();
    public User showUser(long id);
    public void saveUser(User user);
    public void update(Long id, User updatedUser);
    public void deleteUser(Long id);

}
