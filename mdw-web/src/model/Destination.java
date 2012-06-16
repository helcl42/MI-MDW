/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:56 AM
 * To change this template use File | Settings | File Templates.
 */


package model;

import com.googlecode.objectify.Key;

import javax.persistence.Id;


public class Destination {

    @Id
    private Long id;
    private String name;
    private String country;

    public Destination() {
    }

    public Destination(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Key<Destination> getKey() {
        DAO dao = DAO.getInstance();
        return dao.getKey(Destination.class, id);
    }

    @Override
    public String toString() {
        return "Destination{" + "id=" + id + ", name=" + name + ", country=" + country + '}';
    }

    public String getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

