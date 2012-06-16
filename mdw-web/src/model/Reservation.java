/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:57 AM
 * To change this template use File | Settings | File Templates.
 */

package model;


import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;

import java.util.Date;
import javax.persistence.Id;


@Entity
public class Reservation {

    @Id
    private Long id;
    private Double price;
    private Date created;
    private Key<Coach> coach;
    private Key<Customer> customer;

    public Reservation() {
    }

    public Reservation(Double price, Date created) {
        this.price = price;
        this.created = created;
    }

    public Reservation(Double price, Date created, Key<Coach> coach, Key<Customer> customer) {
        this.price = price;
        this.created = created;
        this.coach = coach;
        this.customer = customer;
    }

    public Key<Reservation> getKey() {
        return DAO.getInstance().getKey(Reservation.class, id);
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", price=" + price + ", created=" + created + '}';
    }

    public Key<Coach> getCoach() {
        return coach;
    }

    public Date getCreated() {
        return created;
    }

    public Key<Customer> getCustomer() {
        return customer;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setCoach(Key<Coach> coach) {
        this.coach = coach;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setCustomer(Key<Customer> customer) {
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

