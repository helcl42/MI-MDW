/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */


package service;

import converter.AccountConverter;
import entity.Account;
import entity.Customer;
import entity.DAO;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/accounts")
public class AccountResource {
    @Context
    protected UriInfo uriInfo;
    @Context
    HttpHeaders requestHeaders;

    public AccountResource() {
    }

    @POST
    @Path("/{id}")
    @Consumes({"application/xml"})
    public Response post(AccountConverter money, @HeaderParam("key") String key, @PathParam("id") String id) {
        try {
            DAO dao = DAO.getInstance();
            Account acc = dao.getEntityByID(Account.class, Long.parseLong(id));
            Customer cust = dao.getEntity(acc.getCustomer());
            if (Identification.hasCorrectKey(key, cust.getUsername())) {
                acc.decreaseBalance(money.getMoney());
                if (acc.getBalance() >= 0) {
                    dao.saveEntity(acc);
                    return Response.ok().build();
                } else {
                    acc.increaseBalance(money.getMoney());
                    return Response.notModified().build();
                }

            } else {
                return Response.status(401).build();
            }
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }


    protected Account getEntity(Long id) {
        DAO dao = DAO.getInstance();
        return dao.getEntityByID(Account.class, id);
    }

}

