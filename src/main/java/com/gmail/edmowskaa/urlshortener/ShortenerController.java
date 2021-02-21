package com.gmail.edmowskaa.urlshortener;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortenerController {
    private String externalUrl = "http://127.0.0.1:8080/";
    private String redisHost = "127.0.0.1";
    private Integer redisPort = 6379;

    @RequestMapping("/short")
    public String index(@RequestParam(value = "url") String url) {
        return externalUrl + UrlShortener.short_url(url);
    }

    @RequestMapping(path = "/v/{short}")
    public RedirectView view(@PathVariable("short") String short_url) {
        return new RedirectView("https://github.com/");
    }
}
