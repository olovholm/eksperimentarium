package net.lovholm.eksperimentarium.prosess.services;


import net.lovholm.eksperimentarium.GenericJpaDao;
import net.lovholm.eksperimentarium.prosess.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    GenericJpaDao dao;

    PersonService(@Autowired GenericJpaDao dao){
        this.dao = dao;
        dao.setClazz(Person.class);
    }

    public void lagrePerson(Person person){
        dao.create(person);
    }

    public List<Person> hentAllePersoner(){
        return dao.findAll();
    }
}
