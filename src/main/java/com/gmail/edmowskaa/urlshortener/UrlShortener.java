package com.gmail.edmowskaa.urlshortener;

import org.springframework.util.DigestUtils;

public class UrlShortener {
    private String url;
    private String hash;

    public static String short_url(String url) {
        return DigestUtils.md5DigestAsHex(url.getBytes());
    }
}
