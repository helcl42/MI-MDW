/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */


package entity;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import java.util.List;


public class DAO {
    static {
        ObjectifyService.register(Customer.class);
        ObjectifyService.register(Account.class);
    }

    private Objectify objectify;

    private DAO() {
    }

    public static DAO getInstance() {
        DAO dao = new DAO();
        dao.objectify = ObjectifyService.begin();
        return dao;
    }


    public <T> Key<T> getKey(Class<T> type, Long id) {
        return new Key<T>(type, id);
    }


    public <T> List<T> getAllByClass(Class<T> type) {
        Query<T> result = objectify.query(type);
        return result.list();
    }

    public <T> void saveEntity(T e) {
        objectify.put(e);
    }

    public Customer getUserByUsernameAndPassword(String username, String password) {
        Query<Customer> result = objectify.query(Customer.class).filter("username", username).filter("password", password);
        List<Customer> list = result.list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public <T> T getEntity(Key<T> key) {
        return objectify.get(key);
    }

    public <T> T getEntityByID(Class<T> type,Long id) {
        Query<T> q = objectify.query(type).filter("id", id);
        return q.list().get(0);
    }
}

