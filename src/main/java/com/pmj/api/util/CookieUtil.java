package com.pmj.api.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 彭明久
 * @since 2021-03-19
 */
public class CookieUtil {

    private static HttpServletRequest request;
    private static HttpServletResponse response;

    private static final String domain = "localhost";
    private static final String path = "/";
    private static final Integer maxAge = 3600 * 24 * 7 + 3600 * 8; //7天
    private static final Boolean httpOnly = true;
    private static final Boolean secure = true;//只应通过被 HTTPS 协议加密过的请求发送给服务端

    public static void init(HttpServletRequest req,
                            HttpServletResponse resp) {
        CookieUtil.request = req;
        CookieUtil.response = resp;
    }

    /**
     * 设置Cookie
     */
    public static void set(String key, String val) {
        Cookie cookie = new Cookie(key, val);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(httpOnly);
        cookie.setSecure(secure);
        response.addCookie(cookie);
    }

    public static String get(String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
