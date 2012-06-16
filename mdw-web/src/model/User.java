/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:53 AM
 * To change this template use File | Settings | File Templates.
 */

package model;

import com.googlecode.objectify.annotation.Entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public abstract class User implements Serializable {

    @Id
    protected Long id;
    protected String name;
    protected String surname;
    protected String username;
    protected String password;
    @Transient
    protected RoleEnum role;

    public User() {
    }

    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name +
                ", surname=" + surname + ", username=" +
                username + ", password=" + password + '}';
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passw) {
        this.password = passw;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surr) {
        this.surname = surr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
