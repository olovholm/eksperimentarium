package net.lovholm.eksperimentarium.server.controllers;


import net.lovholm.eksperimentarium.prosess.entities.Person;
import net.lovholm.eksperimentarium.prosess.entities.Postadresse;
import net.lovholm.eksperimentarium.prosess.services.PersonService;
import net.lovholm.eksperimentarium.server.dto.PersonDTO;
import net.lovholm.eksperimentarium.server.dto.PersonOversetter;
import net.lovholm.eksperimentarium.server.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Environment environment;

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity hello() {
        return ResponseEntity.ok().body("Hello");
    }

    @RequestMapping(method = RequestMethod.GET, path="/lagre")
    public ResponseEntity lagrepersoner() {
        Person ola = new Person("Ola","Løvholm","11992244");
        ola.setAdresse(new Postadresse());
        personService.lagrePerson(new Person("Alexandra","Macovei","11002244"));
        return ResponseEntity.ok().body("Lagre");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/alle")
    public List<Person> getPersoner() {

        return personService.hentAllePersoner();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity lagrePerson(PersonDTO personDTO) throws Exception{
        Person person = PersonOversetter.fraDto(personDTO);
        try {
            personService.lagrePerson(person);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getCause());
        }
        return ResponseEntity.ok().body("Lagre");

    }


}
