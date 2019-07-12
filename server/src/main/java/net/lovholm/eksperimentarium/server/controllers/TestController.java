package net.lovholm.eksperimentarium.server.controllers;


import net.lovholm.eksperimentarium.domene.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity hello() {

        return ResponseEntity.ok().body("Hello");


    }

    @RequestMapping(method = RequestMethod.GET, path = "/alle")
    public List<Person> getPersoner() {

        List<Person> personer = new ArrayList<>();
        personer.add(new Person("test", "testersen","03923823"));
        personer.add(new Person("sadg", "testersen","235"));
        personer.add(new Person("tedfskldsst", "testersen","039252352353823"));
        personer.add(new Person("tagdest", "testersen","235235"));

        return personer;

    }


}
