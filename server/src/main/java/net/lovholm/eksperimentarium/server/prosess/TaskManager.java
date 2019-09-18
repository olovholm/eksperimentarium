package net.lovholm.eksperimentarium.server.prosess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;


public class TaskManager implements ServiceHandler {
    private static final Logger LOG = LoggerFactory.getLogger(TaskManager.class);
    private ExceutorService runtaskservice;
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
        this.runtaskservice = new TaskManager.ExceutorService();
    }

    private void startPollThreads(){
        this.pollingService = Executors.newSingleThreadScheduledExecutor(new Utils.NamedThreadFactory("test-", false));
        this.pollingService.scheduleWithFixedDelay(new TaskManager.PollAwailableTask(),2000 / 2L,2000, TimeUnit.MILLISECONDS);
    }


    class ExceutorService {
        private final ThreadPoolExecutor executor;

        ExceutorService(){
            this.executor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MICROSECONDS,
                    new ArrayBlockingQueue(2), new Utils.NamedThreadFactory("test-",true));

        }

        int remainingCapacity() {
            return executor.getQueue().remainingCapacity();
        }



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
            LOG.info("poll");
            return 0;
        }

    }

}
