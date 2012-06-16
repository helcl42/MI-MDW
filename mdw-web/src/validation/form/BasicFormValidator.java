/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */

package validation.form;

import java.util.LinkedList;
import java.util.List;
import validation.BasicValidator;
import validation.ValidationException;
import validation.Validator;


public abstract class BasicFormValidator implements Validator {

    protected List<BasicValidator> validators;
    protected StringBuilder builder;
    protected boolean isValid;

    public BasicFormValidator() {
        validators = new LinkedList<BasicValidator>();
        builder = new StringBuilder();
        isValid = true;
    }

    public void validate() throws ValidationException {
        for (BasicValidator bv : validators) {
            try {
                bv.validate();
            } catch (ValidationException ex) {
                builder.append(ex.getMessage()).append("<br />");
                isValid = false;
            }
        }
        if (!isValid) {
            throw new ValidationException(builder.toString());
        }
    }
}

