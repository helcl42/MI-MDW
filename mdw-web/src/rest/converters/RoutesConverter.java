/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:15 AM
 * To change this template use File | Settings | File Templates.
 */


package rest.converters;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import model.Route;


@XmlRootElement(name="routes")
public class RoutesConverter {

    Collection<RouteConverter> routes;

    public RoutesConverter() {
        this.routes = new ArrayList<RouteConverter>();
    }


    @XmlElement
    public Collection<RouteConverter> getRoute() {
        return routes;
    }

    public void setRoutes(Collection<Route> routes) {
        for (Route r:routes) {
            this.routes.add(new RouteConverter(r));
        }
    }
}

