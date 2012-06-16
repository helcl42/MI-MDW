/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */


package service;


public class Identification {
    public static boolean hasCorrectKey(String receivedKey, String username) {
        String userToHash = (username.length() > 5) ? username + username.substring(0, 5) : username + username;
        String correctKey = HashUtil.Sha1(userToHash);
        return correctKey.equalsIgnoreCase(receivedKey);
    }
}

