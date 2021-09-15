package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private List<User> list = new ArrayList<>();

    {
        list.add(new User("Mike", 29, true));
        list.add(new User("Kot", 33, false));
        list.add(new User("Drug", 50, false));
    }
    @Override
    public List<User> listUsers() {
        return list;
    }

    @Override
    public User showUser(final long id) {
        return list.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void update(Long id, User updatedUser) {
    User userToBeUpdate = showUser(id);
    userToBeUpdate.setName(updatedUser.getName());
    userToBeUpdate.setAge(updatedUser.getAge());
    userToBeUpdate.setDanger(updatedUser.getDanger());
    }

    @Override
    public void deleteUser(Long id) {
        showUser(id);
        list.removeIf(a -> a.getId()==id);
    }

    @Override
    public void saveUser(User user) {
        list.add(user);
    }
}
