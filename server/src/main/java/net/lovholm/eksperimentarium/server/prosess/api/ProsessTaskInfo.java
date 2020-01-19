package net.lovholm.eksperimentarium.server.prosess.api;

import java.time.LocalDateTime;
import java.util.Properties;

public interface ProsessTaskInfo {

    String getSisteFeil();

    String getSisteFeilKode();

    int getAntallFeiledeForsøk();

    LocalDateTime getSistKjørt();

    String getTaskType();

    int getPriority();

    Long getId();

    String getPropertyValue(String key);

    LocalDateTime getNesteKjøringEtter();

    ProsessTaskStatus getStatus();

    String getGruppe();

    String getSekvens();

    String getAktørId();

    Long getFagsakId();

    Long getBehandlingId();

    String getPayloadAsString();

    Properties getProperties();

}
