package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class UserDAOJPAImpl implements UserDAO {

    PlatformTransactionManager tm;
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    public UserDAOJPAImpl(@Qualifier("transactionManager") PlatformTransactionManager tm,
                          @Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        this.tm = tm;
        this.localContainerEntityManagerFactoryBean = localContainerEntityManagerFactoryBean;
    }


    @Override
    public List<User> listUsers() {
        EntityManagerFactory emf = localContainerEntityManagerFactoryBean.getObject();
        EntityManager entityManager = emf.createEntityManager();
        List<User> list = entityManager.createQuery("from web.model.User", User.class).getResultList();
        entityManager.close();
        return list;
    }

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
        EntityManagerFactory emf = localContainerEntityManagerFactoryBean.getObject();
        EntityManager entityManager = emf.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    @Override
    public void update(Long id, User updatedUser) {
        EntityManagerFactory emf = localContainerEntityManagerFactoryBean.getObject();
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(updatedUser);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUser(Long id) {
        EntityManagerFactory emf = localContainerEntityManagerFactoryBean.getObject();
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
