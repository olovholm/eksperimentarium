package net.lovholm.eksperimentarium.server.prosess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Utils {


    /**
     * Thread factory which lets us configure name of pooled thread, and daemon
     * flag.
     */
    static class NamedThreadFactory implements ThreadFactory {
        private static Logger LOG = LoggerFactory.getLogger(NamedThreadFactory.class);
        private final AtomicInteger counter = new AtomicInteger(1);
        private final String prefix;
        private final boolean daemon;

        public NamedThreadFactory(String prefix, boolean daemon) {
            this.prefix = prefix;
            this.daemon = daemon;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, prefix + "_" + String.format("%03d", counter.getAndIncrement()));
            LOG.debug("Started new thread {}", t.getName());
            t.setDaemon(daemon);
            return t;
        }
    }
}
