/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */

package entity;

import com.googlecode.objectify.Key;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Key<Account> account;

    public Customer() {
    }



    public Customer(String name, String surname, String username, String password, Key<Account> account) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Key<Customer> getKey() {
        return DAO.getInstance().getKey(Customer.class, id);
    }

    public void setAccount(Key<Account> account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Key<Account> getAccount() {
        return account;
    }
}

