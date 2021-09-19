package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getAll();

    User getById(long id);

    void save(User user);

    void update(User updatedUser);

    void delete(Long id);

    User findByUserName(String username);
}
