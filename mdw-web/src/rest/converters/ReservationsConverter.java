/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */


package rest.converters;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Reservation;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;


@XmlRootElement(name = "reservations")
public class ReservationsConverter {
    Collection<ReservationConverter> reservations;
    IBusinessFacade facade;


    public ReservationsConverter() {
        this.reservations = new ArrayList<ReservationConverter>();
        this.facade = new BusinessFacade();
    }


    @XmlElement
    public Collection<ReservationConverter> getReservation() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        for (Reservation r : reservations) {
            this.reservations.add(new ReservationConverter(r));
        }
    }
}

