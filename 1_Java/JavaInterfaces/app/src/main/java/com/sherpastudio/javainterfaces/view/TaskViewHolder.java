package com.sherpastudio.javainterfaces.view;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sherpastudio.javainterfaces.R;
import com.sherpastudio.javainterfaces.model.ToDoTask;


public class TaskViewHolder extends RecyclerView.ViewHolder {

    public TextView descriptionView;
    public TextView labelsView;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        labelsView = itemView.findViewById(R.id.labels);
        descriptionView = itemView.findViewById(R.id.description);
    }

    public void onBind(@NonNull ToDoTask item) {
        descriptionView.setText(item.getDescription());
        labelsView.setText(item.getLabel());
        if(item.isDone()){
            itemView.setBackgroundColor(Color.GRAY);
            descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else{
            itemView.setBackgroundColor(Color.WHITE);
            descriptionView.setPaintFlags(0);
        }
    }
}
