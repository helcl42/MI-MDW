/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */

package model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Subclass;


@Subclass
public class Admin extends User {

    public Admin() {
        this.role = RoleEnum.ADMIN;
    }

    public Admin(String name, String surname, String username, String password) {
        super(name, surname, username, password);
        this.role = RoleEnum.ADMIN;
    }

    public Key<Admin> getKey() {
        return DAO.getInstance().getKey(Admin.class, id);
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", name=" + name +
                ", surname=" + surname + ", username=" +
                username + ", password=" + password + '}';
    }

}