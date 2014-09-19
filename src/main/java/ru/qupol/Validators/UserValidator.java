package ru.qupol.Validators;

import ru.qupol.emHelper;
import ru.qupol.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Pavel on 05.05.2014.
 */
public class UserValidator implements Validator {
    EntityManager em = emHelper.getEm();
    String login=null;
    String password=null;

    public UserValidator(String login, String password){
    this.login=login;
    this.password=password;
}

  @Override
  public Object validate(){
      Query query=em.createQuery("SELECT u from User u where name=:login");
      query.setParameter("login",login);
      User foundedUser=null;
      List<User> users =query.getResultList();
      if(!users.isEmpty()) {
          foundedUser = users.get(0);
          if (foundedUser.getPassword().equals(password)) {

              return foundedUser;
          }
      }

      return null;



  }
}
