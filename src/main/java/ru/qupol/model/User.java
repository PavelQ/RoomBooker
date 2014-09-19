package ru.qupol.model;
import ru.qupol.DAO.UserRightDAO;

import javax.persistence.*;

/**
 * Created by Pavl on 03.03.14.
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.getAll",query = "SELECT u FROM User u")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Password")
    private String password;

    @ManyToOne(fetch=FetchType.EAGER)
    private UserRights rights;

    public User() {
    }

    public User(String name, String password, UserRights rights) {
        this.name = name;
        this.password = password;
        this.rights = rights;
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        UserRightDAO userRightDAO=new UserRightDAO();
        UserRights userRights=userRightDAO.get(1);
        this.rights=userRights;
    }

    public void setId(int id){this.id=id;}

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRights getRights() {
        return rights;
    }

    public void setRights(UserRights rights) {
        this.rights = rights;
    }



    @Override
    public String toString(){
        String s="User details: id="+id+" name="+name+" rights id="
                + rights.getId()+"("+rights.getRightName() +") password ="+password;
        return s;
    }
}
