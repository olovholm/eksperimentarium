package net.lovholm.eksperimentarium.server.dto;

import net.lovholm.eksperimentarium.prosess.entities.Person;

public class PersonOversetter {

    public static Person fraDto(PersonDTO personDTO) {
        Person person = Person.builder()
                .medFornavn(personDTO.getFornavn())
                .medEtternavn(personDTO.getEtternavn())
                .medTelefonnummer(personDTO.getTelefonnummer())
                .bygg();
        return person;
    }
}
