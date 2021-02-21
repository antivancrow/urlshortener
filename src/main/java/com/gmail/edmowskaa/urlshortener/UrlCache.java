package com.gmail.edmowskaa.urlshortener;

import java.util.HashMap;

public class UrlCache {
    private static UrlCache urlCache;
    private HashMap<String, String> urlStore;

    UrlCache() {
        urlStore = new HashMap<String, String>();
    }

    public static UrlCache getInstance() {
        if (urlCache == null) {
            urlCache = new UrlCache();
        }

        return urlCache;
    }

    public String get(String key) {
        return urlStore.get(key);
    }

    public void set(String key, String value) {
        urlStore.put(key, value);
    }
}
