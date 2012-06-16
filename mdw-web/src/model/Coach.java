/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:55 AM
 * To change this template use File | Settings | File Templates.
 */

package model;

import com.googlecode.objectify.Key;

import javax.persistence.Id;
import java.util.Date;


public class Coach {

    @Id
    private Long id;
    private Integer capacity;
    private Date departureTime;
    private Date arrivalTime;
    private boolean reserved;
    private Key<Route> route;

    public Coach() {
        this.reserved = false;
    }

    public Coach(Integer capacity, Date departureTime, Date arrivalTime) {
        this.capacity = capacity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Coach(Integer capacity, Date departureTime, Date arrivalTime, Key<Route> route) {
        this.capacity = capacity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = route;
    }

    public Key<Coach> getKey() {
        return DAO.getInstance().getKey(Coach.class, id);
    }

    @Override
    public String toString() {
        return "Coach{" + "id=" + id + ", capacity=" + capacity + ", departureTime=" +
                departureTime + ", arrivalTime=" + arrivalTime + '}';
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public boolean decreaseCapacity() {
        if (capacity == 0) {
            return false;
        } else {
            capacity--;
            return true;
        }
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

    public void clearReservation() {
        this.reserved = false;
    }

    public void increaseCapacity() {
        capacity++;
    }

    public Long getId() {
        return id;
    }

    public Key<Route> getRoute() {
        return route;
    }

}

