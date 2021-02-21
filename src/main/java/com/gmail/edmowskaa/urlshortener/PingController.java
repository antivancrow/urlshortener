package com.gmail.edmowskaa.urlshortener;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PingController {
    @RequestMapping("/")
    public String index() {
        return "OK";
    }
    @RequestMapping("/ping")
    public String ping() {
        return "PONG";
    }

}
