/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */


package validation.form;

import validation.IntegerValidator;
import validation.PasswordValidator;
import validation.StringValidator;
import validation.UsernameValidator;


public class RegFormValidator extends BasicFormValidator {

    public RegFormValidator(String usermane, String surrename,
                            String lastname, String account, String passw1, String passw2) {
        super();
        validators.add(new UsernameValidator("username", usermane));
        validators.add(new StringValidator("jmeno", lastname));
        validators.add(new StringValidator("prijmeni", surrename));
        validators.add(new IntegerValidator("account", account));
        validators.add(new PasswordValidator("heslo", passw1, passw2));
    }
}

