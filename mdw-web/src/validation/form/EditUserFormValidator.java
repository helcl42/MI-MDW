/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */

package validation.form;

import validation.IntegerValidator;
import validation.StringValidator;


public class EditUserFormValidator extends BasicFormValidator {

    public EditUserFormValidator(String name, String surname, String account) {
        super();
        validators.add(new StringValidator("jméno", name));
        validators.add(new StringValidator("příjmení", surname));
        validators.add(new IntegerValidator("account", account));
    }

}

