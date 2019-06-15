package net.lovholm.eksperimentarium.server.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok().body("Hello from basic app");

        }


}
