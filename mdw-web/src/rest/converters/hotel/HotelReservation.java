/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:17 AM
 * To change this template use File | Settings | File Templates.
 */

package rest.converters.hotel;

import java.util.Date;


public class HotelReservation {

    private Integer idReservation;
    private String firstName;
    private String surName;
    private String city;
    private String nameFacility;
    private String street;
    private Integer houseNumber;
    private String nameRoom;
    private Long idCoach;
    private String phoneNumber;
    private String postCode;
    private String stateCustomer;
    private Date fromDate;
    private String toDate;


    private String totalPrice;
    private String typePaid;
    private Date createdDate;
    private String email;
    private String description;

    private String from;
    private Date departureTime;
    private Date arrivalTime;
    private String to;
    private Integer distance;
    private Double routePrice;

    @Override
    public String toString() {
        return "HotelReservation{" + "idReservation=" + idReservation +
                ", departureTime: " + departureTime + ", arrivalTime:" + arrivalTime + ", firstName=" + firstName + ", surName=" + surName + ", city=" + city + ", nameFacility=" + nameFacility + ", street=" + street + ", houseNumber=" + houseNumber + ", nameRoom=" + nameRoom + ", idCar=" + idCoach + ", phoneNumber=" + phoneNumber + ", postCode=" + postCode + ", stateCustomer=" + stateCustomer + ", totalPrice=" + totalPrice + ", typePaid=" + typePaid + ", createdDate=" + createdDate + ", email=" + email + ", description=" + description + ", from=" + from + ", fromDate=" + fromDate + ", to=" + to + ", toDate=" + toDate + "distance=" + distance + ", routePrice=" + routePrice + '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Long getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(Long idCoach) {
        this.idCoach = idCoach;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Double getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(Double routePrice) {
        this.routePrice = routePrice;
    }

    public String getStateCustomer() {
        return stateCustomer;
    }

    public void setStateCustomer(String stateCustomer) {
        this.stateCustomer = stateCustomer;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTypePaid() {
        return typePaid;
    }

    public void setTypePaid(String typePaid) {
        this.typePaid = typePaid;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

