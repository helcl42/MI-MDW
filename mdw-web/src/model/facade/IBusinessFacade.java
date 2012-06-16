/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:00 AM
 * To change this template use File | Settings | File Templates.
 */

package model.facade;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import model.Admin;
import model.Coach;
import model.Customer;
import model.Destination;
import model.Reservation;
import model.Route;
import model.User;
import rest.converters.hotel.HotelReservation;
import validation.ValidationException;


public interface IBusinessFacade {

    public void refreshSession(HttpServletRequest request, String username);

    //Create operations
    public void createDestination(String name, String country) throws ValidationException;

    public void createRoute(String departure, String arrival, String price, String distance) throws ValidationException;

    public void createCoach(String departureDate, String arrivalDate, String route, String capacity) throws ValidationException;

    public void registerCustomer(String username, String name, String surname, String account, String password1, String password2) throws ValidationException;

    public boolean createReservation(Long coachId, String usename) throws Exception;

    //Read operations
    public List<Coach> searchCoaches(String from, String to, String departureTime) throws Exception;

    public List<Coach> searchCoaches(String from, String to) throws Exception;

    public List<Destination> getAllDestinations();

    public List<Route> getAllRoutes();

    public List<Coach> getAllCoaches();

    public List<Customer> getAllCustomers();

    public List<Admin> getAllAdmins();

    public List<Reservation> getAllReservations();

    public List<Reservation> getReservationsByCustomer(String username);

    public User getUserById(String id);

    public HotelReservation getReservationById(Long coachId, List<HotelReservation> reservations);

    public List<HotelReservation> getAllReservationByHotelSystem() throws JAXBException, MalformedURLException, IOException;

    //Update operations
    public User updateUser(String id, String name, String surname, String account) throws ValidationException;

    public User changePassword(String id, String password1, String password2) throws ValidationException;

    public User topUpCredit(String credit, User u) throws Exception;

    public User TopUpCreditAternative(String credit, User u) throws Exception;

    public void reserveCoach(Long coachId, boolean reservation) throws Exception;

    public void updateHotelReservation(Long newCoachId, Long oldCoachId) throws Exception;


    //Delete operations
    public boolean deleteReservation(Long resId);
}
