/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */

package model.facade;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceException;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.Admin;
import model.Coach;
import model.Customer;
import model.DAO;
import model.Destination;
import model.Reservation;
import model.RoleEnum;
import model.Route;
import model.User;
import servlet.TopUpCreditException;
import util.DateUtil;
import util.HashUtil;
import util.WebserviceKeyUtil;
import validation.ValidationException;
import validation.form.ChangePasswordFormValidator;
import validation.form.CoachFormValidator;
import validation.form.DestinationFormValidator;
import validation.form.EditUserFormValidator;
import validation.form.RegFormValidator;
import validation.form.RouteFormValidator;
import rest.converters.AccountConverter;
import rest.converters.hotel.HotelReservation;
import rest.converters.hotel.HotelReservationConvertor;
import rest.converters.hotel.HotelReservationsConvertor;
import validation.form.SearchFormValidator;
import validation.form.SearchFormValidator1;
import validation.form.TopUpFormValidator;

/**
 *
 * @author Vojta
 */
public class BusinessFacade implements IBusinessFacade {

    public void createDestination(String name, String country) throws ValidationException {
        new DestinationFormValidator(name, country).validate();
        Destination d = new Destination(name, country);
        DAO.getInstance().saveEntity(d);
    }

    public boolean createReservation(Long coachId, String username) throws Exception {
        DAO dao = DAO.getInstance();
        Customer u = (Customer) dao.getUserByUsername(username);
        Coach c = dao.getEntity(Coach.class, coachId);
        if (c == null || u == null) {
            return false;
        }

        Route r = dao.getEntity(c.getRoute());
        if (u.getCredit().compareTo(r.getRoutePrice()) != -1) {
            if (!c.decreaseCapacity()) {
                throw new Exception("Nedostatečná kapacita");
            }
            Reservation newRes = new Reservation(r.getRoutePrice(), new Date(System.currentTimeMillis()),
                    c.getKey(), u.getKey());
            u.decreaseCredit(r.getRoutePrice());
            dao.updateEntity(c);
            dao.updateEntity(u);
            dao.saveEntity(newRes);
            return true;
        } else {
            return false;
        }

    }

    public List<Destination> getAllDestinations() {
        return DAO.getInstance().getAllByClass(Destination.class);
    }

    public void createRoute(String departure, String arrival, String price, String distance) throws ValidationException {
        new RouteFormValidator(distance, price).validate();
        DAO dao = DAO.getInstance();
        Route r = new Route(Double.parseDouble(price),
                Integer.parseInt(distance),
                dao.getKey(Destination.class, Long.parseLong(departure)),
                dao.getKey(Destination.class, Long.parseLong(arrival)));
        dao.saveEntity(r);
    }

    public List<Route> getAllRoutes() {
        return DAO.getInstance().getAllByClass(Route.class);
    }

