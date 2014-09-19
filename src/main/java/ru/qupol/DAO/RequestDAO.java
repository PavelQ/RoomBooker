package ru.qupol.DAO;

import ru.qupol.emHelper;
import ru.qupol.model.Request;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 27.04.2014.
 */

public class RequestDAO implements RequestDAOLocal {
    EntityManager em = emHelper.getEm();

    @Override
    public void addRequest(Request request) {
        em.persist(request);
    }

    @Override
    public void editRequest(Request request) {
        em.merge(request);
    }

    @Override
    public void deleteRequest(int requestID) {
        em.remove(getRequest(requestID));
    }

    @Override
    public Request getRequest(int requestID) {
        return em.find(Request.class, requestID);
    }

    /**
     * Generate list of requests <b>starts</b> between <code>dateFrom</code> and <code>dateTo</code>
     *
     * @return list of requests
     */
    @Override
    public List<Request> getRequests(Date dateFrom, Date dateTo) {
        Query q = em.createQuery("SELECT r FROM Request r WHERE dateFrom BETWEEN :df AND :dt", Request.class);
        q.setParameter("df", dateFrom);
        q.setParameter("dt", dateTo);
        List<Request> requests = q.getResultList();
        return requests;
    }

    @Override
    public List<Request> getRequests() {
        return em.createNamedQuery("Request.getAll", Request.class).getResultList();
    }

    /**
     * Generate list of requests <b>starts</b> in this month
     * if current date 10.04.2014, you get requests <b>Starts</b>
     * from 1.04.2014:00:00:00
     * to 30.04.2014:23:59:59
     *
     * @return list of requests
     */
    @Override
    public List<Request> getThisMonthRequests() {
        Date now = new Date();
        Date fromDate = new Date(now.getYear(), now.getMonth(), 1);
        Date toDate = new Date(now.getYear(), now.getMonth() + 1, 1, 0, 0, -1);//last second of this month
        return getRequests(fromDate, toDate);
    }


}
