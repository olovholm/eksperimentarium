package net.lovholm.eksperimentarium.prosess.services;

import net.lovholm.eksperimentarium.GenericJpaDao;
import net.lovholm.eksperimentarium.prosess.entities.Adresse;
import net.lovholm.eksperimentarium.prosess.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {

    GenericJpaDao dao;

    AdresseService(@Autowired GenericJpaDao dao){
        this.dao = dao;
        dao.setClazz(Person.class);
    }

    public void lagreAdresse(Adresse adresse){
        dao.create(adresse);
    }

    public List<Person> hentAlleAdresser(){
        return dao.findAll();
    }

}
