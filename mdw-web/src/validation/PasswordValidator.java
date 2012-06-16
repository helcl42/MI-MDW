/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */

package validation;


public class PasswordValidator extends BasicValidator {

    protected String passw2;

    public PasswordValidator(String label, String value1, String value2) {
        super(label, value1);
        passw2 = value2;
    }

    @Override
    protected void specificValidate() throws ValidationException {
        if (value.length() < 5) {
            throw new ValidationException("Pole " + label + " musí alespon 5 znaku.");
        }
        if (!passw2.equals(value)) {
            throw new ValidationException("Hesla musi byt stejna.");
        }
    }
}

