/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */

package model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Subclass;


@Subclass
public class Customer extends User {

    private Double credit;
    private Integer account;

    public Customer() {
        this.role = RoleEnum.CUSTOMER;
    }

    public Customer(String name, String surname, String username, String password, Integer account, Double credit) {
        super(name, surname, username, password);
        this.credit = credit;
        this.account = account;
        this.role = RoleEnum.CUSTOMER;
    }

    public Key<Customer> getKey() {
        return DAO.getInstance().getKey(Customer.class, id);
    }


    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name +
                ", surname=" + surname + ", username=" +
                username + ", password=" + password + ", credit=" + credit + '}';
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public void increaseCredit(Double credit) {
        this.credit += credit;
    }

    public void decreaseCredit(Double credit) {
        this.credit -= credit;
    }
}
