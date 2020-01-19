package net.lovholm.eksperimentarium.server.prosess;

import java.time.LocalDateTime;

public interface IdentRunnable extends Runnable {
    Long getId();

    /** Tid task ble plukket til in-memory kø. */
    LocalDateTime getCreateTime();
}
