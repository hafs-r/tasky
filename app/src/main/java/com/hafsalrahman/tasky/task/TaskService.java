package com.hafsalrahman.tasky.task;

import java.util.List;

import retrofit2.http.GET;
import io.reactivex.Observable;


/**
 * Created by hafsal on 7/23/17.
 */

public interface TaskService {

    @GET("/tasks")
    Observable<List<Task>> getTaskList();

}
