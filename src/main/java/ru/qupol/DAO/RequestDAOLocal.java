package ru.qupol.DAO;

import ru.qupol.model.Request;

import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 27.04.2014.
 */
public interface RequestDAOLocal {
    public void addRequest(Request request);
    public void editRequest(Request request);
    public void deleteRequest(int requestID);
    public Request getRequest(int requestID);
    public List<Request> getRequests(Date dateFrom, Date dateTo);
    public List<Request> getRequests();
    /**
     * Generate list of requests  in this month
     * if current date 10.04.2014, you get requests
     * from 1.04.2014:00:00:00
     * to 30.04.2014:23:59:59
     * @return list of requests
     */
    public List<Request> getThisMonthRequests();

}
