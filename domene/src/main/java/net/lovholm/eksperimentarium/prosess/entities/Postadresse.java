package net.lovholm.eksperimentarium.prosess.entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Postadresse")
public class Postadresse extends Adresse {

    @Column(name = "adresselinje1")
    private String adresselinje1;

    @Column(name = "adresselinje2")
    private String adresselinje2;

    @Column(name = "adresselinje3")
    private String adresselinje3;

    @Column(name = "adresselinje4")
    private String adresselinje4;


}
