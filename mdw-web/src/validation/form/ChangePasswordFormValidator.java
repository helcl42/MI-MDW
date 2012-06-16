/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */

package validation.form;

import validation.PasswordValidator;


public class ChangePasswordFormValidator extends BasicFormValidator {

    public ChangePasswordFormValidator(String pass1, String pass2) {
        super();
        validators.add(new PasswordValidator("heslo", pass1, pass2));
    }
}

