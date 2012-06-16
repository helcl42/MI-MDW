/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:23 AM
 * To change this template use File | Settings | File Templates.
 */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {

    public static Date parseDate(String s) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        Date d = dateFormat.parse(s);
        return d;
    }

}

