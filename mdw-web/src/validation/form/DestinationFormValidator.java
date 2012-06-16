/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */

package validation.form;

import validation.StringValidator;


public class DestinationFormValidator extends BasicFormValidator {

    public DestinationFormValidator(String name, String country) {
        super();
        validators.add(new StringValidator("jméno", name));
        validators.add(new StringValidator("země", country));
    }

}

