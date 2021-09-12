package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private List<User> list = new ArrayList<>();

    {
        list.add(new User(1L,"Mike", 29, true));
        list.add(new User(2L,"Kot", 33, false));
        list.add(new User(3L,"Drug", 50, false));
    }
    @Override
    public List<User> listUsers() {
        return list;
    }



    @Override
    public User showUser(final long id) {
        return list.stream().filter(user -> user.getUserId() == id).findAny().orElse(null);
    }

    @Override
    public void update(Long id, User updatedUser) {
    User userToBeUpdate = showUser(id);
    userToBeUpdate.setUserName(updatedUser.getUserName());
    userToBeUpdate.setUserAge(updatedUser.getUserAge());
    userToBeUpdate.setDanger(updatedUser.getDanger());
    }

    @Override
    public void deleteUser(Long id) {
        showUser(id);
        list.removeIf(a -> a.getUserId()==id);
    }

    @Override
    public void saveUser(User user) {
        list.add(user);
    }
}
