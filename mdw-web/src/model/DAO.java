/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:55 AM
 * To change this template use File | Settings | File Templates.
 */


package model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import util.DateUtil;


public class DAO extends DAOBase {

    static {
        ObjectifyService.register(User.class);
        ObjectifyService.register(Admin.class);
        ObjectifyService.register(Customer.class);
        ObjectifyService.register(Coach.class);
        ObjectifyService.register(Destination.class);
        ObjectifyService.register(Reservation.class);
        ObjectifyService.register(Route.class);
    }

    private Objectify objectify;

    private DAO() {
    }

    public static DAO getInstance() {
        DAO dao = new DAO();
        dao.objectify = ObjectifyService.begin();
        return dao;
    }

    public User getUserByUsername(String username) {
        Query<User> result = objectify.query(User.class).filter("username", username);
        List<User> list = result.list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        Query<User> result = objectify.query(User.class).filter("username", username).filter("password", password);
        List<User> list = result.list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Coach> searchCoaches(String from, String to, String departureTime) throws ParseException {
        Date d1 = DateUtil.parseDate(departureTime);
        Date d2 = new Date(d1.getTime() + (24 * 60 * 60 * 1000));
        Destination From = objectify.query(Destination.class).filter("name", from).get();
        Destination To = objectify.query(Destination.class).filter("name", to).get();
        Route r = objectify.query(Route.class).filter("from", From).filter("to", To).get();
        Query<Coach> q = objectify.query(Coach.class).filter("route", r).filter("departureTime >", d1).filter("departureTime <", d2).filter("reserved =", false);
        return q.list();
    }

    public List<Coach> searchCoaches(String from, String to) throws ParseException {
        Destination From = objectify.query(Destination.class).filter("name", from).get();
        Destination To = objectify.query(Destination.class).filter("name", to).get();
        Route r = objectify.query(Route.class).filter("from", From).filter("to", To).get();
        Query<Coach> q = objectify.query(Coach.class).filter("route", r).filter("reserved =", false);
        return q.list();
    }

    public List<Reservation> getReservationsByCustomer(String userName) {
        Query<Customer> cust = objectify.query(Customer.class).filter("username", userName);
        if (!cust.list().isEmpty())
            return objectify.query(Reservation.class).filter("customer", cust.get()).list();
        else
            return null;
    }

    public <T> List<T> getAllByClass(Class<T> type) {
        Query<T> result = objectify.query(type);
        return result.list();
    }

    public <T> void saveEntity(T e) {
        objectify.put(e);
    }

    public <T> void saveEntities(T... e) {
        for (T t : e) {
            saveEntity(t);
        }
    }

    public <T> void deleteEntity(T e) {
        objectify.delete(e);
    }

    public <T> void updateEntity(T e) {
        objectify.put(e);
    }

    public <T> void deleteEntity(Class<T> type, Long id) {
        objectify.delete(type, id);
    }

    public <T> void updateEntity(Class<T> type, T e, Long id) {
        User tmpUser = objectify.query(User.class).filter("id", id).get();
        objectify.put(tmpUser);
    }

    public <T> T getEntity(Class<T> type, Long id) {
        return objectify.get(type, id);
    }

    public <T> T getEntity(Key<T> key) {
        return objectify.get(key);
    }

    public <T> Key<T> getKey(Class<T> type, Long id) {
        return new Key<T>(type, id);
    }

    public <T> void deleteAll(Class<T> type) {
        List<T> l = getAllByClass(type);
        for (T e : l) {
            deleteEntity(e);
        }
    }

}

