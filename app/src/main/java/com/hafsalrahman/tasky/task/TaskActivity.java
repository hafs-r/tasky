package com.hafsalrahman.tasky.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hafsalrahman.tasky.R;
import com.hafsalrahman.tasky.TaskyApplication;

import java.util.List;

import javax.inject.Inject;

public class TaskActivity extends AppCompatActivity implements TaskContract.View {


    @Inject
    TaskPresenter mainPresenter;
    private RecyclerView mTaskRecyclerView;
    private TaskAdapter mTaskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        mTaskRecyclerView = (RecyclerView) findViewById(R.id.task_recycler_view);
        mTaskRecyclerView.setHasFixedSize(true);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        DaggerTaskComponent.builder().netComponent(((TaskyApplication) getApplicationContext()).getNetComponent())
                .taskModule(new TaskModule(this)).build().inject(this);

        //Call the method in TaskPresenter to make Network Request
        mainPresenter.loadTasks();

    }

    @Override
    public void showTasks(List<Task> tasks) {

        if (mTaskAdapter == null) {
            mTaskAdapter = new TaskAdapter(tasks, R.layout.task_item_layout);
            mTaskRecyclerView.setAdapter(mTaskAdapter);
        } else {
            mTaskAdapter.updateTasks(tasks);
        }

    }

    @Override
    public void showError(String message) {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showComplete() {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Finished", Toast.LENGTH_SHORT).show();

    }
}
