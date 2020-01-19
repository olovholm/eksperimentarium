package net.lovholm.eksperimentarium.server.prosess;

import net.lovholm.eksperimentarium.server.prosess.api.ProsessTaskData;
import net.lovholm.eksperimentarium.server.prosess.api.ProsessTaskGruppe;

import javax.persistence.EntityManager;

public class ProsessTaskRepositoryImpl {

    private EntityManager entityManager;

    public String lagre(ProsessTaskData task){
        ProsessTaskGruppe gruppe = new ProsessTaskGruppe(task);
        return lagre(gruppe);
    }

    @Override
    public String lagre(ProsessTaskGruppe sammensattTask) {
        String unikGruppeId = null;

        boolean lifecycleOpprettet = true;
        for (Entry entry : sammensattTask.getTasks()) {
            ProsessTaskData task = entry.getTask();
            if (task.getId() != null) {
                lifecycleOpprettet = false;
            }

            try {
                if (unikGruppeId == null && task.getGruppe() == null) {
                    // mangler et gruppenavn så la oss finne på et
                    unikGruppeId = getUniktProsessTaskGruppeNavn(entityManager);
                }
                if (task.getGruppe() == null) {
                    // bevar eksisterende gruppenavn hvis satt, ellers bruk nytt
                    task.setGruppe(unikGruppeId);
                }
                // ta sekvens fra rekkefølge definert i gruppen
                task.setSekvens(entry.getSekvens());
                Long id = doLagreTask(task);
                task.setId(id);
            } catch (SQLException e) {
                throw TaskManagerFeil.FACTORY
                        .feilVedLagringAvProsessTask(task.getTaskType(), task.getNesteKjøringEtter(), task.getProperties(), e)
                        .toException();
            }
        }

        if (lifecycleOpprettet) {
            if (handleLifecycleObserver != null) {
                handleLifecycleObserver.opprettetProsessTaskGruppe(sammensattTask);
            }
        }

        entityManager.flush();
        return unikGruppeId;
    }



}
