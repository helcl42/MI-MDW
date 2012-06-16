/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "coachReservation")
public class UpdateCoachConverter {

    private Long coachId;
    private String reservation;

    public UpdateCoachConverter() {
    }

    @XmlElement
    public Long getCoachId() {
        return coachId;
    }

    @XmlElement
    public String getReservation() {
        return reservation;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public void setReservation(String reservation) {
        System.out.println(reservation);
        this.reservation = reservation;
    }
}

