/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */


package validation.form;

import validation.DateValidator;
import validation.StringValidator;


public class SearchFormValidator extends BasicFormValidator {

    public SearchFormValidator(String departureTime, String From, String To) {
        validators.add(new DateValidator("Čas a datum odjezdu", departureTime));
        validators.add(new StringValidator("Odkud", From));
        validators.add(new StringValidator("Kam", To));
    }


}

