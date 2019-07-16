package net.lovholm.eksperimentarium;


import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntitet implements Serializable {

    private String opprettetAv;

    private LocalDateTime opprettetTidspunkt;

    private String endretAv;

    private LocalDateTime endretTidspunkt;

    @PrePersist
    protected void onCreate(){
        this.opprettetAv = "Eksperimentarium";
        this.opprettetTidspunkt = opprettetTidspunkt != null ? opprettetTidspunkt : LocalDateTime.now();
    }



}
