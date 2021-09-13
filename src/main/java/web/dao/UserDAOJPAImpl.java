package web.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOJPAImpl  implements UserDAO{

    @Autowired
    PlatformTransactionManager tm;

    EntityManager entityManager;

    @Autowired
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    @Override
    public List<User> listUsers() {

        return null;
    }
    @Transactional
    @Override
    public void saveUser(User user) {

//        TransactionTemplate transactionTemplate = new TransactionTemplate(tm);
//        transactionTemplate.execute(a -> {

        entityManager.getTransaction();
            entityManager.persist(user);
            entityManager.close();
//            return "ff";});

    }

    @Override
    public User showUser(long id) {
        return null;
    }

    @Override
    public void update(Long id, User updatedUser) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
