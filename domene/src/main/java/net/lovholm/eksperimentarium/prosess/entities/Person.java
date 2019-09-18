package net.lovholm.eksperimentarium.prosess.entities;

import net.lovholm.eksperimentarium.BaseEntitet;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class Person extends BaseEntitet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fornavn")
    private String fornavn;

    @Column(name = "etternavn")
    private String etternavn;

    @Column(name = "telefonnummer")
    @Pattern(regexp = "[0-9]{8}")
    private String telefonummer;

    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;


    protected Person() {}

    public Person(String fornavn, String etternavn, String telefonummer) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonummer = telefonummer;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getTelefonummer() {
        return telefonummer;
    }

    public String getSammensattnavn() {
        return "" + fornavn + " " + etternavn;
    }

    public static final PersonBygger builder() {
        return new PersonBygger();
    }

    public static class PersonBygger {
        private Person kladd;

        public PersonBygger() {
            kladd = new Person();
        }

        public PersonBygger medFornavn(String fornavn){
            this.kladd.fornavn = fornavn;
            return this;
        }

        public PersonBygger medEtternavn(String etternavn){
            this.kladd.etternavn = etternavn;
            return this;
        }

        public PersonBygger medTelefonnummer(String telefonnummer){
            this.kladd.telefonummer = telefonnummer;
            return this;
        }

        public Person bygg() {
            return this.kladd;
        }


    }

}
