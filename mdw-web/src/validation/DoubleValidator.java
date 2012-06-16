/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */


package validation;


public class DoubleValidator extends BasicValidator {

    public DoubleValidator(String label, String value) {
        super(label, value);
    }

    @Override
    protected void specificValidate() throws ValidationException {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new ValidationException("Pole " + label + " musí být desetinné číslo.");
        }
    }
}

