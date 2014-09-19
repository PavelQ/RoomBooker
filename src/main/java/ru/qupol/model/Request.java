package ru.qupol.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pavl on 27.03.14.
 */
@Entity
@Table(name="requests")
@NamedQuery(name="Request.getAll",query = "SELECT r FROM Request r")
public class Request {
    @Id
    @GeneratedValue
    private int id;


    @ManyToOne()
    private User user;

    @ManyToOne
    private Room room;

    @Column(name="Date_From")
    private Date dateFrom;

    @Column(name="Date_To")
    private Date dateTo;

    @Column(name="Count_Of_People")
    private int countOfPeople;

    @ManyToOne
    private RequestState state;


    public Request(){}

    public Request(User user, Room room, Date dateFrom, Date dateTo, int countOfPeople, RequestState state) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.countOfPeople = countOfPeople;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public void setCountOfPeople(int countOfPeople) {
        this.countOfPeople = countOfPeople;
    }

    public RequestState getState() {
        return state;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    public String getFormatedDateFrom(String format){
        return FormatDate(dateFrom,format);
    }
    public String getFormatedDateTo(String format){
        return FormatDate(dateTo,format);
    }
    private String FormatDate(Date d,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }



}
