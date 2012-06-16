/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */

package validation.form;

import validation.DoubleValidator;
import validation.IntegerValidator;


public class RouteFormValidator extends BasicFormValidator {

    public RouteFormValidator(String distance, String price) {
        super();
        validators.add(new IntegerValidator("vzdálenost", distance));
        validators.add(new DoubleValidator("cena", price));
    }

}
