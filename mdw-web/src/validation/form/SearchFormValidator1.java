/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */


package validation.form;

import validation.StringValidator;


public class SearchFormValidator1 extends BasicFormValidator {

    public SearchFormValidator1(String From, String To) {
        validators.add(new StringValidator("Odkud", From));
        validators.add(new StringValidator("Kam", To));
    }


}

