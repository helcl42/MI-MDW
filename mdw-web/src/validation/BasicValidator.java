/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */


package validation;


public abstract class BasicValidator implements Validator {

    protected String label;
    protected String value;

    public BasicValidator(String label, String value) {
        this.label = label;
        this.value = value;
    }

    //template method
    public final void  validate() throws ValidationException {
        isEmpty();
        specificValidate();
    }

    protected final void isEmpty() throws ValidationException {
        if (value == null || value.isEmpty()) {
            throw new ValidationException("Pole " + label + " nemůže být prázdné.");
        }
    }

    protected abstract void specificValidate() throws ValidationException;
}
