package ru.qupol.DAO;

import ru.qupol.emHelper;
import ru.qupol.model.UserRights;

import javax.persistence.EntityManager;

/**
 * Created by Pavel on 05.05.2014.
 */
public class UserRightDAO {
    EntityManager em= emHelper.getEm();
    public UserRights get(int id){
       return em.find(UserRights.class,id);
    }
}
