package com.hafsalrahman.tasky.task;

import java.util.List;

/**
 * Created by hafsal on 7/23/17.
 */

public interface TaskContract {

    interface View {

        void showTasks(List<Task> tasks);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadTasks();
    }
}
