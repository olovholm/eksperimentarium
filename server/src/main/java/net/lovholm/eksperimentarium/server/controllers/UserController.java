package net.lovholm.eksperimentarium.server.controllers;


import net.lovholm.eksperimentarium.prosess.entities.Person;
import net.lovholm.eksperimentarium.prosess.entities.Postadresse;
import net.lovholm.eksperimentarium.prosess.services.PersonService;
import net.lovholm.eksperimentarium.server.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

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

    @RequestMapping(method = RequestMethod.GET, path = "/me")
    public ResponseEntity<OAuth2AuthenticationToken> getMe(OAuth2AuthenticationToken token){
        return ResponseEntity.ok(token);
    }


}
