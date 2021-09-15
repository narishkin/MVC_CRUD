package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

     List<User> getUserList();
     User showUser(long id);
     void saveUser(User user);
     void update(long id, User updatedUser);
     void deleteUser(long id);

}
