/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:58 AM
 * To change this template use File | Settings | File Templates.
 */

package model;


public enum RoleEnum {

    CUSTOMER("Customer"),
    ADMIN("Admin");

    private final String role;

    private RoleEnum(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}

