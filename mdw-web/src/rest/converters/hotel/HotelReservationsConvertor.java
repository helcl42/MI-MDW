/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:21 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters.hotel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


@XmlRootElement(name = "reservationCustomers")
public class HotelReservationsConvertor {

    Collection<HotelReservationConvertor> reservations;

    public HotelReservationsConvertor() {
        reservations = new ArrayList<HotelReservationConvertor>();
    }

    @XmlElement(name = "Reservation")
    public Collection<HotelReservationConvertor> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<HotelReservationConvertor> reservations) {
        this.reservations = reservations;
    }

    public List<HotelReservation> getResult() {
        List<HotelReservation> l = new LinkedList<HotelReservation>();
        for (HotelReservationConvertor convertor : reservations) {
            l.add(convertor.getReservation());
        }
        return l;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (HotelReservationConvertor hrc : reservations) {
            builder.append(hrc.toString()).append("\n");
        }
        return builder.toString();
    }
}

