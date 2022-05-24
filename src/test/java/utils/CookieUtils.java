package utils;

public class CookieUtils {

    public static String getTokenCookie(String token) {
        return String.format("token=%s", token);
    }

}
