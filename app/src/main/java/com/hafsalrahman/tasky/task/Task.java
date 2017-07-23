package com.hafsalrahman.tasky.task;

/**
 * Created by hafsal on 7/23/17.
 */

public class Task {

    private final String taskId;
    private final String createdAt;
    private final String title;
    private final String description;
    private final String status;

    public Task(String taskId, String createdAt, String title, String description, String status) {
        this.taskId = taskId;
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
}
