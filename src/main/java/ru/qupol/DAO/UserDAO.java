package ru.qupol.DAO;

import ru.qupol.emHelper;
import ru.qupol.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Pavl on 22.04.14.
 */
//@Stateless
public class UserDAO implements UserDAOLocal {
    //@PersistenceContext
   EntityManager em= emHelper.getEm();

    @Override
    public void addUser(User user) {


        em.persist(user);
    }

    @Override
    public void editUser(User user) {
         em.merge(user);
    }

    @Override
    public void deleteUser(int userId) {
         em.remove(getUser(userId));
    }

    @Override
    public User getUser(int userId) {
        return  em.find(User.class,userId);
    }

    @Override
public List<User> getUsers(){
    return em.createNamedQuery("User.getAll",User.class).getResultList();
}
}
