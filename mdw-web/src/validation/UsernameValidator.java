/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */

package validation;

import model.DAO;


public class UsernameValidator extends BasicValidator {

    public UsernameValidator(String label, String value) {
        super(label, value);
    }

    @Override
    protected void specificValidate() throws ValidationException {
        if(value.length() < 5)
            throw new ValidationException("Pole " + label + " musí alespon 5 znaku.");

        if(DAO.getInstance().getUserByUsername(value) != null)
            throw new ValidationException("Username " + value + " jiz existuje, zvolete prosim jine.");
    }
}

