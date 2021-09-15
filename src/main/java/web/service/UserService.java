package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

     List<User> getAll();
     User getById(long id);
     void save(User user);
     void update(User updatedUser);
     void delete(long id);

}
