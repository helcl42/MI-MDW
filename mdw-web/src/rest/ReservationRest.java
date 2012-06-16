/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:05 AM
 * To change this template use File | Settings | File Templates.
 */

package rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Reservation;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import rest.converters.NewReservationConverter;
import rest.converters.ReservationsConverter;
import rest.converters.UpdateCoachConverter;


@Path("/reservations")
public class ReservationRest {
    IBusinessFacade facade;

    public ReservationRest() {
        facade = new BusinessFacade();
    }

    @GET
    @Produces({"application/xml"})
    @Path("/{username}")
    public Response listReservations(@PathParam("username") String username) {
        List<Reservation> reservations = facade.getReservationsByCustomer(username);
        if (reservations != null) {
            ReservationsConverter rc = new ReservationsConverter();
            rc.setReservations(reservations);
            return Response.status(Response.Status.OK).entity(rc).build();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    @Consumes({"application/xml"})
    public Response createReservation(NewReservationConverter newReservation) {
        try {
            boolean success = facade.createReservation(newReservation.getCoachId(), newReservation.getUsername());
            if (success)
                return Response.created(null).build();
            else
                return Response.status(500).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes("application/xml")
    @Path("/")
    public Response reserveCoach(UpdateCoachConverter c) {
        try {
            facade.reserveCoach(c.getCoachId(), Boolean.parseBoolean(c.getReservation()));
            return Response.ok().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{username}/{id}")
    public Response deleteReservation(@PathParam("id") Long id, @PathParam("username") String username) {
        try {
            boolean success = facade.deleteReservation(id);
            if (success)
                return Response.ok().build();
            else
                return Response.status(500).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}

