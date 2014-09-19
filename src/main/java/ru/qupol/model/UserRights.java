package ru.qupol.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Pavl on 26.03.14.
 */
@Entity
@Table(name = "User_Rights")
public class UserRights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String rightName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rights")
    private  Collection<User> users;

    public UserRights(){
    }

    public UserRights(String rightName) {
        this.rightName = rightName;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
