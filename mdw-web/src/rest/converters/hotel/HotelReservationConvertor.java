/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:20 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters.hotel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


//@XmlType(name="Reservation")
@XmlRootElement(name = "Reservation")
public class HotelReservationConvertor {
    HotelReservation reservation;

    public HotelReservationConvertor() {
        reservation = new HotelReservation();
    }

    public HotelReservationConvertor(HotelReservation reservation) {
        this.reservation = reservation;
    }

    public HotelReservation getReservation() {
        return reservation;
    }

    @Override
    public String toString() {
        return reservation.toString();
    }

    @XmlElement(name = "departureTime")
    public Date getDepartureTime() {
        return reservation.getDepartureTime();
    }

    public void setDepartureTime(Date departureTime) {
        reservation.setDepartureTime(departureTime);
    }

    @XmlElement(name = "arrivalTime")
    public Date getArrivalTime() {
        return reservation.getArrivalTime();
    }

    public void setArrivalTime(Date arrivalTime) {
        reservation.setArrivalTime(arrivalTime);
    }

    @XmlElement(name = "city")
    public String getCity() {
        return reservation.getCity();
    }

    public void setCity(String city) {
        reservation.setCity(city);
    }

    @XmlElement(name = "createdDate")
    public Date getCreatedDate() {
        return reservation.getCreatedDate();
    }

    public void setCreatedDate(Date createdDate) {
        reservation.setCreatedDate(createdDate);
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return reservation.getDescription();
    }

    public void setDescription(String description) {
        reservation.setDescription(description);
    }

    @XmlElement(name = "distance")
    public Integer getDistance() {
        return reservation.getDistance();
    }

    public void setDistance(Integer distance) {
        reservation.setDistance(distance);
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return reservation.getEmail();
    }

    public void setEmail(String email) {
        reservation.setEmail(email);
    }

    @XmlElement(name = "firstName")
    public String getFirstName() {
        return reservation.getFirstName();
    }

    public void setFirstName(String firstName) {
        reservation.setFirstName(firstName);
    }

    @XmlElement(name = "from")
    public String getFrom() {
        return reservation.getFrom();
    }

    public void setFrom(String from) {
        reservation.setFrom(from);
    }

    @XmlElement(name = "fromDate")
    public Date getFromDate() {
        return reservation.getFromDate();
    }

    public void setFromDate(Date fromDate) {
        reservation.setFromDate(fromDate);
    }

    @XmlElement(name = "houseNumber")
    public Integer getHouseNumber() {
        return reservation.getHouseNumber();
    }

    public void setHouseNumber(Integer houseNumber) {
        reservation.setHouseNumber(houseNumber);
    }

    @XmlElement(name = "idCoach")
    public Long getIdCoach() {
        return reservation.getIdCoach();
    }

    public void setIdCoach(Long idCoach) {
        reservation.setIdCoach(idCoach);
    }

    @XmlElement(name = "idReservation")
    public Integer getIdReservation() {
        return reservation.getIdReservation();
    }

    public void setIdReservation(Integer idReservation) {
        reservation.setIdReservation(idReservation);
    }

    @XmlElement(name = "nameFacility")
    public String getNameFacility() {
        return reservation.getNameFacility();
    }

    public void setNameFacility(String nameFacility) {
        reservation.setNameFacility(nameFacility);
    }

    @XmlElement(name = "nameRoom")
    public String getNameRoom() {
        return reservation.getNameRoom();
    }

    public void setNameRoom(String nameRoom) {
        reservation.setNameRoom(nameRoom);
    }

    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return reservation.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        reservation.setPhoneNumber(phoneNumber);
    }

    @XmlElement(name = "postCode")
    public String getPostCode() {
        return reservation.getPostCode();
    }

    public void setPostCode(String postCode) {
        reservation.setPostCode(postCode);
    }

    @XmlElement(name = "routePrice")
    public Double getRoutePrice() {
        return reservation.getRoutePrice();
    }

    public void setRoutePrice(Double routePrice) {
        reservation.setRoutePrice(routePrice);
    }

    @XmlElement(name = "stateCustomer")
    public String getStateCustomer() {
        return reservation.getStateCustomer();
    }

    public void setStateCustomer(String stateCustomer) {
        reservation.setStateCustomer(stateCustomer);
    }

    @XmlElement(name = "street")
    public String getStreet() {
        return reservation.getStreet();
    }

    public void setStreet(String street) {
        reservation.setStreet(street);
    }

    @XmlElement(name = "surName")
    public String getSurName() {
        return reservation.getSurName();
    }

    public void setSurName(String surName) {
        reservation.setSurName(surName);
    }

    @XmlElement(name = "to")
    public String getTo() {
        return reservation.getTo();
    }

    public void setTo(String to) {
        reservation.setTo(to);
    }

    @XmlElement(name = "toDate")
    public String getToDate() {
        return reservation.getToDate();
    }

    public void setToDate(String toDate) {
        reservation.setToDate(toDate);
    }

    @XmlElement(name = "totalPrice")
    public String getTotalPrice() {
        return reservation.getTotalPrice();
    }

    public void setTotalPrice(String totalPrice) {
        reservation.setTotalPrice(totalPrice);
    }

    @XmlElement(name = "typePaid")
    public String getTypePaid() {
        return reservation.getTypePaid();
    }

    public void setTypePaid(String typePaid) {
        reservation.setTypePaid(typePaid);
    }
}

