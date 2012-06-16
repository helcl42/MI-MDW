/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Coach;


@XmlRootElement(name = "coaches")
public class CoachesConverter {

    private List<CoachConverter> coaches;

    public CoachesConverter() {
        coaches = new ArrayList<CoachConverter>();
    }

    @XmlElement(name = "coach")
    public List<CoachConverter> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        for (Coach c : coaches) {
            this.coaches.add(new CoachConverter(c));
        }
    }

}

