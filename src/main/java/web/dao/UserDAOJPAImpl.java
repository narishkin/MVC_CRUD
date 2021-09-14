package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class UserDAOJPAImpl implements UserDAO {

    @Autowired
    PlatformTransactionManager tm;


    @Autowired
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;


@Transactional
    @Override
    public List<User> listUsers() {
//        EntityManagerFactory emf = localContainerEntityManagerFactoryBean.getObject();
//        EntityManager entityManager = emf.createEntityManager();
//        List list = entityManager.createQuery("from http_users").getResultList();
//        entityManager.close();
        return null;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        EntityManagerFactory emf = localContainerEntityManagerFactoryBean.getObject();
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();


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
