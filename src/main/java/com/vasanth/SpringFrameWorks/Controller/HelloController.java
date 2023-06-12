package com.vasanth.SpringFrameWorks.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //it tells that it returns a response body
public class HelloController {
    @Value("${welcome.message}")
    private String message;
   // @RequestMapping(value = "/",method = RequestMethod.GET) //we have assigned this method to default port
    @GetMapping("/")
    public String helloWorld(){
        return message;
    }
}
