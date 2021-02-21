package com.gmail.edmowskaa.urlshortener;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortenerController {
    private String externalUrl = "http://127.0.0.1:8080/";
    public UrlCache cache = new UrlCache();

    @RequestMapping("/short")
    public String index(@RequestParam(value = "url") String url) {
        String short_url = UrlShortener.short_url(url);
        cache.set(short_url, url);
        return externalUrl + "v/" + short_url;
    }

    @RequestMapping(path = "/v/{short}")
    public RedirectView view(@PathVariable("short") String short_url) {
        String full_url = cache.get(short_url);
        if (!full_url.isEmpty())
            return new RedirectView("/");
        else
            return new RedirectView(full_url);
    }
}
