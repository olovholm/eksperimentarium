package net.lovholm.eksperimentarium.server.prosess.api;

import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Pattern;

public class ProsessTaskData implements ProsessTaskInfo {


    public static final String AKTØR_ID = "aktoerId"; // NOSONAR //$NON-NLS-1$
    public static final String BEHANDLING_ID = "behandlingId"; // NOSONAR //$NON-NLS-1$
    public static final String FAGSAK_ID = "fagsakId"; // NOSONAR //$NON-NLS-1$
    public static final String HENDELSE_PROPERTY = "hendelse"; // NOSONAR //$NON-NLS-1$


    public static final String OPPGAVE_ID = "oppgaveId";
    public static final Pattern VALID_KEY_PATTERN = Pattern.compile("[a-zA-Z0-9_\\.]+$"); //$NON-NLS-1$
    private final Properties props = new Properties();
    private final String taskType;
    private int antallFeiledeForsøk;
    private String gruppe;
    private Long id;
    private LocalDateTime nesteKjøringEtter = LocalDateTime.now();
    private Clob payload;
    private int prioritet = 1;
    private String sekvens;
    private String sisteFeil;
    private String sisteFeilKode;
    private String sisteKjøringServerProsess;
    private LocalDateTime sistKjørt;
    private ProsessTaskStatus status = ProsessTaskStatus.KLAR;


    public ProsessTaskData(String taskType) {
        this.taskType = taskType;
    }


    public void setBehandling(Long fagsakId, Long behandlingId, String aktørId) {
        Objects.requireNonNull(fagsakId, "fagsakId"); // NOSONAR //$NON-NLS-1$
        Objects.requireNonNull(behandlingId, "behandlingId"); // NOSONAR //$NON-NLS-1$
        Objects.requireNonNull(aktørId, "aktørId"); // NOSONAR //$NON-NLS-1$

        setFagsakId(fagsakId);
        setBehandlingId(behandlingId);
        setAktørId(aktørId);
    }

    public void setAktørId(String id) {
        setProperty(AKTØR_ID, id);
    }

    public void setFagsakId(Long id) {
        setProperty(FAGSAK_ID, id.toString());
    }

    protected void setBehandlingId(Long id) {
        setProperty(BEHANDLING_ID, id.toString());
    }

    public void setProperty(String key, String value) {
        if (!VALID_KEY_PATTERN.matcher(key).matches()) {
            throw new IllegalArgumentException("Invalid key:" + key); //$NON-NLS-1$
        }
        if (value == null) {
            this.props.remove(key);
        } else {
            this.props.setProperty(key, value);
        }
    }

    @Override
    public String getSisteFeil() {
        return null;
    }

    @Override
    public String getSisteFeilKode() {
        return null;
    }

    @Override
    public int getAntallFeiledeForsøk() {
        return 0;
    }

    @Override
    public LocalDateTime getSistKjørt() {
        return null;
    }

    @Override
    public String getTaskType() {
        return null;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getPropertyValue(String key) {
        return null;
    }

    @Override
    public LocalDateTime getNesteKjøringEtter() {
        return null;
    }

    @Override
    public ProsessTaskStatus getStatus() {
        return null;
    }

    @Override
    public String getGruppe() {
        return null;
    }

    @Override
    public String getSekvens() {
        return null;
    }

    @Override
    public String getAktørId() {
        return null;
    }

    @Override
    public Long getFagsakId() {
        return null;
    }

    @Override
    public Long getBehandlingId() {
        return null;
    }

    @Override
    public String getPayloadAsString() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }
}
