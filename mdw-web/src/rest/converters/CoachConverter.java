/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:10 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import model.Coach;
import model.DAO;
import model.Route;


@XmlType(name = "coach", propOrder = {"id", "routePrice", "distance", "departureTime", "arrivalTime", "capacity"})
public class CoachConverter {

    private Coach coach;
    private Route route;
    private DAO dao;

    public CoachConverter() {
    }

    public CoachConverter(Coach coach) {
        dao = DAO.getInstance();
        route = dao.getEntity(coach.getRoute());
        this.coach = coach;
    }

    @XmlElement
    public Date getArrivalTime() {
        return coach.getArrivalTime();
    }

    @XmlElement
    public Integer getDistance() {
        return route.getDistance();
    }

    @XmlElement
    public Double getRoutePrice() {
        return route.getRoutePrice();
    }

    @XmlElement
    public Integer getCapacity() {
        return coach.getCapacity();
    }

    @XmlElement
    public Date getDepartureTime() {
        return coach.getDepartureTime();
    }

    @XmlElement
    public Long getId() {
        return coach.getId();
    }
}

