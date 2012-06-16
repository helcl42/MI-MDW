/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:14 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import model.DAO;
import model.Route;


@XmlType(name = "route", propOrder = {"id", "from", "to", "distance", "routePrice"})
public class RouteConverter {
    Route route;
    DAO dao;

    public RouteConverter() {
    }

    public RouteConverter(Route route) {
        this.dao = DAO.getInstance();
        this.route = route;
    }

    @XmlElement
    public Integer getDistance() {
        return route.getDistance();
    }

    @XmlElement
    public String getFrom() {
        return dao.getEntity(route.getFrom()).getName();
    }

    @XmlElement
    public Long getId() {
        return route.getId();
    }

    @XmlElement
    public Double getRoutePrice() {
        return route.getRoutePrice();
    }

    @XmlElement
    public String getTo() {
        return dao.getEntity(route.getTo()).getName();
    }
}

