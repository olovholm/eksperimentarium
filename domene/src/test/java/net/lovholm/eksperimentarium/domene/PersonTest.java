package net.lovholm.eksperimentarium.domene;
import net.lovholm.eksperimentarium.prosess.entities.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {


    @Test
    @DisplayName("Persons visningsnavn er sammensatt av fornavn og etternavn")
    public void personKanOpprettes(){
        Person person = new Person("Fornavn", "Etternavn", "123");
        Assertions.assertEquals("Fornavn Etternavn", person.getSammensattnavn(),"Persons sammensatte navn skal være fornavn + etternavn");

    }


}
