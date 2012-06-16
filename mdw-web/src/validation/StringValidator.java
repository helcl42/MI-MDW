/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */

package validation;


public class StringValidator extends BasicValidator {

    public StringValidator(String label, String value) {
        super(label, value);
    }

    @Override
    protected void specificValidate() throws ValidationException {

    }
}

