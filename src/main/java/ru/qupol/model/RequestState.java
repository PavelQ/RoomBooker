package ru.qupol.model;

import javax.persistence.*;

/**
 * Created by Pavl on 27.03.14.
 */
@Entity
@Table(name="Request_State")
public class RequestState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public RequestState(String name) {
        this.name = name;
    }

    public RequestState() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
