package net.lovholm.eksperimentarium.prosess.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bostedsadresse")
public class Bostedsadresse extends Adresse {
}
