/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */

package entity;

import com.googlecode.objectify.Key;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Account implements Serializable {

    @Id
    private Long id;
    private Double balance;
    private Key<Customer> customer;

    public Account() {
    }



    public Account(Double balance, Key<Customer> customer) {
        this.balance = balance;
        this.customer = customer;
    }



    public Account(Double balance) {
        this.balance = balance;
    }

    public Key<Account> getKey() {
        return DAO.getInstance().getKey(Account.class, id);
    }



    public Double getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Key<Customer> getCustomer() {
        return customer;
    }



    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void increaseBalance(Double balance) {
        this.balance+=balance ;
    }

    public void decreaseBalance(Double balance) {
        this.balance-=balance ;
    }

    public void setCustomer(Key<Customer> customer) {
        this.customer = customer;
    }
}

