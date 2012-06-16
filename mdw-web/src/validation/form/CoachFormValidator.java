/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */

package validation.form;

import validation.DateValidator;
import validation.IntegerValidator;


public class CoachFormValidator extends BasicFormValidator {

    public CoachFormValidator(String departureTime, String arrivalTime, String capacity) {
        super();
        validators.add(new DateValidator("datum a čas odjezdu", departureTime));
        validators.add(new DateValidator("datum a čas příjezdu", arrivalTime));
        validators.add(new IntegerValidator("kapacita", capacity));
    }

}

