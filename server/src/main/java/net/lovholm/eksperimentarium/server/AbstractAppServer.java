package net.lovholm.eksperimentarium.server;

import net.lovholm.eksperimentarium.server.prosess.TaskManager;

public abstract class AbstractAppServer {

    public AbstractAppServer() {
        startTaskService();
    }

    private void startTaskService() {
        TaskManager taskManager = new TaskManager();
        taskManager.start();
    }

}
