/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:04 AM
 * To change this template use File | Settings | File Templates.
 */

package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import rest.converters.CoachesConverter;


@Path("/coaches")
public class CoachRest {

    IBusinessFacade businessFacade;

    public CoachRest() {
        businessFacade = new BusinessFacade();
    }

    @GET
    @Produces("application/xml")
    @Path("/{from}/{to}/{day}/{mounth}/{year}/{hour}/{minute}")
    public Response getCoachesByTime(@PathParam("from") String from, @PathParam("to") String to,
                                     @PathParam("day") String day, @PathParam("mounth") String mounth,
                                     @PathParam("year") String year, @PathParam("hour") String hour,
                                     @PathParam("minute") String minute) {
        try {
            CoachesConverter coaches = new CoachesConverter();
            coaches.setCoaches(businessFacade.searchCoaches(from, to, hour + ":" + minute + " " + day + "." + mounth + "." + year));
            return Response.ok().entity(coaches).build();
        } catch (Exception ex) {
            return Response.status(404).build();
        }
    }

    @GET
    @Produces("application/xml")
    @Path("/{from}/{to}/")
    public Response getCoaches(@PathParam("from") String from, @PathParam("to") String to) {
        try {
            CoachesConverter coaches = new CoachesConverter();
            coaches.setCoaches(businessFacade.searchCoaches(from, to));
            return Response.ok().entity(coaches).build();
        } catch (Exception ex) {
            return Response.status(404).build();
        }
    }
}

