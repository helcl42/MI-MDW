/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */


package validation;


public class ValidationException extends Exception {

    /**
     * Creates a new instance of <code>ValidationException</code> without detail message.
     */
    public ValidationException() {
    }


    /**
     * Constructs an instance of <code>ValidationException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ValidationException(String msg) {
        super(msg);
    }
}

