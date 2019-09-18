package net.lovholm.eksperimentarium.prosess.entities;

import net.lovholm.eksperimentarium.BaseEntitet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorColumn(name = "ADRESSE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Adresse extends BaseEntitet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "land")
    private String land;

}
