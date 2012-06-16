/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */


package validation.form;

import validation.IntegerValidator;


public class TopUpFormValidator extends BasicFormValidator {

    public TopUpFormValidator(String credit) {
        validators.add(new IntegerValidator("Částka", credit));
    }


}

