/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */

package validation;

import util.DateUtil;

import java.text.ParseException;


public class DateValidator extends BasicValidator {

    public DateValidator(String label, String value) {
        super(label, value);
    }

    @Override
    protected void specificValidate() throws ValidationException {
        try {
            DateUtil.parseDate(value);
        } catch (ParseException e) {
            throw new ValidationException("Pole " + label + " musí být platné datum.");
        }
    }
}

