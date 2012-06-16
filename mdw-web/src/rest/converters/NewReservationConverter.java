/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */


package rest.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import model.Reservation;


@XmlType(name = "newreservation")
public class NewReservationConverter {
    Long coachId;
    String username;
    Reservation r;

    public NewReservationConverter() {
        r = new Reservation();
    }

    @XmlElement
    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

