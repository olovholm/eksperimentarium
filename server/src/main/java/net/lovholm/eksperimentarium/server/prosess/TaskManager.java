package net.lovholm.eksperimentarium.server.prosess;
import org.h2.mvstore.tx.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.*;


public class TaskManager implements ServiceHandler {
    private static final Logger LOG = LoggerFactory.getLogger(TaskManager.class);
    private IdentExceutorService runtaskservice;
    private ScheduledExecutorService pollingService;




    public TaskManager() {

    }


    @Override
    public void start() {
        LOG.info("Starting task manager service");
        this.startTaskThreads();
        this.startPollThreads();

    }


    @Override
    public void stop() {
        this.runtaskservice = null;
        this.pollingService = null;

    }

    private void startTaskThreads() {
        this.runtaskservice = new IdentExceutorService();
    }

    private void startPollThreads(){
        this.pollingService = Executors.newSingleThreadScheduledExecutor(new Utils.NamedThreadFactory("test-", false));
        this.pollingService.scheduleWithFixedDelay(new TaskManager.PollAwailableTask(),2000 / 2L,10000, TimeUnit.MILLISECONDS);
    }




    protected class PollAwailableTask implements Callable<Integer>, Runnable {

        @Override
        public void run() {
            try {
                this.call();
            } catch (Exception e) {
                LOG.error("Fatal task manager error");
            }

        }

        @Override
        public Integer call() throws Exception {
            return this.doPollingWithEntityManager();
        }

        public Integer doPollingWithEntityManager() {
            LOG.debug("poll");
            return 0;
        }

    }

    void doSinglePollingAsync() {
        if (pollingService != null) {
            //pollingService.submit(new PollAvailableTasks(), Boolean.TRUE);
        } // else - ignoreres hvis ikke startet
    }



    class IdentExceutorService {
        private final ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue(2), new Utils.NamedThreadFactory("test-",true)){ //$NON-NLS-1$

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                if (getQueue().isEmpty()) {
                    // gi oss selv en head start ifht. neste polling runde
                    doSinglePollingAsync();
                }
            }

            @Override
            protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
                throw new UnsupportedOperationException("Alle kall skal gå til andre #newTaskFor(Runnable, T value)");
            }

            @Override
            protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
                return new IdentFutureTask<T>((IdentRunnable) runnable, value);
            }

        };




        IdentExceutorService(){

        }

        int remainingCapacity() {
            return executor.getQueue().remainingCapacity();
        }



    }

    static final class IdentFutureTask<T> extends FutureTask<T> implements IdentRunnable {


        private final Long id;
        private final LocalDateTime createTime;

        IdentFutureTask(IdentRunnable runnable, T value) {
            super(runnable, value);
            this.id = runnable.getId();
            this.createTime = runnable.getCreateTime();
        }

        @Override
        public Long getId() {
            return null;
        }

        @Override
        public LocalDateTime getCreateTime() {
            return null;
        }
    }


}
