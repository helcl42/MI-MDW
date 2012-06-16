/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:59 AM
 * To change this template use File | Settings | File Templates.
 */
package model;

import com.googlecode.objectify.Key;

import javax.persistence.Id;
import java.io.Serializable;


public class Route implements Serializable {

    @Id
    private Long id;
    private Double routePrice;
    private Integer distance;
    private Key<Destination> from;
    private Key<Destination> to;

    public Route() {
    }

    public Route(Double routePrice, Integer distance) {
        this.routePrice = routePrice;
        this.distance = distance;
    }

    public Route(Double routePrice, Integer distance, Key<Destination> from, Key<Destination> to) {
        this.routePrice = routePrice;
        this.distance = distance;
        this.from = from;
        this.to = to;
    }

    public Key<Route> getKey() {
        DAO dao = DAO.getInstance();
        return dao.getKey(Route.class, id);
    }

    @Override
    public String toString() {
        return "Route{" + "id=" + id + ", routePrice=" + routePrice + ", distance=" + distance + '}';
    }

    public Integer getDistance() {
        return distance;
    }

    public Key<Destination> getFrom() {
        return from;
    }

    public Long getId() {
        return id;
    }

    public Double getRoutePrice() {
        return routePrice;
    }

    public Key<Destination> getTo() {
        return to;
    }
}

