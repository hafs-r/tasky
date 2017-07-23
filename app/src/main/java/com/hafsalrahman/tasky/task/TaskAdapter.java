package com.hafsalrahman.tasky.task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.hafsalrahman.tasky.R;

import java.util.List;

/**
 * Created by hafsal on 7/23/17.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {


    private int itemLayout;
    private List<Task> tasks;

    public TaskAdapter(List<Task> tasks, int itemLayout) {
        this.tasks = tasks;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.title.setText(task.getTitle());
        holder.description.setText(task.getDescription());
        holder.createdAt.setText(task.getCreatedAt());
        holder.status.setText(task.getStatus());
        holder.itemView.setTag(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void updateTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView description;
        public TextView createdAt;
        public TextView status;
        public CheckedTextView statusCheck;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            createdAt = (TextView) itemView.findViewById(R.id.createdAt);
            status = (TextView) itemView.findViewById(R.id.status_text);
            statusCheck = (CheckedTextView) itemView.findViewById(R.id.status);
        }
    }
}
