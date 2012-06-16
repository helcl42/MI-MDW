/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */


package converter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "account")
public class AccountConverter {
    Double money;

    /**
     * Creates a new instance of AccountConverter
     */
    public AccountConverter() {
    }

    /**
     * Getter for id.
     *
     * @return value for id
     */
    @XmlElement
    public Double getMoney() {
        return money;
    }

    /**
     * Setter for id.
     *
     * @param value the value to set
     */
    public void setMoney(Double value) {
        this.money = value;
    }
}
