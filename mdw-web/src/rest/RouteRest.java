/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */


package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import rest.converters.RoutesConverter;


@Path("/routes")
public class RouteRest {

    IBusinessFacade facade;

    public RouteRest() {
        facade = new BusinessFacade();
    }


    @GET
    @Produces({"application/xml"})
    public RoutesConverter get() {
        RoutesConverter rc = new RoutesConverter();
        rc.setRoutes(facade.getAllRoutes());
        return rc;
    }


}

