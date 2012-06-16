/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:12 AM
 * To change this template use File | Settings | File Templates.
 */


package rest.converters;

import model.Coach;
import model.DAO;
import model.Reservation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;


@XmlType(name = "reservation", propOrder = {"id", "from", "to", "departureTime", "arrivalTime", "price", "created"})
public class ReservationConverter {
    Reservation entity;
    Coach coach;
    DAO dao;

    public ReservationConverter() {
        entity = new Reservation();
    }


    public ReservationConverter(Reservation entity) {
        this.entity = entity;
        this.dao = DAO.getInstance();
        this.coach = dao.getEntity(entity.getCoach());
    }

    @XmlElement
    public Long getId() {
        return entity.getId();
    }

    public void setId(Long value) {
        entity.setId(value);
    }

    @XmlElement
    public String getFrom() {
        return dao.getEntity(dao.getEntity(coach.getRoute()).getFrom()).getName();
    }

    @XmlElement
    public String getTo() {
        return dao.getEntity(dao.getEntity(coach.getRoute()).getTo()).getName();
    }

    @XmlElement
    public Date getDepartureTime() {
        return coach.getDepartureTime();
    }

    @XmlElement
    public Date getArrivalTime() {
        return coach.getArrivalTime();
    }

    @XmlElement
    public Double getPrice() {
        return entity.getPrice();
    }

    @XmlElement
    public Date getCreated() {
        return entity.getCreated();
    }

}

