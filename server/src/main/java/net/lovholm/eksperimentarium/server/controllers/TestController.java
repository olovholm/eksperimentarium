package net.lovholm.eksperimentarium.server.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity hello(RequestBody requestBody) {

        return ResponseEntity.ok().body("Hello");


    }


}
