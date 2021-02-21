package com.gmail.edmowskaa.urlshortener;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortenerController {
    private final String externalUrl = "http://127.0.0.1:8080/";
    public UrlCache cache = new UrlCache();

    @RequestMapping("/short")
    public String index(@RequestParam(value = "url") String url) {
        String short_url = UrlShortener.short_url(url);
        cache.set(short_url, url);
        return externalUrl + "v/" + short_url;
    }

    @RequestMapping(path = "/v/{url_hash}")
    public RedirectView view(@PathVariable("url_hash") String url_hash) {
        String full_url = cache.get(url_hash);
        return new RedirectView(full_url);
    }
}
