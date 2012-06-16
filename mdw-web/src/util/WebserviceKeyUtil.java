/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:25 AM
 * To change this template use File | Settings | File Templates.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;


public class WebserviceKeyUtil {
    public static String getKey(String username) {
        String userToHash = (username.length() > 5) ? username + username.substring(0, 5) : username + username;
        return HashUtil.Sha1(userToHash);
    }
}

