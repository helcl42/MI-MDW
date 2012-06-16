/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:09 AM
 * To change this template use File | Settings | File Templates.
 */


package rest.converters;

import java.net.URI;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "account")
public class AccountConverter {
    Double money;
    private URI uri;

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

