package net.lovholm.eksperimentarium.domene;

import javax.validation.constraints.Pattern;

public class Person {

    private String fornavn;
    private String etternavn;

    @Pattern(regexp = "[0-9]{8}")
    private String telefonummer;

    public Person(String fornavn, String etternavn, String telefonummer) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonummer = telefonummer;
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
}