    public void createCoach(String departure, String arrival, String route, String capacity) throws ValidationException {
        try {
            new CoachFormValidator(departure, arrival, capacity).validate();
            DAO dao = DAO.getInstance();
            Date departureDate = DateUtil.parseDate(departure);
            Date arrivalDate = DateUtil.parseDate(arrival);
            if (departureDate.after(arrivalDate)) {
                throw new ValidationException("Datum odjezdu musí být před datem příjezdu.");
            }
            Coach c = new Coach(Integer.parseInt(capacity), departureDate, arrivalDate, dao.getKey(Route.class, Long.parseLong(route)));
            dao.saveEntity(c);
        } catch (ParseException ex) {
            //nemuze nastat, uz je odchycena pri validaci
            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Coach> getAllCoaches() {
        return DAO.getInstance().getAllByClass(Coach.class);
    }

    public void registerCustomer(String username, String name, String surname, String account, String password1, String password2) throws ValidationException {
        RegFormValidator validator = new RegFormValidator(username, name, surname, account, password1, password2);
        validator.validate();
        String hashPassword = HashUtil.Sha1(password1);
        Customer user = new Customer(name, surname, username, hashPassword, Integer.parseInt(account), new Double(0));
        DAO.getInstance().saveEntity(user);
    }

    public List<Customer> getAllCustomers() {
        return DAO.getInstance().getAllByClass(Customer.class);
    }

    public List<Admin> getAllAdmins() {
        return DAO.getInstance().getAllByClass(Admin.class);
    }

    public User getUserById(String id) {
        return DAO.getInstance().getEntity(User.class, Long.parseLong(id));
    }

    public User updateUser(String id, String name, String surname, String account) throws ValidationException {
        DAO dao = DAO.getInstance();
        User u = dao.getEntity(User.class, Long.parseLong(id));
        new EditUserFormValidator(name, surname, account).validate();
        u.setName(name);
        u.setSurname(surname);
        if (u.getRole() == RoleEnum.CUSTOMER) {
            Customer cust = (Customer) u;
            cust.setAccount(Integer.parseInt(account));
            dao.saveEntity(cust);
        } else {
            dao.saveEntity(u);
        }
        return u;
    }

    public User changePassword(String id, String password1, String password2) throws ValidationException {
        DAO dao = DAO.getInstance();
        User u = dao.getEntity(User.class, Long.parseLong(id));
        new ChangePasswordFormValidator(password1, password2).validate();
        u.setPassword(HashUtil.Sha1(password1));
        dao.saveEntity(u);
        return u;
    }

    public boolean deleteReservation(Long resId) {
        DAO dao = DAO.getInstance();
        Reservation r = dao.getEntity(Reservation.class, resId);
        if (r == null) {
            return false;
        }

        Customer c = dao.getEntity(r.getCustomer());
        dao.deleteEntity(r);
        c.increaseCredit(r.getPrice());
        dao.updateEntity(c);
        return true;
    }

    public List<Coach> searchCoaches(String from, String to, String departureTime) throws Exception {
        SearchFormValidator sfv = new SearchFormValidator(departureTime, from, to);
        sfv.validate();
        DAO dao = DAO.getInstance();
        return dao.searchCoaches(from, to, departureTime);
    }

    public HotelReservation getReservationById(Long coachId,List<HotelReservation> reservations) {

        for (HotelReservation r :reservations) {
            if (r.getIdCoach().equals(coachId)) {
                return r;
            }
        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        DAO dao = DAO.getInstance();
        return dao.getAllByClass(Reservation.class);
    }

    public List<Reservation> getReservationsByCustomer(String userName) {
        DAO dao = DAO.getInstance();
        return dao.getReservationsByCustomer(userName);
    }

    public User TopUpCreditAternative(String credit, User u) throws Exception {
        TopUpFormValidator ticfv = new TopUpFormValidator(credit);
        ticfv.validate();
        DAO dao = DAO.getInstance();
        ((Customer) u).increaseCredit(Double.parseDouble(credit));
        dao.updateEntity(u);
        return (u);
    }

    public User topUpCredit(String credit, User u) throws Exception {
        TopUpFormValidator ticfv = new TopUpFormValidator(credit);
        ticfv.validate();
        DAO dao = DAO.getInstance();
        AccountConverter ac = new AccountConverter();
        ac.setMoney(Double.parseDouble(credit));
        JAXBContext ctx = JAXBContext.newInstance(AccountConverter.class);
        URL url = new URL("http://bankahelcl42.appspot.com/webservice/accounts/" + ((Customer) u).getAccount());
        HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
        conn2.setRequestMethod("POST");
        conn2.setDoOutput(true);
        conn2.setRequestProperty("Content-type", "application/xml");
        conn2.setRequestProperty("key", WebserviceKeyUtil.getKey(u.getUsername()));
        OutputStream out = conn2.getOutputStream();
        Marshaller m = ctx.createMarshaller();
        m.marshal(ac, out);
        out.close();
        conn2.connect();
        switch (conn2.getResponseCode()) {
            case 200:
                ((Customer) u).increaseCredit(Double.parseDouble(credit));
                dao.updateEntity(u);
                return u;
            case 304:
                throw new TopUpCreditException("Na účtu je nedostatek peněz.");
            case 401:
                throw new TopUpCreditException("Uživatel nebyl autorizován na straně banky.");
            case 500:
                throw new TopUpCreditException("Chyba na straně banky.");
            default:
                throw new TopUpCreditException("Chyba pri dobijeni kreditu");
        }
    }

    public void refreshSession(HttpServletRequest request, String username) {
        DAO dao = DAO.getInstance();
        User u = dao.getUserByUsername(username);
        request.getSession().setAttribute("user", u);
    }

    public List<Coach> searchCoaches(String from, String to) throws Exception {
        SearchFormValidator1 sfv = new SearchFormValidator1(from, to);
        sfv.validate();

        String cacheKey = HashUtil.Sha1(from + to);
        List<Coach> coaches;
        try {
            MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
            if (memcache.contains(cacheKey)) {
                coaches = (List<Coach>) memcache.get(cacheKey);
                return coaches;
            }
        } catch (MemcacheServiceException e) {
            e.printStackTrace();
        }
        coaches = DAO.getInstance().searchCoaches(from, to);

        try {
            MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
            memcache.put(cacheKey, coaches);
        } catch (MemcacheServiceException e) {
            e.printStackTrace();

        }
        return coaches;
    }

    public List<HotelReservation> getAllReservationByHotelSystem() throws JAXBException, MalformedURLException, IOException {
        HttpURLConnection connection;
        URL url = new URL("http://fit-mdw-ws11-107-2.appspot.com/resources/services/reservationCar");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/xml");
        connection.connect();
        JAXBContext context = JAXBContext.newInstance(HotelReservationsConvertor.class);
        Unmarshaller um = context.createUnmarshaller();
        HotelReservationsConvertor reservationsConvertor = (HotelReservationsConvertor) um.unmarshal(connection.getInputStream());
        return reservationsConvertor.getResult();
    }

    public void reserveCoach(Long coachId,boolean reservation) throws Exception {
        DAO dao = DAO.getInstance();
        Coach c = dao.getEntity(Coach.class, coachId);
        if (reservation)
            c.reserve();
        else
            c.clearReservation();
        dao.updateEntity(c);
    }

    public void updateHotelReservation(Long newCoachId, Long oldCoachId) throws Exception {
        List<HotelReservation> reservations = getAllReservationByHotelSystem();
        DAO dao = DAO.getInstance();
        Coach newCoach = dao.getEntity(Coach.class, newCoachId);
        Coach oldCoach = dao.getEntity(Coach.class, oldCoachId);
        HotelReservation r = getReservationById(oldCoachId, reservations);
        r.setArrivalTime(newCoach.getArrivalTime());
        r.setDepartureTime(newCoach.getDepartureTime());
        r.setIdCoach(newCoach.getId());
        HotelReservationConvertor hrc = new HotelReservationConvertor(r);
        JAXBContext ctx = JAXBContext.newInstance(HotelReservationConvertor.class);
        URL url = new URL("http://fit-mdw-ws11-107-2.appspot.com/resources/services/reservationUpdate");
        HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
        conn2.setRequestMethod("PUT");
        conn2.setDoOutput(true);
        conn2.setRequestProperty("Content-type", "application/xml");
        OutputStream out = conn2.getOutputStream();
        Marshaller m = ctx.createMarshaller();
        m.marshal(hrc, out);
        out.close();
        conn2.connect();
        int resp = conn2.getResponseCode();
        switch (resp) {
            case 200:
                oldCoach.clearReservation();
                newCoach.reserve();
                dao.saveEntities(oldCoach,newCoach);
                break;
            default:
                throw new Exception("Chyba na straně hotelového systému.");
        }
    }
}

